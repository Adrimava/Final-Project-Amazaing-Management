package com.ironhack.amazaingmanagementedgeservice.service.impl;

import com.ironhack.amazaingmanagementedgeservice.client.PlayerClient;
import com.ironhack.amazaingmanagementedgeservice.controller.dto.PlayerDTO;
import com.ironhack.amazaingmanagementedgeservice.model.Employee;
import com.ironhack.amazaingmanagementedgeservice.model.Player;
import com.ironhack.amazaingmanagementedgeservice.service.interfaces.IPlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JCircuitBreakerFactory;
import org.springframework.cloud.client.circuitbreaker.CircuitBreaker;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService implements IPlayerService {

	@Autowired
	private PlayerClient playerClient;

	private CircuitBreakerFactory circuitBreakerFactory = new Resilience4JCircuitBreakerFactory();

	private List<Player> allPlayerFallBack() {
		return null;
	}

	private Player playerFallBack() {
		return null;
	}

	@Override
	public List<Player> getAllPlayers() {
		CircuitBreaker circuitBreaker = circuitBreakerFactory.create("amazaing-management-player-service");

		List<Player> players = circuitBreaker.run(() -> playerClient.getAllPlayers(),
				throwable -> allPlayerFallBack());

		return players;
	}

	@Override
	public Player getPlayerById(Long id) {
		CircuitBreaker circuitBreaker = circuitBreakerFactory.create("amazaing-management-player-service");

		Player player = circuitBreaker.run(() -> playerClient.getPlayerById(id),
				throwable -> playerFallBack());

		return player;
	}

	@Override
	public Player storePlayer(PlayerDTO playerDTO) {
		CircuitBreaker circuitBreaker = circuitBreakerFactory.create("amazaing-management-player-service");

		Player player = circuitBreaker.run(() -> playerClient.storePlayer(playerDTO),
				throwable -> playerFallBack());

		return player;
	}

	@Override
	public void updatePlayer(Long id, PlayerDTO playerDTO) {

		playerClient.updatePlayer(id, playerDTO);
	}

	@Override
	public void deletePlayer(Long id) {

		playerClient.deletePlayer(id);
	}

}
