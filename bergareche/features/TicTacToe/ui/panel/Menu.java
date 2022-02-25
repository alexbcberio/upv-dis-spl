package ui.panel;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Menu extends JPanel {

	private static final long serialVersionUID = 1L;

	private ActionListener actionListener;

	public Menu() {
		super();

		setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		createButtons();
		addListeners();
	}

	public void setActionListener(ActionListener action) {
		actionListener = action;
	}

	private void createButtons() {}

	private void addListeners() {
		if (actionListener != null) {
			return;
		}
	}

}
