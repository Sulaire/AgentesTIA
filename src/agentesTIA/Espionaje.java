package agentesTIA;

public class Espionaje extends Agente{

	private String[] safeHouses; // cambiar a vector

	public Espionaje(String name, int age, String direction, double salary) {
		super(name, age, direction, salary);
		this.safeHouses = inputOutput.IOData.readTxt("Pisos.txt");
	}


	
	@Override
	public String toString() {
		return super.toString()+"Pisos francos: "+safeHouses
				+"\n********************************************";
	}
	
	
	
}
