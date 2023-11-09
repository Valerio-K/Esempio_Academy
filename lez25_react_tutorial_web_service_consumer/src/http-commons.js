import axios from "axios";

export default axios.create({
  baseURL: "http://localhost:9090/rest/api/tutorials",
  headers: {
    "Content-type": "application/json"
  }
});