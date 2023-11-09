import React, { Component } from "react";
import { Routes, Route, Link } from "react-router-dom";
import "bootstrap/dist/css/bootstrap.min.css";
import AddBuyer from "./components/add-buyer.component.js";
import Buyer from "./components/buyer.component.js";
import Buyers from "./components/buyers.component.js";
import "./App.css";

class App extends Component {
  render() {
    return (
      <div>
        <nav className="navbar navbar-expand navbar-dark bg-dark">
          <Link to="https://www.linkedin.com/in/valerio-capparella-33a837229" className="navbar-brand">
            Valerio's App
          </Link>
          <div className="navbar-nav mr-auto">
            <li className="nav-item">
              <Link to={"/buyers"} className="nav-link">
                Buyers
              </Link>
            </li>
            <li className="nav-item">
              <Link to={"/add"} className="nav-link">
                Add
              </Link>
            </li>
          </div>
        </nav>

        <div className="container mt-3">
          <Routes>
            <Route path="/" element={<Buyers/>} />
            <Route path="/buyers" element={<Buyers/>} />
            <Route path="/add" element={<AddBuyer/>} />
            <Route path="/buyers/:vatNumber" element={<Buyer/>} />
          </Routes>
        </div>
      </div>
    );
  }
}

export default App;
