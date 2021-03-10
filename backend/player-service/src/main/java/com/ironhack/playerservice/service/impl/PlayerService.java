package com.ironhack.playerservice.service.impl;

import com.ironhack.playerservice.controller.dto.PlayerDTO;
import com.ironhack.playerservice.model.Player;
import com.ironhack.playerservice.repository.PlayerRepository;
import com.ironhack.playerservice.service.interfaces.IPlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class PlayerService implements IPlayerService {

	@Autowired
	private PlayerRepository playerRepository;

	@Override
	public List<Player> getAllPlayers() {
		return playerRepository.findAll();
	}

	@Override
	public Player getPlayerById(Long id) {
		Optional<Player> player = playerRepository.findById(id);

		if (player.isPresent()) {
			return player.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Player not found");
		}
	}

	@Override
	public Player storePlayer(PlayerDTO playerDTO) {
		Player player = new Player(playerDTO.getPlayerName(), playerDTO.getMoney(), playerDTO.getPhoto());

		return playerRepository.save(player);
	}

	@Override
	public void updatePlayer(Long id, PlayerDTO playerDTO) {
		Player player;

		getPlayerById(id);
		player = new Player(playerDTO.getPlayerName(), playerDTO.getMoney(), playerDTO.getPhoto());
		player.setPlayerId(id);
		playerRepository.save(player);
	}

	@Override
	public void deletePlayer(Long id) {

		getPlayerById(id);
		playerRepository.deleteById(id);
	}

}
