package com.company.employee.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.company.employee.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	public List<Employee> findByName(String name);

	public List<Employee> findByWorkingStatus(Boolean workingStatus);

	@Query("SELECT e FROM Employee e WHERE e.role LIKE CONCAT(:rolePrefix, '%')")
	public List<Employee> findByRoleStartingWith(@Param("rolePrefix") String rolePrefix);

	@Query(value = "SELECT * FROM employees", nativeQuery = true)
	public List<Employee> getAllEmployee();

	@Query(value = "SELECT * FROM employees WHERE emp_name = :n", nativeQuery = true)
	public List<Employee> getEmployeeByName(@Param("n") String name);

}