package com.infy;

import java.time.LocalDate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.infy.dto.EmployeeDTO;
import com.infy.dto.ManufacturingUnit;
import com.infy.repository.EmployeeRepository;
import com.infy.service.EmployeeServiceImpl;


@SpringBootTest
public class IManufacturerToTraineeApplicationTests {
	@Mock
	private EmployeeRepository employeeRepository;
	
	@InjectMocks
	private EmployeeServiceImpl employeeServiceImpl = new EmployeeServiceImpl();
	
	@Test
	public void addEmployeeInvalidEmailId() throws Exception {
		EmployeeDTO e=new EmployeeDTO();
		e.setDateOfBirth(LocalDate.now());
		e.setEmailId("123");
		e.setEmployeeId(100);
		e.setManufacturingUnit(ManufacturingUnit.U001);
		e.setName("JJ");
		
		employeeRepository.addEmployee(e);
		Exception exception=Assertions.assertThrows(Exception.class,() -> employeeServiceImpl.addEmployee(e));
		Assertions.assertEquals("Validator.INVALID_EMAIL_ID", exception.getMessage());
		
	}
	@Test
	public void getEmployeeInvalidEmployeeId() throws Exception {
		int i=1;
		employeeRepository.getEmployeeDetails(i);
		Exception exception=Assertions.assertThrows(Exception.class, () -> employeeServiceImpl.getEmployeeDetails(i));
		Assertions.assertEquals("Service.EMPLOYEE_NOT_FOUND", exception.getMessage());
	}
	@Test
	public void updateEmployeeInvalidEmployeeId() throws Exception {
		int i=2;
		String str="jj@email.com";
		Exception exception=Assertions.assertThrows(Exception.class, () -> employeeServiceImpl.updateEmployee(i, str));
		Assertions.assertEquals("Service.EMPLOYEE_NOT_FOUND", exception.getMessage());
	}
	@Test
	public void deleteEmployeeInvalidEmployeeId() throws Exception {
		int i=1;
		Exception exception=Assertions.assertThrows(Exception.class, () -> employeeServiceImpl.deleteEmployee(i));
		Assertions.assertEquals("Service.EMPLOYEE_NOT_FOUND", exception.getMessage());
	}

}
