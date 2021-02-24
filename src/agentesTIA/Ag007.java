package agentesTIA;

public class Ag007 extends Agente{

	
	private int kills;
	private String[] guns;
	
	public Ag007(String name, int age, String direction, double salary, int kills) {
		super(name, age, direction, salary);
		this.kills = kills;
		//this.guns = IODatos.cargarDatosTexto("Armas.txt");
	}

	
	public int getKills() {
		return kills;
	}

	public void setKills(int kills) {
		this.kills = kills;
	}
	
	@Override
	public String toString() {
		return super.toString()+"Numero de bajas: " +kills+"\n"
	//			+"Armas disponibles: "+guns
				+"\n********************************************";
	}
	
}
