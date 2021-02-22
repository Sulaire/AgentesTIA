package agentesTIA;

public class Jefazo extends Agente{


	private int yearsLeading;

	public Jefazo(String name, int age, String direction, double salary, int yearsLeading) {
		super(name, age, direction, salary);
		this.yearsLeading = yearsLeading;
	}

	public int getYearsLeading() {
		return yearsLeading;
	}

	public void setYearsLeading(int yearsLeading) {
		this.yearsLeading = yearsLeading;
	}

	
	@Override
	public String toString() {
		return super.toString()+"Años de mandato: " +yearsLeading+"\n********************************************";
	}
	
	

}
