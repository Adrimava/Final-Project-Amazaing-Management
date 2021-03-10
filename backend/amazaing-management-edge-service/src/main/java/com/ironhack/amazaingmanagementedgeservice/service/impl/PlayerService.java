package com.ironhack.amazaingmanagementedgeservice.service.impl;

import com.ironhack.amazaingmanagementedgeservice.client.PlayerClient;
import com.ironhack.amazaingmanagementedgeservice.controller.dto.PlayerDTO;
import com.ironhack.amazaingmanagementedgeservice.model.Player;
import com.ironhack.amazaingmanagementedgeservice.service.interfaces.IPlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService implements IPlayerService {

	@Autowired
	private PlayerClient playerClient;

	@Override
	public List<Player> getAllPlayers() {
		return playerClient.getAllPlayers();
	}

	@Override
	public Player getPlayerById(Long id) {

		return playerClient.getPlayerById(id);
	}

	@Override
	public Player storePlayer(PlayerDTO playerDTO) {

		return playerClient.storePlayer(playerDTO);
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
