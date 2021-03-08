package com.ironhack.finalproject.amazaingmanagement.controller.dto;

import com.ironhack.finalproject.amazaingmanagement.model.BusinessModel;
import com.ironhack.finalproject.amazaingmanagement.model.Employee;
import com.ironhack.finalproject.amazaingmanagement.model.Player;

import javax.persistence.*;
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
	private Long businessModel;
	@NotNull
	private Long player;

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

	public Long getBusinessModel() {
		return businessModel;
	}

	public void setBusinessModel(Long businessModel) {
		this.businessModel = businessModel;
	}

	public Long getPlayer() {
		return player;
	}

	public void setPlayer(Long player) {
		this.player = player;
	}

}
