package agentesTIA;

public class Espionaje extends Agente{

	private String[] safeHouses; // cambiar a vector

	public Espionaje(String name, int age, String direction, double salary) {
		super(name, age, direction, salary);
		this.safeHouses = inputOutput.IOData.readTxt("recursos/Pisos.txt");
	}



	@Override
	public String toString() {
		
		String possibleHouses = "";
		
		for (String string : safeHouses) {
			if (string!=null) {
				possibleHouses += string+"-";
			}
		}
		
		
		return super.toString()+"Pisos francos: "+possibleHouses+"\n-----------------------------------------";
	}
	
	
	
}
