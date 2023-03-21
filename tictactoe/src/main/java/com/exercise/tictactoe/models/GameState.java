package com.exercise.tictactoe.models;

import java.util.HashMap;
import java.util.Map;

public class GameState {

	private Boolean gameOver;
	private String winner;
	private Map<String, String> board;

	public GameState() {
		gameOver = false;
		winner = "";
		board = new HashMap<>();
		board.put("0", null);
		board.put("1", null);
		board.put("2", null);
		board.put("3", null);
		board.put("4", null);
		board.put("5", null);
		board.put("6", null);
		board.put("7", null);
		board.put("8", null);
		board.put("9", null);
	}

	public Boolean getGameOver() {
		return gameOver;
	}

	public void setGameOver(Boolean gameOver) {
		this.gameOver = gameOver;
	}

	public String getWinner() {
		return winner;
	}

	public void setWinner(String winner) {
		this.winner = winner;
	}

	public Map<String, String> getBoard() {
		return board;
	}

	public void setBoard(Map<String, String> board) {
		this.board = board;
	}
}
