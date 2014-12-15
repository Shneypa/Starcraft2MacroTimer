import javax.swing.JFrame;
import javax.swing.JLabel;


public class Window extends JFrame {

	public Window(int width, int height, String title) {
		
		// Initialize SIZE, VISIBIILITY, CLOSING !
		this.setVisible(true);
		this.setSize(width, height);
		this.setTitle(title);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
}
