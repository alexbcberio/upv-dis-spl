package ui.dialog;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.JEditorPane;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;

public class AboutDialog {
	private static final String dialogTitle = "About";
	private static int dialogOptionType = JOptionPane.DEFAULT_OPTION;
	private static int dialogMessageType = JOptionPane.INFORMATION_MESSAGE;
	
	public static int show() {
		final int result = JOptionPane.showConfirmDialog(
			null,
			getEditorPane(),
			dialogTitle,
			dialogOptionType,
			dialogMessageType
		);
		
		return result;
	}
	
	private static JEditorPane getEditorPane() {
		JEditorPane editorPane = new JTextPane();
		
		editorPane.setEditable(false);
		editorPane.setBackground(null);
		editorPane.setText("App by:\n  - Irith Katiyar\n  - Alexander BC");
		
		return editorPane;
	}
}