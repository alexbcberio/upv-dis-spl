package ui.dialog;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.JEditorPane;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;

public class TrackGamesDialog {
	public static void show(int[] timesWon, int winStreak, char lastWonPlayer) {
		JOptionPane.showMessageDialog(
			null,
			getEditorPane(timesWon, winStreak, lastWonPlayer),
			dialogTitle,
			dialogMessageType
		);
	}
	
	private static JEditorPane getEditorPane(
		int[] timesWon,
		int winStreak,
		char lastWonPlayer
	) {
		JEditorPane editorPane = getEditorPane(timesWon);
		
		if (lastWonPlayer != ' ') {
			editorPane.setText(
				editorPane.getText() +
				"\n\n" + Character.toUpperCase(lastWonPlayer) + " is on a winning streak of " + winStreak + " games!"
			);
		}
		
		return editorPane;
	}
}