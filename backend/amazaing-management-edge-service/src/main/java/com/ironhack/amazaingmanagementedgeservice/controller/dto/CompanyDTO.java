package com.ironhack.amazaingmanagementedgeservice.controller.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;

public class CompanyDTO {
	@NotEmpty
	private String companyName;
	private BigDecimal revenue;
	private BigDecimal maintenance;
	private Integer employeesNumber;
	private BigDecimal accidentRiskIndex;
	@NotNull
	private Long businessModelId;
	@NotNull
	private Long playerId;
	private List<Long> employees;

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public BigDecimal getRevenue() {
		return revenue;
	}

	public void setRevenue(BigDecimal revenue) {
		this.revenue = revenue;
	}

	public BigDecimal getMaintenance() {
		return maintenance;
	}

	public void setMaintenance(BigDecimal maintenance) {
		this.maintenance = maintenance;
	}

	public Integer getEmployeesNumber() {
		return employeesNumber;
	}

	public void setEmployeesNumber(Integer employeesNumber) {
		this.employeesNumber = employeesNumber;
	}

	public BigDecimal getAccidentRiskIndex() {
		return accidentRiskIndex;
	}

	public void setAccidentRiskIndex(BigDecimal accidentRiskIndex) {
		this.accidentRiskIndex = accidentRiskIndex;
	}

	public Long getBusinessModelId() {
		return businessModelId;
	}

	public void setBusinessModelId(Long businessModelId) {
		this.businessModelId = businessModelId;
	}

	public Long getPlayerId() {
		return playerId;
	}

	public void setPlayerId(Long playerId) {
		this.playerId = playerId;
	}

	public List<Long> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Long> employees) {
		this.employees = employees;
	}
}
