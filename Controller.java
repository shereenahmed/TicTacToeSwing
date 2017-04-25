package TicTacToe;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
<<<<<<< HEAD
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Controller {
	private observable observable;
	private observer observer;
	private View view;
	private Model model;
	private ImageIcon x, o;
	SingleObject object = SingleObject.getInstance();

	public static void main(String[] args) throws Exception {
=======

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class Controller {

	private View view;
	private Model model;
	private ImageIcon x, o;

	public static void main(String[] args) {
>>>>>>> 3842822d9a3fa8cc65654f9d3cdcc41615acbeb9
		Model model = new Model();
		model.setPlayer1(JOptionPane.showInputDialog(null,
				"Player 1, please enter your name: "));
		model.setPlayer2(JOptionPane.showInputDialog(null,
				"Player 2, please enter your name: "));
<<<<<<< HEAD

=======
>>>>>>> 3842822d9a3fa8cc65654f9d3cdcc41615acbeb9
		Controller controller = new Controller();
		controller.setModel(model);

	}

	public Controller() {
		init();
	}

	public Controller(Model model) {
		init();
		this.model = model;
<<<<<<< HEAD
	}

	private void init() {

		this.x = new ImageIcon(this.getClass().getResource("/resources/X.png"));
		this.o = new ImageIcon(this.getClass().getResource("/resources/O.png"));
		this.view = new View(new ActionListener() {
			int count = 1;
=======

	}

	private void init() {
		this.x = new ImageIcon(this.getClass().getResource("/resources/X.png"));
		this.o = new ImageIcon(this.getClass().getResource("/resources/O.png"));
		this.view = new View(new ActionListener() {
			int count = 0;
>>>>>>> 3842822d9a3fa8cc65654f9d3cdcc41615acbeb9

			@Override
			public void actionPerformed(ActionEvent e) {
				count++;
<<<<<<< HEAD
				count %= 2;
				GameButton button = (GameButton) e.getSource();
				switch (count) {
				case 0:
					button.setIcon(x);
					button.setValue('x');
					button.setEnabled(false);
					if (gameOver(view.getButton())) {
						JOptionPane.showMessageDialog(null,
								"Congrats " + model.getPlayer1()
										+ ", you won!!");

						observable observable = new observable(null);
						observer observer = new observer();
						observable.addObserver(observer);
						observable.setMsg("Cool kid ");
=======
				count %= 3;
				GameButton button = (GameButton) e.getSource();
				switch (count) {
				case 0:
					button.setIcon(null);
					break;

				case 1:
					button.setIcon(x);
					button.setValue('x');
					if (gameOver(view.getButton())) {
						JOptionPane.showMessageDialog(null,
								"Congrats " + model.getPlayer1() + ", you won!!");
>>>>>>> 3842822d9a3fa8cc65654f9d3cdcc41615acbeb9
						resetGame();

					} else if (isFullGrid(view.getButton())) {

						resetGame();
					}
					break;
<<<<<<< HEAD

				case 1:
					button.setIcon(o);
					button.setValue('o');
					button.setEnabled(false);

=======
				case 2:
					button.setIcon(o);
					button.setValue('o');
>>>>>>> 3842822d9a3fa8cc65654f9d3cdcc41615acbeb9
					if (gameOver(view.getButton())) {
						JOptionPane.showMessageDialog(null,
								"Congrats " + model.getPlayer2()
										+ ", you won!!");
<<<<<<< HEAD

=======
>>>>>>> 3842822d9a3fa8cc65654f9d3cdcc41615acbeb9
						resetGame();

					} else if (isFullGrid(view.getButton())) {
						resetGame();
					}

					break;
<<<<<<< HEAD
=======

>>>>>>> 3842822d9a3fa8cc65654f9d3cdcc41615acbeb9
				}

			}
		});
	}

	private boolean gameOver(GameButton[] button) {
		// Horizontal wins:
		if (button[0].getValue() == button[1].getValue()
				&& button[1].getValue() == button[2].getValue()
				&& button[0].getValue() != ' ') {
			return true;
		} else if (button[3].getValue() == button[4].getValue()
				&& button[4].getValue() == button[5].getValue()
				&& button[3].getValue() != ' ') {
			return true;
		} else if (button[6].getValue() == button[7].getValue()
				&& button[7].getValue() == button[8].getValue()
				&& button[6].getValue() != ' ') {
			return true;
		}

		// vertical wins:
		else if (button[0].getValue() == button[3].getValue()
				&& button[3].getValue() == button[6].getValue()
				&& button[0].getValue() != ' ') {
			return true;
		} else if (button[1].getValue() == button[4].getValue()
				&& button[4].getValue() == button[7].getValue()
				&& button[1].getValue() != ' ') {
			return true;

		} else if (button[2].getValue() == button[5].getValue()
				&& button[5].getValue() == button[8].getValue()
				&& button[2].getValue() != ' ') {
			return true;
		}
		// diagonal wins:
		else if (button[0].getValue() == button[4].getValue()
				&& button[4].getValue() == button[8].getValue()
				&& button[0].getValue() != ' ') {
			return true;
		} else if (button[2].getValue() == button[4].getValue()
				&& button[4].getValue() == button[6].getValue()
				&& button[2].getValue() != ' ') {
			return true;
		}
		return false;

	}

	public boolean isFullGrid(GameButton[] button) {
		for (int i = 0; i < button.length; i++) {
			if (button[i].getValue() == ' ') {
				return false;
			}
		}

		return true;
	}

	public void resetGame() {
		if (gameOver(view.getButton()) || isFullGrid(view.getButton())) {
			int choice = JOptionPane.showOptionDialog(null,
					"Do you want to reset the game?", "Reset question!",
					JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,
					null, null, null);

			if (choice == JOptionPane.YES_OPTION) {
				init();
<<<<<<< HEAD
				object.changeBackGround(view);
=======
>>>>>>> 3842822d9a3fa8cc65654f9d3cdcc41615acbeb9

			} else {
				System.exit(0);
			}
<<<<<<< HEAD
=======

>>>>>>> 3842822d9a3fa8cc65654f9d3cdcc41615acbeb9
		}
	}

	public View getView() {

		return view;
	}

	public void setView(View view) {
		this.view = view;
	}

	public Model getModel() {
		return model;
	}

	public void setModel(Model model) {
		this.model = model;
	}

}
