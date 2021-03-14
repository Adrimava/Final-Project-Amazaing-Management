package com.ironhack.companyservice.controller.dto;

import java.math.BigDecimal;

public class EmployeeDTO {
	private Long employeeId;
	private String employeeName;
	private String photo;
	private BigDecimal productivity;
	private BigDecimal clumsiness;
	private Long companyId;
	private Long playerId;

	public EmployeeDTO() {
	}

	public EmployeeDTO(String employeeName, String photo, BigDecimal productivity, BigDecimal clumsiness, Long companyId, Long playerId) {
		this.employeeName = employeeName;
		this.photo = photo;
		this.productivity = productivity;
		this.clumsiness = clumsiness;
		this.companyId = companyId;
		this.playerId = playerId;
	}

	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public BigDecimal getProductivity() {
		return productivity;
	}

	public void setProductivity(BigDecimal productivity) {
		this.productivity = productivity;
	}

	public BigDecimal getClumsiness() {
		return clumsiness;
	}

	public void setClumsiness(BigDecimal clumsiness) {
		this.clumsiness = clumsiness;
	}

	public Long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}

	public Long getPlayerId() {
		return playerId;
	}

	public void setPlayerId(Long playerId) {
		this.playerId = playerId;
	}

}
