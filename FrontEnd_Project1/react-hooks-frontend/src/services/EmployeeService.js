import axios from 'axios'

const EMPLOYEE_BASE_REST_API_URL='http://localhost:8080/api/v1/employees'
const api=axios.create({
    baseURL:EMPLOYEE_BASE_REST_API_URL,
    headers: {
        'Content-Type': 'application/json',
    },
})
class EmployeeService{
    getAllEmployees(){
        //return axios.get(EMPLOYEE_BASE_REST_API_URL)
        return api.get()
    }
    createEmployee(employee){
        //return axios.post(EMPLOYEE_BASE_REST_API_URL,employee);
        return api.post('', employee);
    }
    getEmployeeById(employeeId) {
        return api.get(`/${employeeId}`); // baseURL + '/:id'
    }
    updateEmployee(employeeId,employee){
        return api.put(`/${employeeId}`,employee);
    }
    deleteEmployee(employeeId){
        return api.delete(`/${employeeId}`);
    }
}
export default new EmployeeService();