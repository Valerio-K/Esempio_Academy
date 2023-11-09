import React, { Component } from "react";
import BuyerService from "../services/buyer.service.js";
import { withRouter } from '../common/with-router.js';

//insert di buyer
class AddBuyer extends Component {

    constructor(props) {
      super(props);
      this.onChangeVatNumber = this.onChangeVatNumber.bind(this);
      this.onChangeBusinessName = this.onChangeBusinessName.bind(this);
      this.onChangeCityLocation = this.onChangeCityLocation.bind(this);
      this.onChangeEmployeesNumber = this.onChangeEmployeesNumber.bind(this);
      this.saveBuyer = this.saveBuyer.bind(this);

      this.state = {
        vatNumber: "",
        businessName: "",
        cityLocation: "",
        employeesNumber: ""
      };
    }

    onChangeVatNumber(e) {
      this.setState({
        vatNumber: e.target.value
      });
    }

    onChangeBusinessName(e) {
      this.setState({
        businessName: e.target.value
      });
    }

    onChangeCityLocation(e) {
      this.setState({
        cityLocation: e.target.value
      });
    }

    onChangeEmployeesNumber(e) {
      this.setState({
        employeesNumber: e.target.value
      });
    }

    saveBuyer() {
      var data = {
        vatNumber: this.state.vatNumber,
        businessName: this.state.businessName,
        cityLocation: this.state.cityLocation,
        employeesNumber: this.state.employeesNumber
      };

      BuyerService.saveBuyer(data)
        .then(response => {
          this.setState({
            vatNumber: response.data.vatNumber,
            businessName: response.data.businessName,
            cityLocation: response.data.cityLocation,
            employeesNumber: response.data.employeesNumber
          });
          console.log(response.data);
          this.props.router.navigate('/buyers');
        })
        .catch(e => console.log(e));
    }

    render() {
      return (
        <div className="submit-form">
          <div>
            <div className="form-group">
              <label htmlFor="vatNumber">Vat Number</label>
              <input
                type="text"
                className="form-control"
                id="vatNumber"
                required
                value={this.state.vatNumber}
                onChange={this.onChangeVatNumber}
                vatNumber="vatNumber"
              />
            </div>
            <div className="form-group">
              <label htmlFor="businessName">Business Name</label>
              <input
                type="text"
                className="form-control"
                id="businessName"
                required
                value={this.state.businessName}
                onChange={this.onChangeBusinessName}
                name="businessName"
              />
            </div>
            <div className="form-group">
              <label htmlFor="cityLocation">City Location</label>
              <input
                type="text"
                className="form-control"
                id="cityLocation"
                required
                value={this.state.cityLocation}
                onChange={this.onChangeCityLocation}
                name="cityLocation"
              />
            </div>
            <div className="form-group">
              <label htmlFor="employeesNumber">Employees Number</label>
              <input
                type="text"
                className="form-control"
                id="employeesNumber"
                required
                value={this.state.employeesNumber}
                onChange={this.onChangeEmployeesNumber}
                name="employeesNumber"
              />
            </div>
            <br/>
            <button onClick={this.saveBuyer} className="btn btn-success">
                Submit
            </button>
          </div>
        </div>
      );
    }
}

export default withRouter(AddBuyer);