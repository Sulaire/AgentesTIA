package agentesTIA;


public class Jefazo extends Agente{


	private int yearsLeading;

	public Jefazo(String name, int age, String direction, double salary, int yearsLeading) {
		super(name, age, direction, salary);
		//Campo unico de Jefazo
		this.yearsLeading = yearsLeading;
	}
	
	public int getYearsLeading() {
		return yearsLeading;
	}

	public void setYearsLeading(int yearsLeading) {
		this.yearsLeading = yearsLeading;
	}

	//toString del Jefazo es diferente al resto
	@Override
	public String toString() {
		return "********************************************\n"+super.toString()+"Años de mandato: " +yearsLeading+"\n********************************************";
	}
	
	

}
