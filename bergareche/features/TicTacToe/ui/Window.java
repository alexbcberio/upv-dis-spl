package ui;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import ui.panel.Game;
import ui.panel.Menu;

public class Window extends JFrame implements ActionListener  {

	private static final long serialVersionUID = 1L;
	private static final String title = "Tic-tac-toe";

	private Menu menuPanel;
	private Game gamePanel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Window frame = new Window();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Window() {
		super();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setTitle(title);

		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();

		final int width = 300;
		final int height = 280;

		setBounds((screen.width - width) / 2, (screen.height - height) / 2, width,
				height);

		menuPanel = new Menu();
		setContentPane(menuPanel);

		menuPanel.setActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		if (gamePanel == null) {
			return;
		}
		
		if (menuPanel != null) {
			menuPanel.setVisible(false);
			remove(menuPanel);
			menuPanel = null;
			
			setContentPane(gamePanel);
			setTitle("In game --- " + title);
			
			Dimension d = gamePanel.getSize();
			setSize(d.width + 40, d.height);
		}
	}

}
