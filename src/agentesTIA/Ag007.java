package agentesTIA;

public class Ag007 extends Agente{

	
	private int kills;
	private String guns;
	
	public Ag007(String name, int age, String direction, double salary, int kills, String guns) {
		super(name, age, direction, salary);
		this.kills = kills;
		this.guns = guns;
	}

	
	public int getKills() {
		return kills;
	}

	public void setKills(int kills) {
		this.kills = kills;
	}

	public String getGuns() {
		return guns;
	}

	public void setGuns(String guns) {
		this.guns = guns;
	}
	
	@Override
	public String toString() {
		return super.toString()+"Numero de bajas: " +kills+"\n"
				+"Armas disponibles: "+guns
				+"\n********************************************";
	}
	
}
