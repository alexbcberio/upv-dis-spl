package ui.panel;

import java.awt.Container;
import java.awt.Cursor;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import bl.TicTacToe;

public class Game extends JPanel {

	private static final long serialVersionUID = 1L;
	private static final int boardSize = 3;
	private static final int cellSize = 95;
	private static final int boardMargin = 10;
	private static final int boardPanelSize = cellSize * Game.boardSize;
	private static final int resetBtnWidth = 187;
	private static final int resetBtnHeight = 100;

	private ImageIcon imgReset = new ImageIcon(
			getClass().getResource("/imgs/reset.jpg"));

	private Panel gameBoardPanel;
	private JButton[][] btnBoard = new JButton[boardSize][boardSize];
	private JButton btnReset;

	private TicTacToe game = new TicTacToe();

	public Game() {
		super();

		setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(null);

		createGameBoard();
		createResetButton();

		setSize(boardPanelSize, boardPanelSize + resetBtnHeight + 70);
	}

	private void createGameBoard() {
		gameBoardPanel = new Panel();
		gameBoardPanel.setBounds(boardMargin, boardMargin, boardPanelSize,
				boardPanelSize);

		for (int i = 0; i < btnBoard.length; i++) {
			final int posY = i;
			final int y = cellSize * i;

			for (int j = 0; j < btnBoard.length; j++) {
				final int posX = j;
				final int x = j * cellSize;

				JButton button = new JButton();

				button.setBounds(x, y, cellSize, cellSize);
				gameBoardPanel.add(button);

				btnBoard[i][j] = button;

				button.addActionListener(boardClick(posX, posY));
				button.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
		}

		gameBoardPanel.setLayout(null);

		add(gameBoardPanel);
	}

	private ActionListener boardClick(int posX, int posY) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!(e.getSource() instanceof JButton)) {
					System.out.println("Element is not a JButton");
					return;
				}

				JButton button = (JButton) e.getSource();
				Container parent = button.getParent();

				try {
					game.selectPosition(posX, posY);
				} catch (RuntimeException ex) {
					JOptionPane.showMessageDialog(parent, ex.getMessage(),
							"Error",
							JOptionPane.ERROR_MESSAGE);
					return;
				}

				button.setIcon(game.isPlayer1Turn() ? imgO : imgX);

				if (game.hasGameEnded()) {
					char wonPlayer = game.playerHasWon();
					if (wonPlayer == ' ') {
						int input = JOptionPane.showConfirmDialog(button, "Restart game?",
								"Its a tie", JOptionPane.YES_NO_OPTION);

						if (input == JOptionPane.YES_OPTION) {
							btnReset.doClick();
						}
					} else {
						hightlightWinner();
						JOptionPane.showMessageDialog(parent,
								"Player " + game.playerHasWon() + " has won");
					}
				}
			}
		};
	}

	private void createResetButton() {
		btnReset = new JButton();

		final int resetBtnX = (boardPanelSize - resetBtnWidth) / 2 + boardMargin;
		final int resetBtnY = boardPanelSize + boardMargin * 2;

		btnReset.setBounds(resetBtnX, resetBtnY, resetBtnWidth, resetBtnHeight);
		btnReset.setIcon(imgReset);

		btnReset.addActionListener(resetButtonClick());

		add(btnReset);
	}

	private ActionListener resetButtonClick() {
		return new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (int i = 0; i < btnBoard.length; i++) {
					for (int j = 0; j < btnBoard.length; j++) {
						JButton button = btnBoard[i][j];

						button.setEnabled(true);
						button.setIcon(null);

						game.restartGame();
					}
				}
			}
		};
	}

	private void hightlightWinner() {
		hightlightHorizontalWinner();
		hightlightVerticalWinner();
		hightlightPrimaryDiagonalWinner();
		hightlightSecondaryDiagonalWinner();
	}

	// FIXME: does not highlight rows over 0
	private boolean hightlightHorizontalWinner() {
		for (int i = 0; i < boardSize; i++) {
			String icon = getButtonIcon(i, 0);

			if (icon.length() > 0) {
				boolean hasWin = true;
				
				for (int j = 1; j < boardSize && hasWin; j++) {
					if (!icon.equals(getButtonIcon(i, j))) {
						hasWin = false;
					}
				}
				
				if (hasWin) {
					ImageIcon winIcon = game.isPlayer1Turn() ? imgOwin : imgXwin;
					
					for (int j = 0; j < boardSize; j++) {
						btnBoard[i][j].setIcon(winIcon);
					}
					
					return hasWin;
				}				
			}
		}

		return false;
	}

	private boolean hightlightVerticalWinner() {
		for (int i = 0; i < boardSize; i++) {
			final String icon = getButtonIcon(0, i);
			
			if (icon.length() > 0) {
				boolean hasWin = true;
				
				for (int j = 1; j < boardSize && hasWin; j++) {
					if (!icon.equals(getButtonIcon(j, i))) {
						hasWin = false;
					}
				}
				
				if (hasWin) {
					ImageIcon winIcon = game.isPlayer1Turn() ? imgOwin : imgXwin;
					
					for (int j = 0; j < boardSize; j++) {
						btnBoard[j][i].setIcon(winIcon);
					}
					
					return hasWin;
				}
			}
		}

		return false;
	}

	private boolean hightlightPrimaryDiagonalWinner() {
		final String icon = getButtonIcon(0, 0);
		
		if (icon.length() > 0) {
			boolean hasWin = true;
			
			for (int i = 1; i < boardSize && hasWin; i++) {
				if (!icon.equals(getButtonIcon(i, i))) {
					hasWin = false;
				}
			}
			
			if (hasWin) {
				ImageIcon winIcon = game.isPlayer1Turn() ? imgOwin : imgXwin;
				
				for (int i = 0; i < boardSize; i++) {
					btnBoard[i][i].setIcon(winIcon);
				}
			}
		}

		return false;
	}

	private boolean hightlightSecondaryDiagonalWinner() {
		final String icon = getButtonIcon(0, boardSize - 1);
		
		if (icon.length() > 0) {
			boolean hasWin = true;
			
			for (int i = 1; i < boardSize && hasWin; i++) {
				final int j = boardSize - (i + 1);
				System.out.println(i + " " + j);
				if (!icon.equals(getButtonIcon(i, j))) {
					hasWin = false;
				}
			}
			
			if (hasWin) {
				ImageIcon winIcon = game.isPlayer1Turn() ? imgOwin : imgXwin;
				
				for (int i = 0; i < boardSize; i++) {
					btnBoard[i][boardSize - (i + 1)].setIcon(winIcon);
				}
			}
		}

		return false;
	}

	private String getButtonIcon(int x, int y) {
		if (x < 0 || x > boardSize || y < 0 || y > boardSize) {
			return "";
		}

		Icon icon = btnBoard[x][y].getIcon();

		if (icon == null) {
			return "";
		}

		return icon.toString();
	}
}
