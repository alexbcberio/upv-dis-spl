package ui.dialog;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.JEditorPane;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;

public class AboutDialog {
	private static final String repoUrl = "https://github.com/alexbcberio/upv-dis-spl";
	private static int dialogOptionType = JOptionPane.YES_NO_OPTION;
	
	public static int show() {
		final int result = original();
		
		if (result == JOptionPane.OK_OPTION) {
			try {
				openWebpage(new URI(repoUrl));				
			} catch (URISyntaxException e) {
				System.out.println("Malformed URI");
			} catch (IOException e) {
				System.out.println("Browser could not be opened");
			}
		}
		
		return result;
	}
	
	private static JEditorPane getEditorPane() {
		JEditorPane editorPane = original();
		
		editorPane.setText(editorPane.getText() + "\n\nOpen source code in browser? (" + repoUrl + ")");
		
		return editorPane;
	}
	
  // Obtained from: https://stackoverflow.com/a/10967469
	private static void openWebpage(URI uri) throws IOException {
		Desktop desktop = Desktop.isDesktopSupported()
			? Desktop.getDesktop()
			: null;
		
    if (desktop != null && desktop.isSupported(Desktop.Action.BROWSE)) {
    	desktop.browse(uri);
    }
	}
}