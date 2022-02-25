package ui;

import java.awt.event.ActionEvent;

public class Window {
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("menu:playIa")) {
			// TODO: enable IA capabilities
			gamePanel = new Game();
		}
		
		original(e);
	}
}