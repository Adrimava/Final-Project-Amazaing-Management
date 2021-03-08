package com.ironhack.finalproject.amazaingmanagement.controller.impl;

import com.ironhack.finalproject.amazaingmanagement.controller.dto.PlayerDTO;
import com.ironhack.finalproject.amazaingmanagement.controller.interfaces.IPlayerController;
import com.ironhack.finalproject.amazaingmanagement.model.Player;
import com.ironhack.finalproject.amazaingmanagement.service.impl.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PlayerController implements IPlayerController {

	@Autowired
	private PlayerService playerService;

	@GetMapping("/players")
	@ResponseStatus(HttpStatus.OK)
	public List<Player> getAllPlayers() {
		return playerService.getAllPlayers();
	}

	@GetMapping("/player/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Player getPlayerById(@PathVariable Long id) {
		return playerService.getPlayerById(id);
	}

	@PostMapping("/player")
	@ResponseStatus(HttpStatus.CREATED)
	public Player storePlayer(@RequestBody PlayerDTO playerDTO) {
		return playerService.storePlayer(playerDTO);
	}

	@PutMapping("/player/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void updatePlayer(@PathVariable Long id, @RequestBody PlayerDTO playerDTO) {
		playerService.updatePlayer(id, playerDTO);
	}

	@DeleteMapping("/player/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletePlayer(@PathVariable Long id) {
		playerService.deletePlayer(id);
	}

}
