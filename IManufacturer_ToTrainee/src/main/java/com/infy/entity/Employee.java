package com.infy.entity;

import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

import com.infy.dto.ManufacturingUnit;

@Entity
public class Employee {
	@Id
	private Integer employeeId;
	private String emailId;
	@Column(name="employee_name")
	private String name;
	@Column(name="dob")
	private LocalDate dateOfBirth;
	@Enumerated(EnumType.STRING)
	@Column(name="manufacturing_unit")
	private ManufacturingUnit manufacturtringUnit;
	
	
	@Override
	public int hashCode() {
		return Objects.hash(dateOfBirth, emailId, employeeId, manufacturtringUnit, name);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return Objects.equals(dateOfBirth, other.dateOfBirth) && Objects.equals(emailId, other.emailId)
				&& Objects.equals(employeeId, other.employeeId) && manufacturtringUnit == other.manufacturtringUnit
				&& Objects.equals(name, other.name);
	}
	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", emailId=" + emailId + ", name=" + name + ", dateOfBirth="
				+ dateOfBirth + ", manufacturtringUnit=" + manufacturtringUnit + "]";
	}
	public Integer getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public ManufacturingUnit getManufacturtringUnit() {
		return manufacturtringUnit;
	}
	public void setManufacturtringUnit(ManufacturingUnit manufacturtringUnit) {
		this.manufacturtringUnit = manufacturtringUnit;
	}
	
} 
