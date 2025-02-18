package com.company.employee.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "employees")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name = "emp_name")
	private String name;

	@Column(name = "emp_role")
	private String role;

	@Column(name = "emp_experience")
	private Double experience;

	@Column(name = "emp_workingStatus")
	private Boolean workingStatus;

	public Employee() {

	}

	public Employee(Integer id, String name, String role, Double experience, Boolean workingStatus) {
		super();
		this.id = id;
		this.name = name;
		this.role = role;
		this.experience = experience;
		this.workingStatus = workingStatus;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Double getExperience() {
		return experience;
	}

	public void setExperience(Double experience) {
		this.experience = experience;
	}

	public Boolean getWorkingStatus() {
		return workingStatus;
	}

	public void setWorkingStatus(Boolean workingStatus) {
		this.workingStatus = workingStatus;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", role=" + role + ", experience=" + experience
				+ ", workingStatus=" + workingStatus + "]";
	}
}