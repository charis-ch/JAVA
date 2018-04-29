import java.util.HashMap;


public class People extends SWData {
	
	HashMap<Integer, People>  characters=new HashMap<Integer, People>();
	
	
	
	People getCharacter(Integer character){
		
		return (People) characters.get(character);
		
	}

	void saveCharacter(Integer key, People value){
		characters.put(key, value);
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
