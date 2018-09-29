import java.io.Serializable;

public class Planet implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5136817611475726278L;
	private String name;
	private int rotationPeriod;
	private int orbitalPeriod;
	private int diameter;
	private String climate;
	private String gravity;
	private String terrain;
	private int surfaceWater;
	private long population;

	public Planet(String name, int rotationPeriod, int orbital_period, int diameter, String climate, String gravity,
			String terrain, int surfaceWater, long population) {
		this.name = name;
		this.rotationPeriod = rotationPeriod;
		this.orbitalPeriod = orbital_period;
		this.diameter = diameter;
		this.climate = climate;
		this.gravity = gravity;
		this.terrain = terrain;
		this.surfaceWater = surfaceWater;
		this.population = population;
	}

	public Planet(String name) {

		this.name = name;

	}

	public int getRotationPeriod() {
		return this.rotationPeriod;

	}

	public int getOrditalPeriod() {
		return this.getOrditalPeriod();

	}

	public int getDiameter() {
		return this.diameter;

	}

	public int getSurfaceWater() {
		return this.surfaceWater;

	}

	public long getPopulation() {
		return this.population;

	}

	public String getClimate() {
		return this.climate;

	}

	public String getName() {

		return this.name;

	}

	private static String determineValueOf(int value) {
		return (value == -1) ? "Unkonwn" : String.valueOf(value);

	}

	public String getCharacteristics() {
		String characteristics = "";
		String rotationPeriod, diameter, orbitalPeriod, population, surfaceWater;
		rotationPeriod = determineValueOf(this.rotationPeriod);
		diameter = determineValueOf(this.diameter);
		orbitalPeriod = determineValueOf(this.orbitalPeriod);
		if (this.population == -1)
			population = "Unknown";
		else
			population = String.valueOf(this.population);
		surfaceWater = determineValueOf(this.surfaceWater);

		characteristics = "Name:                    " + this.name + "\n" + "Rotation period:   " + rotationPeriod + "\n"
				+ "Orbital period:      " + orbitalPeriod + "\n" + "Diameter:             " + diameter + "\n"
				+ "Climate:                " + this.climate + "\n" + "Gravity:                 " + this.gravity + "\n"
				+ "Terrain:                " + this.terrain + "\n" + "Surface water:    " + surfaceWater + "\n"
				+ "Population:         " + population;

		return characteristics;

	}

	/***
	 * 
	 * Unit testing for the Planet class.
	 * 
	 */

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(
				"Unit testing for the class Planet has been started!\n******************************************************\n");

		Planet Tatooine = new Planet("Tatooine", 23, 304, 10465, "arid", "1 standard", "desert", 1, 20000);
		System.out.println("Creating the Tatooine  object.\nPlease wait...\n");
		System.out.println("\n******************************************************");
		if (Tatooine == null) {
			System.err.println("Something when wrong with the initialization of  Tatooine character");
			System.exit(1);

		} else {
			System.out.println(Tatooine.getCharacteristics());
			System.out.println(
					"\nThe Tatooine object has been successfully created!!!\n******************************************************");
		}
	}

}
