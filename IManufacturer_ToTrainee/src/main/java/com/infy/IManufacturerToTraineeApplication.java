package com.infy;

import java.time.LocalDate;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

import com.infy.dto.EmployeeDTO;
import com.infy.dto.ManufacturingUnit;
import com.infy.service.EmployeeService;

@SpringBootApplication
public class IManufacturerToTraineeApplication implements CommandLineRunner {
	
	private static final Log LOGGER = LogFactory.getLog(IManufacturerToTraineeApplication.class);

	@Autowired
	Environment environment;
	@Autowired
	EmployeeService employeeService;

	public static void main(String[] args) {
		SpringApplication.run(IManufacturerToTraineeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// addEmployee();
		// getEmployeeDetails();
		//updateEmployee();
		// deleteEmployee();
	}

	public void addEmployee() {
		try {

			EmployeeDTO employeeDTO = new EmployeeDTO();
			employeeDTO.setEmployeeId(2007);
			employeeDTO.setName("Wilson");
			employeeDTO.setEmailId("wilson@mail.com");
			employeeDTO.setDateOfBirth(LocalDate.of(1996, 4, 10));
			employeeDTO.setManufacturingUnit(ManufacturingUnit.U001);

			Integer employeeId = employeeService.addEmployee(employeeDTO);

			LOGGER.info("\n"+environment.getProperty("UserInterface.INSERT_SUCCESS") + employeeId);

		} catch (Exception e) {

			LOGGER.info("\n"+environment.getProperty(e.getMessage(), "Some exception occured.Please check log file."));

		}
	}

	public void getEmployeeDetails() {
		try {

			EmployeeDTO employeeDTO = employeeService.getEmployeeDetails(2001);
			LOGGER.info("\n"+employeeDTO);

		} catch (Exception e) {
			LOGGER.info("\n"+environment.getProperty(e.getMessage(), "Some exception occured.Please check log file."));

		}
	}

	public void updateEmployee() {
		try {

			Integer employeeId = 2;
			String emailId = "husee77@mail.com";

			employeeService.updateEmployee(employeeId, emailId);

			LOGGER.info("\n"+environment.getProperty("UserInterface.UPDATE_SUCCESS"));

		} catch (Exception e) {
			LOGGER.info("\n"+environment.getProperty(e.getMessage(), "Some exception occured.Please check log file."));

		}
	}

	public void deleteEmployee() {
		try {

			employeeService.deleteEmployee(2003);

			LOGGER.info("\n"+environment.getProperty("UserInterface.DELETE_SUCCESS"));
		} catch (Exception e) {
			LOGGER.info("\n"+environment.getProperty(e.getMessage(), "Some exception occured.Please check log file."));

		}
	}

}
