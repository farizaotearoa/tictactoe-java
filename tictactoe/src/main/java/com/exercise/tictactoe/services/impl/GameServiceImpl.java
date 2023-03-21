package com.exercise.tictactoe.services.impl;

import org.springframework.stereotype.Service;

import com.exercise.tictactoe.models.GameState;
import com.exercise.tictactoe.services.GameService;

@Service
public class GameServiceImpl implements GameService {

	@Override
	public GameState resetGame() {
		return new GameState();
	}

}
