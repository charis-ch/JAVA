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

	private static void saveState(SWData obj, Data feature) {

		try {
			FileOutputStream file = new FileOutputStream("/tmp/" + feature.name() + ".ser");
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
			FileInputStream file = new FileInputStream("/tmp/" + feature.name() + ".ser");
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
			case PLANETS: {
				return null;
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
