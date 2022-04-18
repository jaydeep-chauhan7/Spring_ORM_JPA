package com.infy.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.infy.dto.EmployeeDTO;
import com.infy.entity.Employee;

@Repository(value="employeeRepository")
public class EmployeeRepositoryImpl implements EmployeeRepository {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public Integer addEmployee(EmployeeDTO employee) {
		Employee e=new Employee();
		e.setDateOfBirth(employee.getDateOfBirth());
		e.setEmailId(employee.getEmailId());
		e.setEmployeeId(employee.getEmployeeId());
		e.setManufacturtringUnit(employee.getManufacturingUnit());
		e.setName(employee.getName());
		entityManager.persist(e);
		return employee.getEmployeeId();
	}

	@Override
	public EmployeeDTO getEmployeeDetails(Integer employeeId) {
		EmployeeDTO e=null;
		Employee repo=entityManager.find(Employee.class, employeeId);
		if(repo !=null) {
			e=new EmployeeDTO();
			e.setDateOfBirth(repo.getDateOfBirth());
			e.setEmailId(repo.getEmailId());
			e.setEmployeeId(repo.getEmployeeId());
			e.setManufacturingUnit(repo.getManufacturtringUnit());
			e.setName(repo.getName());
			return e;
		}
		return e;
	}

	@Override
	public void updateEmployee(Integer employeeId, String emailId) {
		Employee repo=entityManager.find(Employee.class, employeeId);
		repo.setEmailId(emailId);
		entityManager.persist(repo);
	}

	@Override
	public void deleteEmployee(Integer employeeId) {
		Employee e=entityManager.find(Employee.class, employeeId);
		entityManager.remove(e);
	}
	
	
}