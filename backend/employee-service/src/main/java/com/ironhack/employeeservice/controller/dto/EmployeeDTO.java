package com.ironhack.employeeservice.controller.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class EmployeeDTO {
	@NotEmpty
	private String employeeName;
	private String photo;
	private BigDecimal productivity;
	private BigDecimal clumsiness;
	@NotNull
	private Long company;
	@NotNull
	private Long player;

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

	public Long getCompany() {
		return company;
	}

	public void setCompany(Long company) {
		this.company = company;
	}

	public Long getPlayer() {
		return player;
	}

	public void setPlayer(Long player) {
		this.player = player;
	}
}
