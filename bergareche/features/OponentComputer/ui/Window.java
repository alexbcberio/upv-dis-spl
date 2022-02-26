package ui;

import java.awt.event.ActionEvent;

public class Window {
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("menu:playIa")) {
			gamePanel = new Game();
			gamePanel.enableIa(true);
		}
		
		original(e);
	}
}