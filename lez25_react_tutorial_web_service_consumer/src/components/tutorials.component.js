import React, { Component } from "react";
import { Link } from "react-router-dom";
import TutorialService from "../services/tutorial.service.js";
import { withRouter } from '../common/with-router.js';

//stampa della lista completa
class Tutorials extends Component {

    constructor(props) {
      super(props);
      this.findAllTutorials = this.findAllTutorials.bind(this);
      
      this.state = {
        tutorials: []
      };
    }

    componentDidMount() {
      this.findAllTutorials();
    }

    findAllTutorials() {
      TutorialService.findAllTutorials()
        .then(response => {
          this.setState({
            tutorials: response.data
          });
          console.log(response.data);
        })
        .catch(e => console.log(e));
    }

    render() {
      const { tutorials } = this.state;
      
      return (
        <div className="list row">
          <div className="col-md-8">
            <div className="input-group mb-3">
            </div>
          </div>
          <div className="col-md-6">
            <h4>Tutorials</h4>
            <div class="container">
              <div class="row">
                <div class="col-12">
                  <table class="table table-bordered table-striped">
                    <thead>
                      <tr>
                        <th>Name</th>
                        <th>Technology</th>
                        <th>Description</th>
                        <th scope="col">Action</th>
                      </tr>
                    </thead>
                    <tbody>
                      {
                        tutorials &&
                        tutorials.map((tutorial, index) => (
                          <tr>
                            <td >{tutorial.name}</td>
                            <td>{tutorial.technology}</td>
                            <td>{tutorial.description}</td>
                            <td>
                              <Link
                                to={"/tutorials/" + tutorial.id}
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

export default withRouter(Tutorials);