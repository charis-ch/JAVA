import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Frame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4358555447424445685L;
	protected JPanel contentPane;
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		}
		public Frame(){
			
			
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
				Dimension screen=Toolkit.getDefaultToolkit().getScreenSize();
			
			setBounds(0, 0,(int)( screen.width/2),(int)(screen.height/2));setLocation((int)(screen.width/4), (int)(screen.height/4));
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(null);
		setVisible(true);
	}

}
