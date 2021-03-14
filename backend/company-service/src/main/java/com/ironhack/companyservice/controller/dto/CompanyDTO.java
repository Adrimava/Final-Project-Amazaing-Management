package com.ironhack.companyservice.controller.dto;

import com.ironhack.companyservice.model.Company;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;

public class CompanyDTO {
	private Long companyId;
	private String companyName;
	private BigDecimal revenue;
	private BigDecimal maintenance;
	private Integer employeesNumber;
	private BigDecimal accidentRiskIndex;
	private Long businessModelId;
	private Long playerId;
	private BusinessModelDTO businessModelDetails;
	private List<EmployeeDTO> employees;

	public CompanyDTO() {
	}

	public CompanyDTO(Company company, BusinessModelDTO businessModelDetails, List<EmployeeDTO> employees) {
		this.companyId = company.getCompanyId();
		this.companyName = company.getCompanyName();
		this.revenue = company.getRevenue();
		this.maintenance = company.getMaintenance();
		this.employeesNumber = company.getEmployeesNumber();
		this.accidentRiskIndex = company.getAccidentRiskIndex();
		this.businessModelId = company.getBusinessModelId();
		this.playerId = company.getPlayerId();
		this.businessModelDetails = businessModelDetails;
		this.employees = employees;
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

	public BusinessModelDTO getBusinessModelDetails() {
		return businessModelDetails;
	}

	public void setBusinessModelDetails(BusinessModelDTO businessModelDetails) {
		this.businessModelDetails = businessModelDetails;
	}

	public List<EmployeeDTO> getEmployees() {
		return employees;
	}

	public void setEmployees(List<EmployeeDTO> employees) {
		this.employees = employees;
	}

}
