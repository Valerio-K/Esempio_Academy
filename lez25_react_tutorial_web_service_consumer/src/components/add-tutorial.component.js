import React, { Component } from "react";
import TutorialService from "../services/tutorial.service.js";
import { withRouter } from '../common/with-router.js';

//insert di tutorial
class AddTutorial extends Component {

    constructor(props) {
      super(props);
      this.onChangeName = this.onChangeName.bind(this);
      this.onChangeTechnology = this.onChangeTechnology.bind(this);
      this.onChangeDescription = this.onChangeDescription.bind(this);
      this.saveTutorial = this.saveTutorial.bind(this);

      this.state = {
        name: "",
        technology: "",
        description: ""
      };
    }

    onChangeName(e) {
      this.setState({
        name: e.target.value
      });
    }

    onChangeTechnology(e) {
      this.setState({
        technology: e.target.value
      });
    }

    onChangeDescription(e) {
      this.setState({
        description: e.target.value
      });
    }

    saveTutorial() {
      var data = {
        name: this.state.name,
        technology: this.state.technology,
        description: this.state.description,
      };

      TutorialService.saveTutorial(data)
        .then(response => {
          this.setState({
            name: response.data.name,
            technology: response.data.technology,
            description: response.data.description
          });
          console.log(response.data);
          this.props.router.navigate('/tutorials');
        })
        .catch(e => console.log(e));
    }

    render() {
      return (
        <div className="submit-form">
          <div>
            <div className="form-group">
              <label htmlFor="name">Name</label>
              <input
                type="text"
                className="form-control"
                id="name"
                required
                value={this.state.name}
                onChange={this.onChangeName}
                name="name"
              />
            </div>
            <div className="form-group">
              <label htmlFor="title">Technology</label>
              <input
                type="text"
                className="form-control"
                id="technology"
                required
                value={this.state.technology}
                onChange={this.onChangeTechnology}
                name="technology"
              />
            </div>
            <div className="form-group">
              <label htmlFor="title">Description</label>
              <input
                type="text"
                className="form-control"
                id="description"
                required
                value={this.state.description}
                onChange={this.onChangeDescription}
                name="description"
              />
            </div>
            <br/>
            <button onClick={this.saveTutorial} className="btn btn-success">
                Submit
            </button>
          </div>
        </div>
      );
    }
}

export default withRouter(AddTutorial);