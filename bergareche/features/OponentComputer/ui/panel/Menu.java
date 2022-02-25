package ui.panel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Menu {
	private JButton btnVsComputer;
	
	private void createButtons() {
		original();
		
		btnVsComputer = new JButton("Play versus Computer");
		btnVsComputer
				.setIcon(new ImageIcon(getClass().getResource("/imgs/computer.jpg")));
		add(btnVsComputer);		
	}
	
	private void addListeners() {
		original();

		btnVsComputer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ActionEvent action = new ActionEvent(e.getSource(), e.getID(),
						"menu:playIa");

				actionListener.actionPerformed(action);
			}
		});
	}
}