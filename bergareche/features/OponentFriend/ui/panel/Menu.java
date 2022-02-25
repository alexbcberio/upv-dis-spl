package ui.panel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Menu {
	private JButton btnVsFriend;
	
	private void createButtons() {
		original();
		
		btnVsFriend = new JButton("Play versus Friend");
		btnVsFriend.setIcon(new ImageIcon(getClass().getResource("/imgs/human.jpg")));
		add(btnVsFriend);	
	}

	private void addListeners() {
		original();

		btnVsFriend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ActionEvent action = new ActionEvent(e.getSource(), e.getID(),
						"menu:playFriend");

				actionListener.actionPerformed(action);
			}
		});
	}
}