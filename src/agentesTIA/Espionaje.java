package agentesTIA;

public class Espionaje extends Agente{

	private String safeHouses;

	public Espionaje(String name, int age, String direction, double salary, String safeHouses) {
		super(name, age, direction, salary);
		this.safeHouses = safeHouses;
	}

	public String getSafeHouses() {
		return safeHouses;
	}

	public void setSafeHouses(String safeHouses) {
		this.safeHouses = safeHouses;
	}

	
	@Override
	public String toString() {
		return super.toString()+"Pisos francos: "+safeHouses
				+"\n********************************************";
	}
	
	
	
}
