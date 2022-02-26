package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class MenuBar extends JMenuBar {
	private static final long serialVersionUID = 1L;
	
	private JMenu helpMenu;
	private ActionListener actionListener;
	private ActionListener actionListenerProxy = createActionListenerProxy();
	
	public MenuBar(ActionListener actionListener) {
		super();

		this.actionListener = actionListener;
		
		createAboutSection();
	}
	
	public void setActionListener(ActionListener actionListener) {
		this.actionListener = actionListener;
	}
	
	private void createAboutSection() {
		helpMenu = new JMenu("Help");
		helpMenu.setMnemonic(KeyEvent.VK_H);
		
		JMenuItem aboutItem = new JMenuItem("About");
		aboutItem.setMnemonic(KeyEvent.VK_A);
		
		helpMenu.add(aboutItem);
		
		add(helpMenu);
		
		aboutItem.addActionListener(actionListenerProxy);
	}
	
	private ActionListener createActionListenerProxy() {
		return new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ActionEvent action = new ActionEvent(
					e.getSource(), 
					e.getID(), 
					"menuBar:" + e.getActionCommand()
				);

				actionListener.actionPerformed(action);
			}
		};
	}
}