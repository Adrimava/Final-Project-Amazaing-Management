package com.ironhack.finalproject.amazaingmanagement.model;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long employeeId;
	private String employeeName;
	private String photo;
	private BigDecimal productivity;
	private BigDecimal clumsiness;
	@ManyToOne
	@JoinColumn(name = "company_id")
	private Company company;
	@ManyToOne
	@JoinColumn(name = "player_id")
	private Player player;

	public Employee() {
	}

	public Employee(String employeeName, String photo, BigDecimal productivity,
					BigDecimal clumsiness, Company company, Player player) {
		this.employeeName = employeeName;
		this.photo = photo;
		this.productivity = productivity;
		this.clumsiness = clumsiness;
		this.company = company;
		this.player = player;
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

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}
}
