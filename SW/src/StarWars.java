import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import org.json.JSONException;
import org.json.JSONObject;
import javax.swing.JButton;

public class StarWars extends Frame {

	private JComboBox<String> listedCharacters;
	private People characters;
	private Planets planets;
	private Resources json_resources;
	private JButton btnGetCharacteristics;
	private JTextArea characterFeatures;
	private JComboBox<String> listedPlanets;
	private JTextArea planetFeatures;

	private static final long serialVersionUID = 1492373654682361045L;
static	int previousCharacter = -1;
static int previousPlanet = -1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StarWars frame = new StarWars();

					frame.btnGetCharacteristics.addActionListener(new ActionListener() {
					

						void retievePlanet() {

							Planet temp = null;
							int sel2 = 0;
							int rotationPeriod = 0;
							int orbital_period = 0;
							int diameter = 0;
							int surfaceWater = 0;
							long population = 0;

							if (frame.listedPlanets == null)
								System.out.println("NUll list");
							else {

								sel2 = frame.listedPlanets.getSelectedIndex();
								System.out.println("Selected index is:" + sel2);
							}
							if ((sel2 != -1)&&(previousPlanet!=sel2)) {
								previousPlanet=sel2;
								temp = frame.planets.getPlanet(sel2);
								if (temp.getClimate() == null) { // not exist in ser file download the features of the
																	// planet
									System.out.println("Null planet (not exists in ser file)");

									System.out.println("Not found!!!");
									JSONObject selectedPlanet = frame.json_resources.requestResources(Data.PLANETS,
											sel2);
									try {
										try {
											rotationPeriod = Integer
													.parseInt(selectedPlanet.get("rotation_period").toString());
										} catch (NumberFormatException unknown) {
											rotationPeriod = -1;
										}
										try {
											orbital_period = Integer
													.parseInt(selectedPlanet.get("orbital_period").toString());
										} catch (NumberFormatException unknown) {
											orbital_period = -1;
										}
										try {
											diameter = Integer.parseInt(selectedPlanet.get("diameter").toString());
										} catch (NumberFormatException unknown) {
											diameter = -1;
										}
										try {
											surfaceWater = Integer
													.parseInt(selectedPlanet.get("surface_water").toString());
										} catch (NumberFormatException unknown) {
											surfaceWater = -1;
										}
										try {
											population = Long.parseLong(selectedPlanet.get("population").toString());
										} catch (NumberFormatException unknown) {
											population = -1;
										}

										temp = new Planet(selectedPlanet.get("name").toString(), rotationPeriod,
												orbital_period, diameter, selectedPlanet.get("climate").toString(),
												selectedPlanet.get("gravity").toString(),
												selectedPlanet.get("terrain").toString(), surfaceWater, population);
										frame.planets.savePlanet(sel2, temp);
										frame.planetFeatures.setText(temp.getCharacteristics());

									} catch (NullPointerException nullPointer) {nullPointer.printStackTrace();

									} catch (JSONException e1) {

										e1.printStackTrace();
									}
								}
								if (frame.planets == null)
									System.out.println("null");
								else if (frame.planets.getPlanet(sel2) == null)
									System.out.println("null2!");
								else {
									frame.planetFeatures.setText(frame.planets.getPlanet(sel2).getCharacteristics());
									System.out.println("Already exist!");
								}
							}

						}

						void retrieveCharacter() {
							Character temp = null;
							int sel = 0;
							int height = 0;
							int mass = 0;

							if (frame.listedCharacters == null)
								System.out.println("NUll list");
							else {

								sel = frame.listedCharacters.getSelectedIndex();
								System.out.println("Selected index is:" + sel);
							}
							if ((sel != -1)&&(sel!=previousCharacter)) {
								temp = frame.characters.getCharacter(sel);
								if (temp.getEyeColour() == null) { // not exist in ser file download the features of the
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
										frame.characterFeatures.setText(temp.getCharacteristics());

									} catch (NullPointerException nullPointer) {

									} catch (JSONException e1) {

										e1.printStackTrace();
									}
								}
								if (frame.characters == null)
									System.out.println("null");
								else if (frame.characters.getCharacter(sel) == null)
									System.out.println("null2!");
								else {
									frame.characterFeatures
											.setText(frame.characters.getCharacter(sel).getCharacteristics());
									System.out.println("Already exist!");
								}
							}

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

		listedCharacters.setBounds(53, 24, 228, 20); // initialize combobox and text area of characters
		getContentPane().add(listedCharacters);
		characterFeatures = new JTextArea();
		characterFeatures.setBounds(53, 271, 228, 164);
		contentPane.add(characterFeatures);

		planetFeatures = new JTextArea(); // initialize combobox and text area of planets
		planetFeatures.setBounds(340, 271, 300, 164);
		contentPane.add(planetFeatures);
		listedPlanets.setBounds(340, 24, 228, 20);
		contentPane.add(listedPlanets);

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

	/**
	 * The following method is used for retrieving the total planets of Star Wars (
	 * access swapi website in order to find the total planets and then their names
	 * )
	 * 
	 * 
	 */
	private void requestPlanetsData() {

		SWData savedPlanets = SWData.restoreState(Data.PLANETS);
		String names[] = null;
		if (savedPlanets instanceof Planets) {

			planets = (Planets) savedPlanets;
			json_resources = new Resources();
			int total_planets = 0;
			try {

				total_planets = (json_resources.requestResources(Data.PLANETS, 0)).getInt("count") + 1; //

				System.out.println("Total planets=" + total_planets);
			} catch (JSONException e2) {

				e2.printStackTrace();
			}
			// initialize the list of the planets
			if (planets.getPlanet(1) == null) {

				SWThread.data = Data.PLANETS;

				names = SWThread.downloadFeatureNames(total_planets);

				planets.setTotalPlanets(total_planets);
				try {
					Thread.sleep(15000);
					for (int i = 1; i < total_planets; i++) {
						planets.savePlanet(i, new Planet(names[i]));

						System.out.println("i= " + i + "\t planet   " + planets.getPlanet(i).getName());
					}
				} catch (InterruptedException e) {

					e.printStackTrace();
				}

			} else {

				int saved = planets.getTotalPlanets();
				System.out.println("Size= " + saved);
				if (saved != total_planets) {

					names = new String[total_planets];

				} else
					names = new String[saved];

				for (int i = 1; i < saved; i++) {

					names[i] = planets.getPlanet(i).getName();
				}
			}
		}
		listedPlanets = new JComboBox<String>(names);
		System.out.println("PLanets =" + names.length);
	}

	/**
	 * The following method is used for retrieving the total characters of Star Wars
	 * ( access swapi website in order to find the total characters and then their
	 * names )
	 * 
	 * 
	 */
	private void requestPeopleData() {

		SWData savedPeople = SWData.restoreState(Data.PEOPLE);
		String names[] = null;
		if (savedPeople instanceof People) {

			characters = (People) savedPeople;
			json_resources = new Resources();
			int total_chars = 0;
			try {
				// +2 because until 29/9/2018 they had wrong total number on count
				total_chars = (json_resources.requestResources(Data.PEOPLE, 0)).getInt("count") + 2; // get
																										// the
																										// current
																										// total
																										// characters
																										// of swapi
				System.out.println("Total characters=" + total_chars);
			} catch (JSONException e2) {

				e2.printStackTrace();
			}

			// initialize the list of the characters
			if (characters.getCharacter(1) == null) {

				SWThread.data = Data.PEOPLE;

				names = SWThread.downloadFeatureNames(total_chars);
				/// System.out.println("NUll is 1");
				characters.setTotalCharacters(total_chars);

				try {
					Thread.sleep(15000);
					for (int i = 1; i < total_chars; i++) {
						characters.saveCharacter(i, new Character(names[i]));

						System.out.println("i= " + i + "\t character   " + characters.getCharacter(i).getName());
					}
				} catch (InterruptedException e) {

					e.printStackTrace();
				}

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

		System.out.println("People = " + names.length);
		listedCharacters = new JComboBox<String>(names);

	}
}
