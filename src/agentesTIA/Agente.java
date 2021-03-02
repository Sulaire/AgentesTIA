package agentesTIA;

import java.io.Serializable;
import java.util.Scanner;
//Clase principal de la que heredan el resto de agentes
public class Agente implements Serializable {

	protected String name;
	protected int age;
	protected String direction;
	protected double salary;

	public Agente(String name, int age, String direction, double salary) {
		this.name = name;
		this.age = age;
		this.direction = direction;
		this.salary = salary;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Nombre: " + name + "\n" + "Edad: " + age + "\n"
				+ "Direccion: " + direction + "\n" + "Salario: " + salary + "\n";
	}

}
