package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Window extends JFrame implements ActionListener {
	private MenuBar menuBar;
	
	public Window() {
		menuBar = new MenuBar(this);
		
		setJMenuBar(menuBar);
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("menuBar:About")) {
			showAboutDialog();
		}
		
		original(e);
	}
	
	private void showAboutDialog() {
		JOptionPane.showMessageDialog(
			menuBar,
			"App by:\n  - Irith Katiyar\n  - Alexander BC",
			"About",
			JOptionPane.INFORMATION_MESSAGE
		);
	}
}