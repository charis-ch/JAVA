import java.util.HashMap;


public class People extends SWData {
	
private 	HashMap<Integer, Character>  characters=new HashMap<Integer, Character>();
	
	
	
	Character getCharacter(Integer character){
		
		return (Character) characters.get(character);
		
	}

	void saveCharacter(Integer key, Character value){
		characters.put(key, value);
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
