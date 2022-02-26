package ui.panel;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Game extends JPanel {

	private boolean ia = false;
	
	public void enableIa(boolean ia) {
		this.ia = ia;
	}
	
	public boolean hasIa() {
		return ia;
	}
	
	private ActionListener boardClick(int posX, int posY) {		
		return new ActionListener() {
			ActionListener originalListener = original(posX, posY);
			
			@Override
			public void actionPerformed(ActionEvent e) {
				originalListener.actionPerformed(e);
				
				if (!game.hasGameEnded() && ia) {
					for (int i = 0; i < btnBoard.length; i++) {
						for (int j = 0; j < btnBoard[i].length; j++) {
							if (getButtonIcon(i, j).length() == 0) {
								ActionListener ia = original(i, j);
								
								e.setSource(btnBoard[i][j]);
								ia.actionPerformed(e);
								
								return;
							}
						}
					}
				}
			}
		};
	}
}