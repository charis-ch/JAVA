
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JComboBox;
import javax.swing.JProgressBar;
import javax.swing.JTextArea;
import org.json.JSONException;
import org.json.JSONObject;
//import javax.swing.JCheckBox;
import javax.swing.JButton;

//import static SW.Data;
public class StarWars extends Frame {

	private JComboBox<String> comboBox;
	private People characters;
	private Planets planets;
	private Resources json_resources;
	private JButton btnGetCharacteristics;
	private JTextArea textArea;
	private JComboBox<String> comboBox_1;
	private JTextArea textArea2;

	// private JProgressBar progressBar;
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
					// System.out.println(frame.comboBox.getSelectedItem());
					/**
					 * Character temp = null; int number = 1;// frame.comboBox.//getSelectedIndex();
					 * try { temp = frame.characters.getCharacter(number); } catch
					 * (NullPointerException nullpointer) { // TODO: handle exception
					 * 
					 * System.out.println("Not found!!!"); JSONObject selectedCharacter =
					 * frame.json_resources.requestResources(Data.PEOPLE, number); try { temp = new
					 * Character(selectedCharacter.get("name").toString(),
					 * Integer.parseInt(selectedCharacter.get("height").toString()),
					 * Integer.parseInt(selectedCharacter.get("mass").toString()),
					 * selectedCharacter.get("hair_color").toString(),
					 * selectedCharacter.get("skin_color").toString(),
					 * selectedCharacter.get("eye_color").toString(),
					 * selectedCharacter.get("birth_year").toString());
					 * frame.characters.saveCharacter(number, temp);
					 * frame.textArea.setText(temp.getCharacteristics()); //
					 * if(frame.characters==null) // System.out.println("null"); } catch
					 * (NumberFormatException | JSONException e1) { // TODO Auto-generated catch
					 * block e1.printStackTrace(); } } if (frame.characters == null)
					 * System.out.println("null"); else if (frame.characters.getCharacter(number) ==
					 * null) System.out.println("null2"); else
					 * frame.textArea.setText(frame.characters.getCharacter(number).getCharacteristics());
					 */
					// TODO Auto-generated method stub

					frame.btnGetCharacteristics.addActionListener(new ActionListener() {

						void retievePlanet() {
							Planet temp = null;
							int sel2 = 0;
							String name = null;
							int rotationPeriod = 0;
							int orbital_period = 0;
							int diameter = 0;

							int surfaceWater = 0;
							int population = 0;
							/// int number = 1;// frame.comboBox.//getSelectedIndex();
							// try {
							if (frame.comboBox_1 == null)
								System.out.println("NUll list");
							else {

								sel2 = frame.comboBox_1.getSelectedIndex();
								System.out.println("Selected index is:" + sel2);
							}

							temp = frame.planets.getPlanet(sel2);
							if (temp.getClimate() == null) { // not exist in ser file download the features of the
																// planet
								System.out.println("Null planet (not exists in ser file)");

								System.out.println("Not found!!!");
								JSONObject selectedCharacter = frame.json_resources.requestResources(Data.PLANETS,
										sel2);
								try {
									try {
										rotationPeriod = Integer
												.parseInt(selectedCharacter.get("rotation_period").toString());
										orbital_period = Integer
												.parseInt(selectedCharacter.get("orbital_period").toString());
										diameter = Integer.parseInt(selectedCharacter.get("diameter").toString());
										surfaceWater = Integer
												.parseInt(selectedCharacter.get("surface_water").toString());
										population = Integer.parseInt(selectedCharacter.get("population").toString());
									} catch (NumberFormatException unknown) {
										System.out.println("NUmber format exception1");
										/// height = -1;
									}
//									try {
//										mass = Integer.parseInt(selectedCharacter.get("mass").toString());
//									} catch (NumberFormatException unknown) {
//										mass = -1;
//									}

									temp = new Planet(selectedCharacter.get("name").toString(), rotationPeriod,
											orbital_period, diameter, selectedCharacter.get("climate").toString(),
											selectedCharacter.get("gravity").toString(),
											selectedCharacter.get("terrain").toString(), surfaceWater, population);
									frame.planets.savePlanet(sel2, temp);
									frame.textArea2.setText(temp.getCharacteristics());
									// if(frame.characters==null)
									// System.out.println("null");

								} catch (NullPointerException nullPointer) {

								} catch (JSONException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
							}
							if (frame.characters == null)
								System.out.println("null");
							else if (frame.characters.getCharacter(sel2) == null)
								System.out.println("null2!");
							else {
								frame.textArea2.setText(frame.planets.getPlanet(sel2).getCharacteristics());
								System.out.println("Already exist!");
							}
							// TODO Auto-generated method stub

						}

						void retrieveCharacter() {
							Character temp = null;
							int sel = 0;
							int height = 0;
							int mass = 0;
							/// int number = 1;// frame.comboBox.//getSelectedIndex();
							// try {

							if (frame.comboBox == null)
								System.out.println("NUll list");
							else {

								sel = frame.comboBox.getSelectedIndex();
								System.out.println("Selected index is:" + sel);
							}
							if (sel != -1) {
								temp = frame.characters.getCharacter(sel);
								if (temp.eye_colour == null) { // not exist in ser file download the features of the
																// character
									System.out.println("Null character (not exists in ser file)");

									System.out.println("Not found!!!");
									JSONObject selectedCharacter = frame.json_resources.requestResources(Data.PEOPLE,
											sel);
									try {
										try {
											height = Integer.parseInt(selectedCharacter.get("height").toString());
										} catch (NumberFormatException unknown) {
											height = -1;
										}
										try {
											mass = Integer.parseInt(selectedCharacter.get("mass").toString());
										} catch (NumberFormatException unknown) {
											mass = -1;
										}

										temp = new Character(selectedCharacter.get("name").toString(),

												height, mass, selectedCharacter.get("hair_color").toString(),
												selectedCharacter.get("skin_color").toString(),
												selectedCharacter.get("eye_color").toString(),
												selectedCharacter.get("birth_year").toString());
										frame.characters.saveCharacter(sel, temp);
										frame.textArea.setText(temp.getCharacteristics());
										// if(frame.characters==null)
										// System.out.println("null");

									} catch (NullPointerException nullPointer) {

									} catch (JSONException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
								}
								if (frame.characters == null)
									System.out.println("null");
								else if (frame.characters.getCharacter(sel) == null)
									System.out.println("null2!");
								else {
									frame.textArea.setText(frame.characters.getCharacter(sel).getCharacteristics());
									System.out.println("Already exist!");
								}
							}
							// TODO Auto-generated method stub

						}

						@Override
						public void actionPerformed(ActionEvent e) {

							retrieveCharacter();
							retievePlanet();

						}
					});

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

		requestPeopleData();
		requestPlanetsData();

		comboBox.setBounds(53, 24, 228, 20);
		getContentPane().add(comboBox);

		textArea = new JTextArea();
		textArea.setBounds(53, 271, 228, 164);
		contentPane.add(textArea);
		textArea2 = new JTextArea();
		textArea2.setBounds(340, 271, 300, 164);
		contentPane.add(textArea2);

		/// JComboBox comboBox_1 = new JComboBox<Object>();

		comboBox_1.setBounds(340, 24, 228, 20);
		contentPane.add(comboBox_1);
		/**
		 * JCheckBox chckbxHeght = new JCheckBox("Heght"); chckbxHeght.setBounds(43, 99,
		 * 97, 23); contentPane.add(chckbxHeght);
		 * 
		 * JCheckBox chckbxMass = new JCheckBox("Mass"); chckbxMass.setBounds(142, 99,
		 * 97, 23); contentPane.add(chckbxMass);
		 * 
		 * JCheckBox chckbxHairColor = new JCheckBox("Hair color");
		 * chckbxHairColor.setBounds(43, 125, 97, 23); contentPane.add(chckbxHairColor);
		 * 
		 * JCheckBox chckbxSkinColor = new JCheckBox("Skin color");
		 * chckbxSkinColor.setBounds(142, 125, 97, 23);
		 * contentPane.add(chckbxSkinColor);
		 * 
		 * JCheckBox chckbxEyeColor = new JCheckBox("Eye color");
		 * chckbxEyeColor.setBounds(43, 151, 97, 23); contentPane.add(chckbxEyeColor);
		 * 
		 * JCheckBox chckbxBirthYear = new JCheckBox("Birth Year");
		 * chckbxBirthYear.setBounds(142, 151, 97, 23);
		 * contentPane.add(chckbxBirthYear);
		 * 
		 * JCheckBox chckbxRotationPeriod = new JCheckBox("Rotation period");
		 * chckbxRotationPeriod.setBounds(335, 99, 129, 23);
		 * contentPane.add(chckbxRotationPeriod);
		 * 
		 * JCheckBox chckbxDiameter = new JCheckBox("Diameter");
		 * chckbxDiameter.setBounds(335, 125, 97, 23); contentPane.add(chckbxDiameter);
		 * 
		 * JCheckBox chckbxClimate = new JCheckBox("Climate");
		 * chckbxClimate.setBounds(335, 151, 97, 23); contentPane.add(chckbxClimate);
		 * 
		 * JCheckBox chckbxGravity = new JCheckBox("Gravity");
		 * chckbxGravity.setBounds(471, 99, 97, 23); contentPane.add(chckbxGravity);
		 * 
		 * JCheckBox chckbxTerrain = new JCheckBox("Terrain");
		 * chckbxTerrain.setBounds(471, 125, 97, 23); contentPane.add(chckbxTerrain);
		 * 
		 * JCheckBox chckbxSurfaceWater = new JCheckBox("Surface water");
		 * chckbxSurfaceWater.setBounds(471, 151, 118, 23);
		 * contentPane.add(chckbxSurfaceWater);
		 **/
		btnGetCharacteristics = new JButton("Get characteristics");
		btnGetCharacteristics.setBounds(234, 214, 186, 23);
		contentPane.add(btnGetCharacteristics);

		this.addWindowListener(new WindowAdapter() {

			public void windowClosing(WindowEvent windowEvent) {

				System.out.println("Closing window");
				SWData charactersData = characters;
				SWData.saveState(charactersData, Data.PEOPLE);
				characters.printKnownCharacters();
				SWData planetsData = planets;
				SWData.saveState(planetsData, Data.PLANETS);
			}
		});
	}

	private void requestPlanetsData() {

		// System.out.println("in");
		SWData savedPlanets = SWData.restoreState(Data.PLANETS);
		String names[] = null;
		if (savedPlanets instanceof Planets) {
			// System.out.println("People is instance of SWData");
			planets = (Planets) savedPlanets;
			json_resources = new Resources();
			int total_planets = 0;
			try {

				total_planets = (json_resources.requestResources(Data.PLANETS, 0)).getInt("count") + 1; // get
																										// the
																										// current
																										// total
																										// characters
																										// of
																										// swapi

				System.out.println("Total planets=" + total_planets);
			} catch (JSONException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}

			if (planets.getPlanet(1) == null) {
			///	SWThread athread = new SWThread(Data.PLANETS);
				 SWThread.data = Data.PLANETS;
				/// SWThread.setThread(Thread.currentThread());
				names = SWThread.downloadFeatureNames(total_planets);
				System.out.println("NUll is 2");
				planets.setTotalPlanets(total_planets);
				try {
					Thread.sleep(15000);
					for (int i = 1; i < total_planets; i++) {
						planets.savePlanet(i, new Planet(names[i]));

						System.out.println("i= " + i + "\t planet   " + planets.getPlanet(i).getName());
					}
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			} else {

				int saved = planets.getTotalPlanets();
				System.out.println("Size= " + saved);
				if (saved != total_planets) {

					names = new String[total_planets];
			///		names = SWThread.downloadCharacters(savedCharacters, total_chars);
					// TODO: It may needs to add thread.sleep for 10 seconds

				} else
					names = new String[saved];

				for (int i = 1; i < saved; i++) {

					names[i] = characters.getCharacter(i).getName();
				}
			}
		}
		comboBox_1 = new JComboBox<String>(names);
		System.out.println("PLanets =" + names.length);
	}

	private void requestPeopleData() {

		SWData savedPeople = SWData.restoreState(Data.PEOPLE);
		String names[] = null;
		if (savedPeople instanceof People) {
			// System.out.println("People is instance of SWData");
			characters = (People) savedPeople;
			json_resources = new Resources();
			int total_chars = 0;
			try {

				total_chars = (json_resources.requestResources(Data.PEOPLE, 0)).getInt("count") + 2; // get
																										// the
																										// current
																										// total
																										// characters
																										// of
				System.out.println("Total characters=" + total_chars); // swapi
			} catch (JSONException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			if (characters.getCharacter(1) == null) {

		///		SWThread bthread = new SWThread(Data.PEOPLE);
			 SWThread.data = Data.PEOPLE;
				/// SWThread.setThread(Thread.currentThread());
				names = SWThread.downloadFeatureNames(total_chars);
				System.out.println("NUll is 1");
				characters.setTotalCharacters(total_chars);

				try {
					Thread.sleep(15000);
					for (int i = 1; i < total_chars; i++) {
						characters.saveCharacter(i, new Character(names[i]));

						System.out.println("i= " + i + "\t character   " + characters.getCharacter(i).getName());
					}
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				/**
				 * long start=System.currentTimeMillis(); progressBar = new JProgressBar(0,
				 * 100); getContentPane().add(progressBar); long end=System.currentTimeMillis();
				 * while(end<(start+15000)) { try {
				 * 
				 * 
				 * progressBar.setValue(0); for (int i = 0; i <= 100; i += 10) {
				 * 
				 * Thread.sleep(150); progressBar.setValue(i); } } catch (InterruptedException
				 * e) { // TODO Auto-generated catch block e.printStackTrace(); }
				 * 
				 * end=System.currentTimeMillis(); }
				 * 
				 **/
				/// SWThread a=new SWThread(1, Data.PEOPLE);

				/// names = json_resources.get(Data.PEOPLE);
				// System.out.println(names.length);
			} else {

				int savedCharacters = characters.getTotalCharacters();
				System.out.println("Size= " + savedCharacters);
				if (savedCharacters != total_chars) {

					names = new String[total_chars];
					names = SWThread.downloadCharacters(savedCharacters, total_chars);
					// TODO: It may needs to add thread.sleep for 10 seconds

				} else
					names = new String[savedCharacters];

				for (int i = 1; i < savedCharacters; i++) {

					names[i] = characters.getCharacter(i).getName();
				}
			}
		}
		System.out.println("People =" + names.length);
		comboBox = new JComboBox<String>(names);
		// TODO Auto-generated method stub

	}
}
