package com.company.employee.dto;

public class EmployeeDTO {
	private Integer id;
	private String name;
	private String role;
	private Double experience;
	private Boolean workingStatus;

	public EmployeeDTO() {

	}

	public EmployeeDTO(Integer id, String name, String role, Double experience, Boolean workingStatus) {
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
		return "EmployeeDTO [id=" + id + ", name=" + name + ", role=" + role + ", experience=" + experience
				+ ", workingStatus=" + workingStatus + "]";
	}

}
