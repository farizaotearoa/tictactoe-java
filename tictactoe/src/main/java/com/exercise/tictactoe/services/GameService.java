package com.exercise.tictactoe.services;

import com.exercise.tictactoe.models.GameState;
import com.exercise.tictactoe.models.PlayerTurn;

public interface GameService {

	public GameState resetGame();

	public GameState playerTurn(PlayerTurn turn);

}
