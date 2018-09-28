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
			System.out.println("The current state of "+feature.toString()+" has been saved!");
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
			
			switch (feature) {

			case PEOPLE: {System.out.println("File not found!\nCreation of the specified feature PEOPLE has been  started...\n");
				//: TODO initiliaze total characters 
				People people = new People();
				people.saveCharacter(0, null);
				return obj = people;
			}
			case PLANETS: { System.out.println("File not found!\nCreation of the specified feature PLANET has been  started...\n");
				Planets planets = new Planets();
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
