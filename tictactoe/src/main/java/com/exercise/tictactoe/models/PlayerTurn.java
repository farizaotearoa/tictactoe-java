package com.exercise.tictactoe.models;

import java.util.Map;

public class PlayerTurn {

	private Map<String, String> currentBoard;
	private String player;
	private String position;

	public Map<String, String> getCurrentBoard() {
		return currentBoard;
	}

	public void setCurrentBoard(Map<String, String> currentBoard) {
		this.currentBoard = currentBoard;
	}

	public String getPlayer() {
		return player;
	}

	public void setPlayer(String player) {
		this.player = player;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}
}
