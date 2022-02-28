package ui.panel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import ui.dialog.TrackGamesDialog;

public class Game extends JPanel {
	private int[] timesWon = {0, 0};
	
	private ActionListener boardClick(int posX, int posY) {
		ActionListener originalListener = original(posX, posY);
		
		return new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				originalListener.actionPerformed(e);
				
				if (game.hasGameEnded()) {
					handleGameTrack(game.playerHasWon());
				}
			}
		};
	}
	
	private void handleGameTrack(char winningPlayer) {
		switch (winningPlayer) {
		case 'x':
			timesWon[0]++;
			break;
		case 'o':
			timesWon[1]++;
			break;
		}
		
		showTrackGamesDialog();
	}
	
	private void showTrackGamesDialog() {
		TrackGamesDialog.show(timesWon);
	}
}