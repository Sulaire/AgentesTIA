package agentesTIA;

public class Ag007 extends Agente{

	
	private int kills;
	private String[] guns;
	
	public Ag007(String name, int age, String direction, double salary, int kills) {
		super(name, age, direction, salary);
		//Campos unico de Ag007
		this.kills = kills;
		this.guns = inputOutput.IOData.readTxt("recursos/Armas.txt");
	}

	
	public int getKills() {
		return kills;
	}

	public void setKills(int kills) {
		this.kills = kills;
	}
	
	@Override
	public String toString() {
		
		
		String possibleGuns = "";
		
		for (String string : guns) {
			if (string!=null) {
				possibleGuns += string+"-";
			}
		}
		
		
		return super.toString()+"Numero de bajas: " +kills+"\n"
				+"Armas disponibles: "+possibleGuns+"\n-----------------------------------------";
	}
	
}
