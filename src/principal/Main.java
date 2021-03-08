package principal;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

import agentesTIA.Espionaje;
import agentesTIA.Jefazo;
import inputOutput.IOData;

import agentesTIA.Ag007;
import agentesTIA.Agente;

public class Main {

	/**
	 * @author Jordi y Diego
	 * @version 1.0
	 * @param args
	 */
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int opt = 0;

		// Aqui se carga el vector llamando a la funcion uploadAgentsFile
		ArrayList<Agente> vAgents = inputOutput.IOData.uploadAgentsFile("recursos/Agentes.dat");
	//	ArrayList<Agente> vAgents = new ArrayList<>();
		do {
		
			// Switch del menu principal.
			switch (principal.Funciones.printMenu()) {

			case 1:
				ViewAllAgents(vAgents);

				break;
				
				
			case 2:
				viewAgentsBySalary(vAgents);

				break;
				
				
			case 3:
				addFlat();

				break;
				
				
			case 4:
				addGun();

				break;
				
				
			case 5:
				addAgent(vAgents);
				break;
				
				
			case 6:
				//La opcion 6 se utiliza para encriptar los archivos de armas y pisos
				File fArmas = new File("recursos/Armas.txt");

				if (!fArmas.exists()) {
					System.out.println("Los archivos ya estan encriptados");
				} else {
					//Primero se leeran los archivos de texto, se rellenaran dos vectores String (uno de armas y otro de pisos) y por ultimo se rellenaran dos archivos binarios con la informacion de los vectores
					ArrayList<String> vPisos = inputOutput.IOData.readTxt("recursos/Pisos.txt");
					inputOutput.IOData.decrypt("recursos/Pisos.dat", vPisos, "recursos/Pisos.txt");
					ArrayList<String> vArmas = inputOutput.IOData.readTxt("recursos/Armas.txt");
					inputOutput.IOData.decrypt("recursos/Armas.dat", vArmas, "recursos/Armas.txt");

					System.out.println("Archivos encriptados");
				}
				IOData.delAllTxt("recursos");
				break;
				
				
			case 7:
				//La opcion 6 se utiliza para desencriptar los archivos de armas y pisos
				File fArmas2 = new File("recursos/Armas.dat");

				if (!fArmas2.exists()) {
					System.out.println("Los archivos ya estan desencriptados");
				} else {
					//Primero se leeran los archivos binarios, se rellenaran dos vectores String (uno de armas y otro de pisos) y por ultimo se rellenaran dos archivos de texto con la informacion de los vectores
					ArrayList<String> vPisos2 = inputOutput.IOData.readBinary("recursos/Pisos.dat");
					inputOutput.IOData.encrypt("recursos/Pisos.txt", vPisos2, "recursos/Pisos.dat");
					ArrayList<String> vArmas2 = inputOutput.IOData.readBinary("recursos/Armas.dat");
					inputOutput.IOData.encrypt("recursos/Armas.txt", vArmas2, "recursos/Armas.dat");

					System.out.println("Archivos desencriptados");
				}
				break;
				
				
			case 8:
				//La opcion 8 es la que finaliza el programa
				System.out.println("Buena suerte, Don Vivi");
				opt = 8;				
				break;
			}

		} while (opt != 8);

	}

	private static void addAgent(ArrayList<Agente> vAgents) {
		//La opcion 5 sirve para registrar un nuevo agente
		int ag = Funciones.printAgent();
		int age = 0;
		double salary = 0;
		String name;
		String direction;
		System.out.println("Dime los datos del agente");
		Scanner readString = new Scanner(System.in);
		Scanner readInt = new Scanner(System.in);
		Scanner readDouble = new Scanner(System.in);
		
		
		//Aqui se pide el nombre
		System.out.println("Nombre:");
		name = readString.nextLine();
		
		//Aqui se pide la edad*
		do {
			try {
				System.out.println("Edad");
				age = readInt.nextInt();
				if (age < 0) {
					System.out.println("El numero no puede ser negativo");
				}
			} catch (Exception e) {
				System.out.println("Introduce un numero valido");
				readInt = new Scanner(System.in);
			}
		} while (age <= 0);
		
		//Aqui se pide la direccion*/
		System.out.println("Direccion");
		direction = readString.nextLine();
		
		
		//Aqui se pide el salario
		do {
			try {
				System.out.println("Salario");
				salary = readDouble.nextDouble();
				if (salary < 0) {
					System.out.println("El numero no puede ser negativo");
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println("Introduce un numero vaido");
				readDouble = new Scanner(System.in);
			}
		} while (salary <= 0);
		
		
		switch (ag) {
		//En este switch se indicara el tipo de agente a introducir y dependiendo de cada uno pedira su informacion especifica
		case 1:
			int yearsLeading;
			System.out.println("Anos de mandato");
			yearsLeading = readInt.nextInt();
			vAgents.add(new agentesTIA.Jefazo(name, age, direction, salary,
					yearsLeading));

			break;
		case 2:
			int kills = 0;
			do {
				try {
					System.out.println("Numero de bajas");
					kills = readInt.nextInt();
					if (kills < 0) {
						System.out.println("El numero no puede ser negativo");
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					System.out.println("Introduce un numero valido");
					readInt = new Scanner(System.in);
				}
			} while (kills < 0);
			vAgents.add(new agentesTIA.Ag007(name, age, direction, salary,
					kills));
			break;
		case 3:
			vAgents.add(new agentesTIA.Espionaje(name, age, direction, salary));
			break;
		case 4:
			break;
		}
		inputOutput.IOData.saveAgentsFile("recursos/Agentes.dat", vAgents);
	}

	private static void addGun() {
		//La opcion 4 sirve para a�adir una nueva arna al archivo Armas.txt
		File f2 = new File("recursos/Armas.txt");
		Scanner read2 = new Scanner(System.in);
		if (!f2.exists()) {
			System.out.println("El archivo está encriptado, desencríptalo primero");
		} else {

		}

		String gun = "";
		System.out.println("Dime la nueva arma disponible");
		gun = read2.nextLine();
		IOData.writeTxt(gun, "recursos/Armas.txt");
	}

	private static void addFlat() {
		//La opcion 3 sirve para a�adir un nuevo piso franco al archivo Pisos.txt
		File f = new File("recursos/Pisos.txt");
		Scanner read = new Scanner(System.in);
		if (!f.exists()) {
			System.out.println("El archivo esta encriptado, desencriptalo primero");
		}

		String flat = "";
		System.out.println("Dime el nuevo piso franco que se podra utilizar");
		flat = read.nextLine();
		IOData.writeTxt(flat, "recursos/Pisos.txt");
	}

	private static void viewAgentsBySalary(ArrayList<Agente> vAgents) {
		//La opcion 2 muestra los agentes con un sueldo superior al introducido por el usuario
		int money = -8;
		Scanner scanMoney = new Scanner(System.in);
		System.out.println("Dime la cifra a buscar");
		do {
			try {

				money = scanMoney.nextInt();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println("El valor introducido no puede ser una letra");
				System.out.println("Pon una opcion valida");
				scanMoney = new Scanner(System.in);
			}
		} while (money == -8);

		System.out.println("Estos son los agentes que cobran mas de " + money + " euros");
		for (int i = 0; i < vAgents.size(); i++) {
			if (vAgents.get(i) != null && vAgents.get(i).getSalary() > money) {
				System.out.println(vAgents.get(i).toString());
			}
		}
	}

	private static void ViewAllAgents(ArrayList<Agente> vAgents) {
		//La opcion 1 muestra por pantalla todos los agentes registrados
		for (Agente a : vAgents) {
			
				System.out.println(a.toString());
			
		}
	}

}
