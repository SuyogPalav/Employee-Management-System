package com.company.employee.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.company.employee.dto.EmployeeDTO;
import com.company.employee.exception.EmployeeNotFoundException;
import com.company.employee.exception.EmptyEmployeeException;
import com.company.employee.mapper.EmployeeMapper;
import com.company.employee.model.Employee;
import com.company.employee.repository.EmployeeRepository;
import com.company.employee.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public List<EmployeeDTO> getAllEmployees(String name) {
		List<Employee> employee = null;

		if (name == null) {
			employee = employeeRepository.findAll();
		} else {
			employee = employeeRepository.findByName(name);
		}

		List<EmployeeDTO> employeeDTO = employee.stream().map(EmployeeMapper::convertToDTO).toList();

		if (employeeDTO.isEmpty()) {
			throw new EmptyEmployeeException("Employee Database is empty");
		}
		return employeeDTO;
	}

	@Override
	public Optional<EmployeeDTO> getEmployeeById(Integer id) {
		return Optional.ofNullable(employeeRepository.findById(id).map(EmployeeMapper::convertToDTO)
				.orElseThrow(() -> new EmployeeNotFoundException("Employee with ID " + id + " not found.")));
	}

	@Override
	public EmployeeDTO createEmployee(EmployeeDTO employeeDTO) {
		// Convert DTO to entity using the mapper
		Employee employee = EmployeeMapper.convertToEntity(employeeDTO);

		// Save the entity
		Employee savedEmployee = employeeRepository.save(employee);

		// Convert the saved entity back to DTO
		return EmployeeMapper.convertToDTO(savedEmployee);
	}

	public EmployeeDTO updateEmployee(Integer id, EmployeeDTO employeeDTOs) {
		// Find the employee by ID
		Optional<Employee> employeeData = employeeRepository.findById(id);

		if (employeeData.isPresent()) {
			// Update the existing employee entity
			Employee tempEmployeeData = employeeData.get();
			tempEmployeeData.setName(employeeDTOs.getName());
			tempEmployeeData.setRole(employeeDTOs.getRole());
			tempEmployeeData.setExperience(employeeDTOs.getExperience());
			tempEmployeeData.setWorkingStatus(employeeDTOs.getWorkingStatus());

			// Save the updated employee entity
			Employee updatedEmployee = employeeRepository.save(tempEmployeeData);

			// Convert the updated entity back to DTO
			return EmployeeMapper.convertToDTO(updatedEmployee);
		} else {
			throw new EmployeeNotFoundException("Employee with ID " + id + " not found.");
		}
	}

	@Override
	public void deleteEmployee(Integer id) {
		Optional<Employee> employee = employeeRepository.findById(id);
		if (employee.isPresent()) {
			employeeRepository.deleteById(id);
		} else {
			throw new EmployeeNotFoundException("Employee with ID " + id + " not found.");
		}
	}

	@Override
	public void deleteAllEmployees() {
		long employeeCount = employeeRepository.count();
		System.out.println("HEEEEEEEEEEE" + employeeCount);
		if (employeeCount == 0) {
			throw new EmptyEmployeeException("Employee Database is empty");
		} else {
			employeeRepository.deleteAll();
		}
	}

	@Override
	public List<EmployeeDTO> findByWorkingStatus(Boolean workingStatus) {
		List<Employee> employee = employeeRepository.findByWorkingStatus(workingStatus);

		List<EmployeeDTO> employeeDTO = employee.stream().map(EmployeeMapper::convertToDTO).toList();

		if (employeeDTO.isEmpty()) {
			throw new EmployeeNotFoundException("Employee with working status " + workingStatus + " are not found.");
		}

		return employeeDTO;
	}

	@Override
	public List<EmployeeDTO> findByRoleStartingWith(String rolePrefix) {
		List<Employee> employee = employeeRepository.findByRoleStartingWith(rolePrefix);

		List<EmployeeDTO> employeeDTO = employee.stream().map(EmployeeMapper::convertToDTO).toList();

		if (employeeDTO.isEmpty()) {
			throw new EmployeeNotFoundException("Employee with role " + rolePrefix + " are not found.");
		}
		return employeeDTO;
	}

	@Override
	public List<EmployeeDTO> getAllEmployee() {
		List<Employee> employee = employeeRepository.getAllEmployee();

		List<EmployeeDTO> employeeDTO = employee.stream().map(EmployeeMapper::convertToDTO).toList();

		if (employeeDTO.isEmpty()) {
			throw new EmptyEmployeeException("Employee Database is empty");
		}
		return employeeDTO;
	}

	@Override
	public List<EmployeeDTO> getEmployeeByName(String name) {
		List<Employee> employee = employeeRepository.getEmployeeByName(name);

		List<EmployeeDTO> employeeDTO = employee.stream().map(EmployeeMapper::convertToDTO).toList();

		if (employeeDTO.isEmpty()) {
			throw new EmployeeNotFoundException("Employee with name " + name + " are not found.");
		}
		return employeeDTO;
	}

	@Override
	public List<EmployeeDTO> getEmployeesBasedOnPage(Integer pageNumber, Integer pageSize, String sortBy,
			String sortDir) {
		Sort sort = (sortDir.equalsIgnoreCase("asc")) ? Sort.by(sortBy).ascending()
				: Sort.by(sortBy).descending();

		Pageable p = PageRequest.of(pageNumber, pageSize, sort);

		Page<Employee> pageEmployee = employeeRepository.findAll(p);

		List<Employee> contentEmployee = pageEmployee.getContent();

		List<EmployeeDTO> employeeDTO = contentEmployee.stream().map(EmployeeMapper::convertToDTO).toList();

		long employeeCount = employeeRepository.count();

		if (employeeCount == 0) {
			throw new EmptyEmployeeException("Employee Database is empty");
		}
		return employeeDTO;
	}

}