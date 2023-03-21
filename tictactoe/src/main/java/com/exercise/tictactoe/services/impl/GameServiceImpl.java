package com.exercise.tictactoe.services.impl;

import java.util.Map;
import java.util.Objects;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.exercise.tictactoe.models.GameState;
import com.exercise.tictactoe.models.PlayerTurn;
import com.exercise.tictactoe.services.GameService;

@Service
public class GameServiceImpl implements GameService {

	@Override
	public GameState resetGame() {
		return new GameState();
	}

	@Override
	public GameState playerTurn(PlayerTurn turn) {
		GameState state = new GameState();
		turn.getCurrentBoard().put(turn.getPosition(), turn.getPlayer());
		state.setBoard(turn.getCurrentBoard());
		String winner = checkWinner(turn.getCurrentBoard());
		if (StringUtils.isNotBlank(winner)) {
			state.setWinner(winner);
			state.setGameOver(true);
		}
		return state;
	}

	private String checkWinner(Map<String, String> board) {
		String winner = checkHorizontal(board);
		if (StringUtils.isBlank(winner)) {
			winner = checkVertical(board);
		}
		if (StringUtils.isBlank(winner)) {
			winner = checkDiagonal(board);
		}
		if (StringUtils.isBlank(winner) && board.values().stream().allMatch(Objects::nonNull)) {
			winner = "Draw";
		}
		return winner;
	}

	private String checkHorizontal(Map<String, String> board) {
		for (int i = 0; i < 9; i = i + 3) {
			if (board.get(Integer.toString(i)) != null
					&& board.get(Integer.toString(i)).equals(board.get(Integer.toString(i + 1)))
					&& board.get(Integer.toString(i)).equals(board.get(Integer.toString(i + 2)))) {
				return board.get(Integer.toString(i));
			}
		}
		return "";
	}

	private String checkVertical(Map<String, String> board) {
		for (int i = 0; i < 3; i++) {
			if (board.get(Integer.toString(i)) != null
					&& board.get(Integer.toString(i)).equals(board.get(Integer.toString(i + 3)))
					&& board.get(Integer.toString(i)).equals(board.get(Integer.toString(i + 6)))) {
				return board.get(Integer.toString(i));
			}
		}
		return "";
	}

	private String checkDiagonal(Map<String, String> board) {
		if (board.get("0") != null && board.get("0").equals(board.get("4")) && board.get("0").equals(board.get("8"))) {
			return board.get("0");
		}
		if (board.get("2") != null && board.get("2").equals(board.get("4")) && board.get("2").equals(board.get("6"))) {
			return board.get("2");
		}
		return "";
	}

}
