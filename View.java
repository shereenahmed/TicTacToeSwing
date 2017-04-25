package TicTacToe;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;

  public class View extends JFrame {

	private JPanel panel = new JPanel();
    static GameButton button[] = new GameButton[9];
	

	public GameButton[] getButton() {
		return button;
	}

	public void setButton(GameButton[] button) {
		this.button = button;
	}

	public View(ActionListener action) {
		super("TicTacToe");
		Init(action);
	}
	
	public View() {
	}

	public void Init(ActionListener action) {
		setSize(500, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		panel.setLayout(new GridLayout(3, 3));
		
		for (int i = 0; i < button.length; i++) {
			button[i] = new GameButton();
			button[i].addActionListener(action);
			button[i].setValue(' ');
			button[i].setBackground(Color.PINK);
			panel.add(button[i]);

		}

		add(panel);
		setVisible(true);

	}


}