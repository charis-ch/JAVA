import java.util.HashMap;

public class People extends SWData {

	/**
	 * 
	 */
	private static final long serialVersionUID = 931236300641646756L;
	private int totalCharacters;
	private HashMap<Integer, Character> characters = new HashMap<Integer, Character>();

	
	public void setTotalCharacters(int total){
		
		
		totalCharacters=total;
	}
	
	

	public int getTotalCharacters(){
		
		
		return totalCharacters;
	}	
	
	
	public void printKnownCharacters(){
		
		for(Integer key:characters.keySet()){
		try {	
			Character temp=characters.get(key);
			//System.out.println("NUmber : "+key+"\t"+temp.getName());
			System.out.println(temp.getCharacteristics());
		}catch (NullPointerException e) {
			
		}
		
		
			
		}
		
	}
	/**
	 * 
	 * This method retrieves a character according to a number(the specified number is based on the 
	 * swapi-appearance of the characters)
	 * 
	 * 
	 * */
	Character getCharacter(Integer character) {

		return (Character) characters.get(character);

	}

	/**
	 * 
	 * The following method inserts to known characters a new character.
	 * 
	 * 
	 * */
	void saveCharacter(Integer key, Character value) {
		characters.put(key, value);

	}
	
	/**
	 * 
	 * Unit testing for People class
	 *  
	 * In the main method 2 characters are created and randomly 
	 * one of them is displayed on the console
	 *
	 * 
	 * */

	public static void main(String[] args) {

		People people = new People();
		Character Luke = new Character("Luke Skywalker", 172, 77, "Blond", "Fair", "Blue", "19BBY");
		Character Darth = new Character("Darth Vader", 202, 136, "none", "white", "yellow", "41.9BBY");
		people.saveCharacter(4, Darth);
		people.saveCharacter(1, Luke);
		int randomCharacter = (int) (Math.random() * 2);
		if (randomCharacter == 0)
			randomCharacter = 1;
		else
			randomCharacter = 4;
		Character temp=people.getCharacter(randomCharacter);
		System.out.println("Random character is: "+temp.getName());

		
		


	}

}
