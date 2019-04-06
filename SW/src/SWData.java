import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public abstract class SWData implements Serializable {

	/**
	 * 
	 * This class contains the necessary methods for storing and retrieving Star Wars data
	 * 
	 *  (Manipulates the ser files with the functionality of Serializable interface)
	 * 
	 */
	private static final long serialVersionUID = 1L;

	static void saveState(SWData obj, Data feature) {

		try {
			FileOutputStream file = new FileOutputStream(feature.name() + ".ser");
			ObjectOutputStream data = new ObjectOutputStream(file);
			data.writeObject(obj);
			data.close();
			file.close();
			System.out.println("The current state of " + feature.toString() + " has been saved!");
		} catch (IOException e) {
			e.printStackTrace();
			
		}
	}

	static SWData restoreState(Data feature) {

		SWData obj = null;

		try {
			FileInputStream file = new FileInputStream(feature.name() + ".ser");
			ObjectInputStream data = new ObjectInputStream(file);
			obj = (SWData) data.readObject();
			data.close();
			file.close();
		} catch (FileNotFoundException notfound) {

			switch (feature) {

			// initialize total characters
			case PEOPLE: {
				System.out.println("File not found!\nCreation of the specified feature PEOPLE has been  started...\n");

				People people = new People();
				people.saveCharacter(0, null);
				return obj = people;
			}
			// initialize total planets
			case PLANETS: {
				System.out.println("File not found!\nCreation of the specified feature PLANET has been  started...\n");
				Planets planets = new Planets();
				planets.savePlanet(0, null);
				return obj = planets;

			}

			}
			return obj;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
			return null;
		}

		return obj;
	}

	public void printSWdata() {

	}

	public static void main(String[] args) {

		SWData people = restoreState(Data.PEOPLE);

		People a = (People) people;
		if (a.getCharacter(1) == null)
			System.out.println("No characters exists");
		else {
			int sum = a.getTotalCharacters();

			int randomCharacter = (int) (Math.random() * sum + 1);
			System.out.println(
					"Character number " + randomCharacter + " is " + a.getCharacter(randomCharacter).getName());
		}

	}

}
