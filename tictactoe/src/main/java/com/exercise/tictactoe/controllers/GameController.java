package com.exercise.tictactoe.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exercise.tictactoe.models.GameState;
import com.exercise.tictactoe.models.PlayerTurn;
import com.exercise.tictactoe.services.GameService;

@RestController
@RequestMapping("api/v1/tictactoe")
public class GameController {

	private GameService gameService;

	@Autowired
	public GameController(GameService gameService) {
		this.gameService = gameService;
	}

	@CrossOrigin(origins = "*")
	@GetMapping("/reset")
	public ResponseEntity<GameState> resetGame() {
		return new ResponseEntity<>(gameService.resetGame(), HttpStatus.OK);

	}

	@CrossOrigin(origins = "*")
	@PostMapping("/turn")
	public ResponseEntity<GameState> playerTurn(@RequestBody PlayerTurn turn) {
		return new ResponseEntity<>(gameService.playerTurn(turn), HttpStatus.OK);
	}
}
