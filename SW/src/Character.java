import java.io.Serializable;

public class Character  implements Serializable{

	String name;
	int height;
	int mass;
	String hair_colour;
	String skin_colour;
	String eye_colour;
	String birth_year;

	/**
	 * 
	 * Character's constructor
	 * 
	 */
	public Character(String name, int height, int mass, String hair_colour, String skin_colour, String eye_colour,
			String birth_year) {

		this.name = name;
		this.hair_colour = hair_colour;
		this.skin_colour = skin_colour;
		this.height = height;
		this.eye_colour = eye_colour;
		this.birth_year = birth_year;
		this.mass = mass;

	}

	/**
	 * 
	 * 
	 * This function returns all the specified characteristics of the current
	 * character.
	 * 
	 */

	public String getCharacteristics() {
		String height = "";
		String mass = "";
		if (this.height == -1)
			height = "unknown";
		else
			height = String.valueOf(this.height) + " cm";
		if (this.mass == -1)
			mass = "unknown";
		else
			mass = String.valueOf(this.mass) + " Kg";
		return "Name:        " + name + "\n" + "Height:      " + height + "\n" + "Mass:        " + mass + "\n"
				+ "Hair colour: " + hair_colour + "\n" + "Skin colour: " + skin_colour + "\n" + "Eye colour:  "
				+ eye_colour + "\n" + "Birth year:  " + birth_year;

	}

	public String getName() {

		return this.name;

	}

	public Character(String name) {
		// TODO Auto-generated constructor stub

		this.name = name;
	}

	/***
	 * 
	 * Unit testing for the Character class.
	 * 
	 */
	@SuppressWarnings("unused")
	public static void main(String[] args) {

		System.out.println(
				"Unit testing for the class Character has been started!\n******************************************************\n");

		Character Luke = new Character("Luke Skywalker", 172, 77, "Blond", "Fair", "Blue", "19BBY");
		System.out.println("Creating the Luke  object.\nPlease wait...\n");
		System.out.println("\n******************************************************");
		if (Luke == null) {
			System.err.println("Something when wrong with the initialization of  Luke character");
			System.exit(1);

		} else {
			System.out.println(Luke.getCharacteristics());
			System.out.println(
					"\nThe Luke object has been successfully created!!!\n******************************************************");
		}
	}

}
