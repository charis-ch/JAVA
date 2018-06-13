import java.io.Serializable;

public class Planet implements Serializable {

	private String name;
	private int rotationPeriod;
	private int orbital_period;
	private int diameter;
	private String climate;
	private String gravity;
	private String terrain;
	private int surfaceWater;
	private int population;

	public Planet(String name, int rotationPeriod, int orbital_period, int diameter, String climate, String gravity,
			String terrain, int surfaceWater, int population) {
		this.name = name;
		this.rotationPeriod = rotationPeriod;
		this.orbital_period=orbital_period;
		this.diameter = diameter;
		this.climate = climate;
		this.gravity = gravity;
		this.terrain = terrain;
		this.surfaceWater = surfaceWater;
		this.population = population;
	}

	public String getCharacteristics() {
		String characteristics = "";

		characteristics = "Name  " + this.name + "\n" + "Rotation period :" + this.rotationPeriod + "\n"
				+ "Orbital period :" + this.orbital_period + "\n" + "Diameter :" + this.diameter + "\n" + "Climate  "
				+ this.climate + "\n" + "Gravity :" + this.gravity + "\n" + "Terrain : " + this.terrain + "\n"
				+ "Surface water : " + this.surfaceWater + "\n" + "Population : " + this.population;

		return characteristics;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		System.out.println(
				"Unit testing for the class Planet has been started!\n******************************************************\n");

		Planet Tatooine = new Planet("Tatooine", 23, 304,10465,"arid","1 standard","desert",1,20000);
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


