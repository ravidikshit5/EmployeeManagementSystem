import axios from "axios";
const REST_API_BASE_URL = "http://localhost:8080/emp/all";
export const listEmployees=()=>axios.get(REST_API_BASE_URL)