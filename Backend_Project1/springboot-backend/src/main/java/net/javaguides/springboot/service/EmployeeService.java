package net.javaguides.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.javaguides.springboot.model.Employee;
import net.javaguides.springboot.repository.EmployeeRepository;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;

	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return employeeRepository.findAll();
	}

	public Employee createEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	public Optional<Employee> getEmployeeById(long id) {
		// TODO Auto-generated method stub
		return employeeRepository.findById(id);
	}

	@Transactional
	public Optional<Employee> updateEmployee(long id, Employee employeeDetails) {
		// TODO Auto-generated method stub
		Optional<Employee> updatedEmployee=employeeRepository.findById(id);
		
//		if (updatedEmployee.isPresent()) {
//	        Employee employee = updatedEmployee.get();
//	        employee.setFirstName(employeeDetails.getFirstName());
//	        employee.setLastName(employeeDetails.getLastName());
//	        employee.setEmailId(employeeDetails.getEmailId());
//	        employeeRepository.save(employee);
//	    }
		return updatedEmployee.map(employee->{
			employee.setFirstName(employeeDetails.getFirstName());
			employee.setLastName(employeeDetails.getLastName());
			employee.setEmailId(employeeDetails.getEmailId());
			return employeeRepository.save(employee);
		});
	}

	public Optional<Employee> deleteEmployee(long id) {
		// TODO Auto-generated method stub
		Optional<Employee> employee=employeeRepository.findById(id);
		if(employee.isPresent()) {
			employeeRepository.delete(employee.get());
		}
		return employee;
		
	}
}
