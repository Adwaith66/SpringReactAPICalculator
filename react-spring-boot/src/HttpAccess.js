import axios from "axios";

export default axios.create({
    baseURL: "http://localhost:8080/calculate",
    headers:{
        'Content-Type': 'application/json'
    }
});
