import java.util.HashMap;

public class Planets extends SWData {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int totalPlanets;
	private HashMap<Integer, Planet> planets = new HashMap<Integer, Planet>();
	void savePlanet(Integer key, Planet value) {
		planets.put(key, value);

	}
	public int getTotalPlanets() {
		
		
		return this.totalPlanets;
		
	}
	Planet getPlanet(Integer planet) {

		return (Planet) planets.get(planet);

	}
	public void setTotalPlanets(int total){
		
		
		totalPlanets=total;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
