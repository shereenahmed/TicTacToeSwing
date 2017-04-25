package TicTacToe;
import javax.swing.JButton;

import java.awt.Button;
import java.awt.Color;
import java.awt.event.ActionListener;

public class SingleObject {
	View view;
	private static SingleObject instance = null;

	private SingleObject() {

	}

	public static SingleObject getInstance() {
		if (instance == null)
			instance = new SingleObject();
		return instance;
	}

	public void changeBackGround(View Init) {
		view = new View();
		for(int i=0; i<9; i++){
			View.button[i].setBackground(Color.GREEN);
		}
	  
	}
}
