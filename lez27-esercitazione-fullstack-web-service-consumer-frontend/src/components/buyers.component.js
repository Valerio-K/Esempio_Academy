import React, { Component } from "react";
import { Link } from "react-router-dom";
import BuyerService from "../services/buyer.service.js";
import { withRouter } from '../common/with-router.js';

//stampa della lista completa di buyer
class Buyers extends Component {

    constructor(props) {
      super(props);
      this.findAllBuyers = this.findAllBuyers.bind(this);
      
      this.state = {
        buyers: []
      };
    }

    componentDidMount() {
      this.findAllBuyers();
    }

    findAllBuyers() {
      BuyerService.findAllBuyers()
        .then(response => {
          this.setState({
            buyers: response.data
          });
          console.log(response.data);
        })
        .catch(e => console.log(e));
    }

    render() {
      const { buyers } = this.state;
      
      return (
        <div className="list row">
          <div className="col-md-8">
            <div className="input-group mb-3">
            </div>
          </div>
          <div className="col-md-6">
            <h4>Buyers</h4>
            <div class="container">
              <div class="row">
                <div class="col-12">
                  <table class="table table-bordered table-striped">
                    <thead>
                      <tr>
                        <th>Vat Number</th>
                        <th>Business Name</th>
                        <th>City Location</th>
                        <th>Employees Number</th>
                        <th scope="col">Action</th>
                      </tr>
                    </thead>
                    <tbody>
                      {
                        buyers &&
                        buyers.map((buyers, index) => (
                          <tr>
                            <td>{buyers.vatNumber}</td>
                            <td>{buyers.businessName}</td>
                            <td>{buyers.cityLocation}</td>
                            <td>{buyers.employeesNumber}</td>
                            <td>
                              <Link
                                to={"/buyers/" + buyers.vatNumber}
                                className="btn btn-success"
                              >Edit</Link>
                            </td>
                          </tr>
                        ))
                      }
                    </tbody>
                  </table>
                </div>
              </div>
            </div>
          </div>
        </div>
      );
    }
}

export default withRouter(Buyers);