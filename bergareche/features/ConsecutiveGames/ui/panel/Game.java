package ui.panel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import ui.dialog.TrackGamesDialog;

public class Game extends JPanel {
	private char lastWonPlayer = ' ';
	private int winStreak = 0;
	
	private void handleGameTrack(char winningPlayer) {
		if (lastWonPlayer == winningPlayer) {
			winStreak++;
		} else {
			winStreak = 1;
		}
		
		lastWonPlayer = winningPlayer;
		
		original(winningPlayer);
	}
	
	private void showTrackGamesDialog() {
		TrackGamesDialog.show(timesWon, winStreak, lastWonPlayer);
	}
}