package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import ui.dialog.AboutDialog;

public class Window extends JFrame implements ActionListener {
	private MenuBar menuBar;
	
	public Window() {
		menuBar = new MenuBar(this);
		
		setJMenuBar(menuBar);
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("menuBar:About")) {
			AboutDialog.show();
		}
		
		original(e);
	}
}