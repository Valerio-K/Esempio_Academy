import axios from "axios";

export default axios.create({
  baseURL: "http://localhost:9090/rest/api/buyer",
  headers: {
    "Content-type": "application/json"
  }
});