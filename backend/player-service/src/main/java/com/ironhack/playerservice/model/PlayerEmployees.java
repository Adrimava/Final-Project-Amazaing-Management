package com.ironhack.playerservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class PlayerEmployees {
	@Id
	private Long employeeId;
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "player_id")
	private Player player;

	public PlayerEmployees() {
	}

	public PlayerEmployees(Long employeeId, Player player) {
		this.employeeId = employeeId;
		this.player = player;
	}

	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}
}
