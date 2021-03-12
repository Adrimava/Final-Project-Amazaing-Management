package com.ironhack.amazaingmanagementedgeservice.model;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

public class Company {
	private Long companyId;
	private String companyName;
	private BigDecimal revenue;
	private BigDecimal maintenance;
	private Integer employeesNumber;
	private BigDecimal accidentRiskIndex;
	private Long businessModelId;
	private Long playerId;

	public Company() {
	}

	public Company(String companyName, BigDecimal revenue, BigDecimal maintenance,
				   Integer employeesNumber, BigDecimal accidentRiskIndex,
				   Long businessModelId, Long playerId) {
		this.companyName = companyName;
		this.revenue = revenue;
		this.maintenance = maintenance;
		this.employeesNumber = employeesNumber;
		this.accidentRiskIndex = accidentRiskIndex;
		this.businessModelId = businessModelId;
		this.playerId = playerId;
	}

	public Long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}

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

}

