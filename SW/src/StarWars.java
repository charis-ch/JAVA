
import java.awt.EventQueue;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JCheckBox;
import javax.swing.JButton;

public class StarWars extends Frame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1492373654682361045L;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StarWars frame = new StarWars();

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public StarWars() {
		super.setTitle("Star Wars Informer");

		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(53, 24, 151, 20);
		getContentPane().add(comboBox);

		JTextArea textArea = new JTextArea();
		textArea.setBounds(79, 271, 277, 164);
		contentPane.add(textArea);

		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(340, 24, 228, 20);
		contentPane.add(comboBox_1);

		JCheckBox chckbxHeght = new JCheckBox("Heght");
		chckbxHeght.setBounds(43, 99, 97, 23);
		contentPane.add(chckbxHeght);

		JCheckBox chckbxMass = new JCheckBox("Mass");
		chckbxMass.setBounds(142, 99, 97, 23);
		contentPane.add(chckbxMass);

		JCheckBox chckbxHairColor = new JCheckBox("Hair color");
		chckbxHairColor.setBounds(43, 125, 97, 23);
		contentPane.add(chckbxHairColor);

		JCheckBox chckbxSkinColor = new JCheckBox("Skin color");
		chckbxSkinColor.setBounds(142, 125, 97, 23);
		contentPane.add(chckbxSkinColor);

		JCheckBox chckbxEyeColor = new JCheckBox("Eye color");
		chckbxEyeColor.setBounds(43, 151, 97, 23);
		contentPane.add(chckbxEyeColor);

		JCheckBox chckbxBirthYear = new JCheckBox("Birth Year");
		chckbxBirthYear.setBounds(142, 151, 97, 23);
		contentPane.add(chckbxBirthYear);

		JCheckBox chckbxRotationPeriod = new JCheckBox("Rotation period");
		chckbxRotationPeriod.setBounds(335, 99, 129, 23);
		contentPane.add(chckbxRotationPeriod);

		JCheckBox chckbxDiameter = new JCheckBox("Diameter");
		chckbxDiameter.setBounds(335, 125, 97, 23);
		contentPane.add(chckbxDiameter);

		JCheckBox chckbxClimate = new JCheckBox("Climate");
		chckbxClimate.setBounds(335, 151, 97, 23);
		contentPane.add(chckbxClimate);

		JCheckBox chckbxGravity = new JCheckBox("Gravity");
		chckbxGravity.setBounds(471, 99, 97, 23);
		contentPane.add(chckbxGravity);

		JCheckBox chckbxTerrain = new JCheckBox("Terrain");
		chckbxTerrain.setBounds(471, 125, 97, 23);
		contentPane.add(chckbxTerrain);

		JCheckBox chckbxSurfaceWater = new JCheckBox("Surface water");
		chckbxSurfaceWater.setBounds(471, 151, 118, 23);
		contentPane.add(chckbxSurfaceWater);

		JButton btnGetCharacteristics = new JButton("Get characteristics");
		btnGetCharacteristics.setBounds(234, 214, 186, 23);
		contentPane.add(btnGetCharacteristics);

	}
}
