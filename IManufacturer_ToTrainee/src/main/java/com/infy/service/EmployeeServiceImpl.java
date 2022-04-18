package com.infy.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infy.dto.EmployeeDTO;
import com.infy.exception.InfyEmployeeException;
import com.infy.repository.EmployeeRepository;
import com.infy.validator.Validator;

@Service(value="employeeService")
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
 
	@Override
	public Integer addEmployee(EmployeeDTO employee) throws InfyEmployeeException {
		Validator.validate(employee);
		EmployeeDTO repositoryEmployee=employeeRepository.getEmployeeDetails(employee.getEmployeeId());
		if(repositoryEmployee!=null) {
			throw new InfyEmployeeException("Service.EMPLOYEE_ALREADY_PRESENT");	
		}
		return employeeRepository.addEmployee(employee);
	}
	
	@Override
	public EmployeeDTO getEmployeeDetails(Integer employeeId) throws InfyEmployeeException {
		EmployeeDTO repo=employeeRepository.getEmployeeDetails(employeeId);
		if(repo == null) {
			throw new InfyEmployeeException("Service.EMPLOYEE_NOT_FOUND");
		}
		return repo;
	}
	
	@Override
	public void updateEmployee(Integer employeeId, String emailId) throws InfyEmployeeException {
		EmployeeDTO e=employeeRepository.getEmployeeDetails(employeeId);
		if(e==null) {
			throw new InfyEmployeeException("Service.EMPLOYEE_NOT_FOUND");
		}
		employeeRepository.updateEmployee(employeeId, emailId);

	}
	
	@Override
	public void deleteEmployee(Integer employeeId) throws InfyEmployeeException {
		EmployeeDTO e=employeeRepository.getEmployeeDetails(employeeId);
		if(e==null) {
			throw new InfyEmployeeException("Service.EMPLOYEE_NOT_FOUND");
		}
		employeeRepository.deleteEmployee(employeeId);
	}
}
