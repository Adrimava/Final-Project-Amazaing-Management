package com.ironhack.playerservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
public class PlayerCompanies {
	@Id
	private Long companyId;
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "player_id")
	private Player player;

	public PlayerCompanies() {
	}

	public PlayerCompanies(Long companyId, Player player) {
		this.companyId = companyId;
		this.player = player;
	}

	public Long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}
}
