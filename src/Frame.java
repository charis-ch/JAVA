import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * 
 * This class initilizes a frame for a GUI application.
 * 
 * Result: An empty frame will appear on the center of the screen.
 * 
 */
public class Frame extends JFrame {

	private static final long serialVersionUID = -4358555447424445685L;
	protected JPanel contentPane;
	private static Dimension screen;

	public Frame() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		screen = Toolkit.getDefaultToolkit().getScreenSize();

		setBounds(0, 0, (int) (screen.width / 2), (int) (screen.height / 2));
		setLocation((int) (screen.width / 4), (int) (screen.height / 4));
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setVisible(true);
	}

	/**
	 * 
	 *  Unit testing for Frame class 
	 * 
	 * 
	 * */

	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame window = new Frame();
					window.setTitle("Unit testing");
					window.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		});
	}
}
