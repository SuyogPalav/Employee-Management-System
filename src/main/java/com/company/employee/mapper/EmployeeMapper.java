package com.company.employee.mapper;

import com.company.employee.dto.EmployeeDTO;
import com.company.employee.model.Employee;

public class EmployeeMapper {

	// Convert Employee Entity to EmployeeDTO: Used when
	public static EmployeeDTO convertToDTO(Employee employee) {
		EmployeeDTO employeeDTOs = new EmployeeDTO(employee.getId(), employee.getName(), employee.getRole(),
				employee.getExperience(), employee.getWorkingStatus());
		return employeeDTOs;
	}

	// Convert EmployeeDTO to Employee Entity
	public static Employee convertToEntity(EmployeeDTO employeeDTO) {
		Employee employee = new Employee();

		employee.setName(employeeDTO.getName());
		employee.setRole(employeeDTO.getRole());
		employee.setExperience(employeeDTO.getExperience());
		employee.setWorkingStatus(employeeDTO.getWorkingStatus());
		return employee;
	}
}
