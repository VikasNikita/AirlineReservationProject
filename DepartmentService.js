import axios from "axios";

const Department_Api_Based_Url = "http://localhost:8080/dept/getAll";

class DepartmentService {
  getDepartment() {
    return axios.get(Department_Api_Based_Url);
  }
}
export default new DepartmentService();
