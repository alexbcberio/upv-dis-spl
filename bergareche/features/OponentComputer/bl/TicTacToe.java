package bl;

public class TicTacToe {
	public int[] computerSelectPosition() {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (board[i][j] == '-') {
					final int[] pos = {i, j};
					
					return pos;
				}
			}
		}
		
		throw new RuntimeException("Cannot select a position");
	}
}