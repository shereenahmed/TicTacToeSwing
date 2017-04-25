package TicTacToe;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
		Model model = new Model();
		model.setPlayer1(JOptionPane.showInputDialog(null,
				"Player 1, please enter your name: "));
		model.setPlayer2(JOptionPane.showInputDialog(null,
				"Player 2, please enter your name: "));

		Controller controller = new Controller();
		controller.setModel(model);

	}

	public Controller() {
		init();
	}

	public Controller(Model model) {
		init();
		this.model = model;
	}

	private void init() {

		this.x = new ImageIcon(this.getClass().getResource("/resources/X.png"));
		this.o = new ImageIcon(this.getClass().getResource("/resources/O.png"));
		this.view = new View(new ActionListener() {
			int count = 1;

			@Override
			public void actionPerformed(ActionEvent e) {
				count++;
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
						resetGame();

					} else if (isFullGrid(view.getButton())) {

						resetGame();
					}
					break;

				case 1:
					button.setIcon(o);
					button.setValue('o');
					button.setEnabled(false);

					if (gameOver(view.getButton())) {
						JOptionPane.showMessageDialog(null,
								"Congrats " + model.getPlayer2()
										+ ", you won!!");

						resetGame();

					} else if (isFullGrid(view.getButton())) {
						resetGame();
					}

					break;
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
				object.changeBackGround(view);

			} else {
				System.exit(0);
			}
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
