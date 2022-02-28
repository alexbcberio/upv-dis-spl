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
		ActionListener originalListener = original(posX, posY);
		
		return new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				originalListener.actionPerformed(e);
				
				if (!ia) {
					return;
				}
				
				if (!game.hasGameEnded()) {
					try {
						int[] position = game.computerSelectPosition();

						final int posX = position[0];
						final int posY = position[1];
						
						ActionListener computer = original(posX, posY);
						
						e.setSource(btnBoard[posX][posY]);
						
						computer.actionPerformed(e);
					} catch (RuntimeException ex) {
						System.out.println(ex);
					}
				}
			}
		};
	}
}