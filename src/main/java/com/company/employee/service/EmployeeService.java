package com.company.employee.service;

import java.util.List;
import java.util.Optional;

import com.company.employee.dto.EmployeeDTO;

public interface EmployeeService {
	public List<EmployeeDTO> getAllEmployees(String name);

	public Optional<EmployeeDTO> getEmployeeById(Integer id);

	public EmployeeDTO createEmployee(EmployeeDTO employee);

	public EmployeeDTO updateEmployee(Integer id, EmployeeDTO employeeRequestEntity);

	public void deleteEmployee(Integer id);

	public void deleteAllEmployees();

	public List<EmployeeDTO> findByWorkingStatus(Boolean status);

	public List<EmployeeDTO> findByRoleStartingWith(String rolePrefix);

	public List<EmployeeDTO> getAllEmployee();

	public List<EmployeeDTO> getEmployeeByName(String name);

	public List<EmployeeDTO> getEmployeesBasedOnPage(Integer pageNumber, Integer pageSize, String sortBy,
			String sortDir);

}
