package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JCheckBox;
import model.Game;

public class ButtonController implements ActionListener {
	private Game game;

	public ButtonController(Game game) {
		this.game = game;
	}
	// action sau khi nhấn vào button
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Create"))
			game.newGame();
		else if (e.getActionCommand().equals("Reset"))
			game.checkGame();
		else if (e.getActionCommand().equals("Solve"))
			System.exit(0);
		else if (e.getActionCommand().equals("Help on"))
			game.setHelp(((JCheckBox) e.getSource()).isSelected());
		else
			game.setSelectedNumber(Integer.parseInt(e.getActionCommand()));
	}
}