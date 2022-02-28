package ui.dialog;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.JEditorPane;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;

public class TrackGamesDialog {
	private static final String dialogTitle = "Track Games";
	private static int dialogMessageType = JOptionPane.INFORMATION_MESSAGE;
	
	public static void show(int[] timesWon) {
		JOptionPane.showMessageDialog(
			null,
			getEditorPane(timesWon),
			dialogTitle,
			dialogMessageType
		);
	}
	
	private static JEditorPane getEditorPane(int[] timesWon) {
		JEditorPane editorPane = new JTextPane();
		
		editorPane.setEditable(false);
		editorPane.setBackground(null);
		editorPane.setText("Times won:\n  - Player 1 (X): " + timesWon[0] + "\n  - Player 2 (O): " + timesWon[1]);
		
		return editorPane;
	}
}