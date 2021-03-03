package agentesTIA;

import java.util.ArrayList;

public class Espionaje extends Agente{

	private ArrayList<String> safeHouses; // cambiar a vector

	public Espionaje(String name, int age, String direction, double salary) {
		super(name, age, direction, salary);
		//Campo unico de Espionaje
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
