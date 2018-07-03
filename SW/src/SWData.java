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
	 */
	private static final long serialVersionUID = 1L;

	 static void saveState(SWData obj, Data feature) {

		try {
			FileOutputStream file = new FileOutputStream( feature.name() + ".ser");
			ObjectOutputStream data = new ObjectOutputStream(file);
			data.writeObject(obj);
			data.close();
			file.close();
			System.out.println("The current state has been saved!");
		} catch (IOException e) {
			e.printStackTrace();
			// TODO: handle exception
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
			System.out.println("File not found!\nCreation of the specified features has been  started...\n");
			switch (feature) {

			case PEOPLE: {
				//: TODO initiliaze total characters 
				People people = new People();
				people.saveCharacter(0, null);
				return obj = people;
			}
			case PLANETS: {Planets planets = new Planets();
			planets.savePlanet(0, null);
			return obj = planets;
				
			}

			}
			return obj;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
			// TODO: handle exception
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

		return obj;
	}

	public void printSWdata() {

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
SWData people=restoreState(Data.PEOPLE);
//	System.out.println(people);
	People  a=(People) people;
	if(a.getCharacter(0)==null)
	System.out.println("No characters exists");
	}

}
