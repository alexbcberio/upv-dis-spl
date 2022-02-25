package bl;

public class TicTacToe {

	private char[][] board = new char[3][3];
	private boolean player1Turn;
	private boolean gameEnded;

	public TicTacToe() {
		restartGame();
	}

	public boolean isPlayer1Turn() {
		return player1Turn;
	}

	public boolean hasGameEnded() {
		return gameEnded;
	}

	public void restartGame() {
		initBoard();

		player1Turn = true;
		gameEnded = false;
	}

	public void selectPosition(int row, int col) {
		if (gameEnded) {
			throw new RuntimeException("Game has already ended");
		}

		checkValidPosition(row, col);

		// Create a char variable that stores either 'x' or 'o' based on what
		// player's turn it is
		char c;

		if (player1Turn) {
			c = 'x';
		} else {
			c = 'o';
		}

		board[row][col] = c;
		player1Turn = !player1Turn;

		if (playerHasWon() != ' ' || boardIsFull()) {
			gameEnded = true;
		}
	}

	// Make a function to see if someone has won and return the winning char
	public char playerHasWon() {
		// Check each row
		for (int i = 0; i < 3; i++) {
			if (board[i][0] == board[i][1] && board[i][1] == board[i][2]
					&& board[i][0] != '-') {
				return board[i][0];
			}
		}

		// Check each column
		for (int j = 0; j < 3; j++) {
			if (board[0][j] == board[1][j] && board[1][j] == board[2][j]
					&& board[0][j] != '-') {
				return board[0][j];
			}
		}

		// Check the diagonals
		if (board[0][0] == board[1][1] && board[1][1] == board[2][2]
				&& board[0][0] != '-') {
			return board[0][0];
		}
		if (board[2][0] == board[1][1] && board[1][1] == board[0][2]
				&& board[2][0] != '-') {
			return board[2][0];
		}

		// Otherwise nobody has not won yet
		return ' ';
	}

	public boolean boardIsFull() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (board[i][j] == '-') {
					return false;
				}
			}
		}

		return true;
	}

	private void initBoard() {
		// Initialize our board with dashes (empty positions)
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				board[i][j] = '-';
			}
		}
	}

	private void checkValidPosition(int row, int col) {
		// Check if the row and col are 0, 1, or 2
		if (row < 0 || col < 0 || row > 2 || col > 2) {
			throw new RuntimeException(
					"This position is off the bounds of the board! Try again.");
			// Check if the position on the board the user entered is empty (has a
			// -) or not
		} else if (board[row][col] != '-') {
			throw new RuntimeException(
					"Someone has already made a move at this position! Try again.");
		}
	}
}