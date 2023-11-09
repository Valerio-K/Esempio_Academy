import React, { Component } from "react";
import BuyerService from "../services/buyer.service.js";
import { withRouter } from '../common/with-router.js';

//edit di buyer per vatNumber
class Buyer extends Component {

    constructor(props) {
      super(props);
      this.onChangeBusinessName = this.onChangeBusinessName.bind(this);
      this.onChangeCityLocation = this.onChangeCityLocation.bind(this);
      this.onChangeEmployeesNumber = this.onChangeEmployeesNumber.bind(this);
      this.findBuyerById = this.findBuyerById.bind(this);
      this.updateBuyer = this.updateBuyer.bind(this);
      this.removeBuyer = this.removeBuyer.bind(this);
      
      this.state = {
        currentBuyer: {
          businessName: "",
          cityLocation: "",
          employeesNumber: ""
        }
      };
    }
    
    componentDidMount() {
        this.findBuyerById(this.props.router.params.vatNumber);
    }

    onChangeBusinessName(e) {
      const businessName = e.target.value;
      this.setState(prevState => ({
        currentBuyer: {
          ...prevState.currentBuyer,
          businessName: businessName
        }
      }));
    }

    onChangeCityLocation(e) {
      const cityLocation = e.target.value;
      this.setState(prevState => ({
        currentBuyer: {
          ...prevState.currentBuyer,
          cityLocation: cityLocation
        }
      }));
    }

    onChangeEmployeesNumber(e) {
      const employeesNumber = e.target.value;
      this.setState(prevState => ({
        currentBuyer: {
          ...prevState.currentBuyer,
          employeesNumber: employeesNumber
        }
      }));
    }

    findBuyerById(vatNumber) {
      BuyerService.findBuyerById(vatNumber)
        .then(response => {
          this.setState({
            currentBuyer: response.data
          });
          console.log(response.data);
        })
        .catch(e => console.log(e));
    }
  
    updateBuyer() {
      BuyerService.updateBuyer(
        this.state.currentBuyer
      )
        .then(response => {
          console.log(response.data);
          this.props.router.navigate('/buyers');
        })
        .catch(e => console.log(e));
    }
    
    removeBuyer() {    
      BuyerService.removeBuyer(this.state.currentBuyer.vatNumber)
        .then(response => {
          console.log(response.data);
          this.props.router.navigate('/buyers');
        })
        .catch(e => console.log(e));
    }
    
    render() {
      const { currentBuyer } = this.state;
      return (
        <div>
          <div className="edit-form">
            <h4>Buyer</h4>
            <form>
              <div className="form-group">
                <label htmlFor="vatNumber">Vat Number</label>
                <input
                  type="text"
                  disabled="true"
                  className="form-control"
                  id="vatNumber"
                  placeholder={this.state.currentBuyer.vatNumber}
                />
              </div>
              <div className="form-group">
                <label htmlFor="businessName">Business Name</label>
                <input
                  type="text"
                  className="form-control"
                  id="businessName"
                  value={currentBuyer.businessName}
                  onChange={this.onChangeBusinessName}
                />
              </div>
              <div className="form-group">
                <label htmlFor="cityLocation">City Location</label>
                <input
                  type="text"
                  className="form-control"
                  id="cityLocation"
                  value={currentBuyer.cityLocation}
                  onChange={this.onChangeCityLocation}
                />
              </div>
              <div className="form-group">
                <label htmlFor="employeesNumber">Employees Number</label>
                <input
                  type="text"
                  className="form-control"
                  id="employeesNumber"
                  value={currentBuyer.employeesNumber}
                  onChange={this.onChangeEmployeesNumber}
                />
              </div>
            </form>
            <button style={{margin: "10px", marginLeft: "0px"}}
              className="btn btn-danger"
              onClick={this.removeBuyer}
            >Delete</button>
            <button
              type="submit"
              className="btn btn-success"
              onClick={this.updateBuyer}
            >Update</button>
          </div>
        </div>
      );
    }
}

export default withRouter(Buyer);