package principal;

import java.io.File;
import java.util.Scanner;

import agentesTIA.Espionaje;
import agentesTIA.Jefazo;
import inputOutput.IOData;

import agentesTIA.Ag007;
import agentesTIA.Agente;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		agentesTIA.Agente[] vAgents = inputOutput.IOData.uploadAgentsFile("recursos/Agentes.dat");
		int opt = 0;

		do {
			// Switch del menu principal.
			switch (principal.Funciones.printMenu()) {

			case 1:
				// System.out.println("Agentes listados");

				break;
			case 2:
				int money = 0;
				Scanner scanMoney = new Scanner(System.in);
				System.out.println("Dime la cifra a buscar");
				money = scanMoney.nextInt();

				System.out.println("Estos son los agentes que cobran más de "+money+"€");
				for (int i = 0; i < vAgents.length; i++) {
					if (vAgents[i] != null && vAgents[i].getSalary() > money) {
						System.out.println(vAgents[i].toString());
					}
				}

				break;
			case 3:
				File f = new File("recursos/Pisos.txt");
				if (!f.exists()) {
					System.out.println("El archivo está encriptado, desencríptalo primero");
				}
				break;
			case 4:
				File f2 = new File("recursos/Armas.txt");
				if (!f2.exists()) {
					System.out.println("El archivo está encriptado, desencríptalo primero");
				} else {
					
				}

				break;
			case 5:
				int ag = Funciones.printAgent();
				String name;
				int age;
				String direction;
				double salary;
				System.out.println("Dime los datos del agente");
				Scanner readString = new Scanner(System.in);
				Scanner readInt = new Scanner(System.in);
				Scanner readDouble = new Scanner(System.in);
				System.out.println("Nombre:");
				name = readString.nextLine();
				System.out.println("Edad");
				age = readInt.nextInt();
				System.out.println("Direccion");
				direction = readString.nextLine();
				System.out.println("Salario");
				salary = readDouble.nextDouble();

				switch (ag) {

				case 1:
					int yearsLeading;
					System.out.println("Años de mandato");
					yearsLeading = readInt.nextInt();
					vAgents[Funciones.freePosition(vAgents)] = new agentesTIA.Jefazo(name, age, direction, salary,
							yearsLeading);

					break;
				case 2:
					int kills;
					System.out.println("Número de bajas");
					kills = readInt.nextInt();
					vAgents[Funciones.freePosition(vAgents)] = new agentesTIA.Ag007(name, age, direction, salary,
							kills);
					break;
				case 3:
					vAgents[Funciones.freePosition(vAgents)] = new agentesTIA.Espionaje(name, age, direction, salary);
					break;
				case 4:
					break;
				}
				inputOutput.IOData.saveAgentsFile("Agentes.dat", vAgents);
				break;
			case 6:
				File fArmas = new File("recursos/Armas.txt");
				
				if (!fArmas.exists()) {
					System.out.println("Los archivos ya estan encriptados");
				}else {
				String[] vPisos = inputOutput.IOData.readTxt("recursos/Pisos.txt");
				inputOutput.IOData.writeBinary("recursos/Pisos.dat", vPisos, "recursos/Pisos.txt");
				String[] vArmas = inputOutput.IOData.readTxt("recursos/Armas.txt");
				inputOutput.IOData.writeBinary("recursos/Armas.dat", vArmas, "recursos/Armas.txt");
				
				System.out.println("Archivos encriptados");
				}
				break;
			case 7:
				File fArmas2 = new File("recursos/Armas.dat");
				
				if (!fArmas2.exists()) {
					System.out.println("Los archivos ya estan desencriptados");
				}else {
				String[] vPisos2 = inputOutput.IOData.readBinary("recursos/Pisos.dat");
				inputOutput.IOData.writeTxt("recursos/Pisos.txt", vPisos2,"recursos/Pisos.dat");
				String[] vArmas2 = inputOutput.IOData.readBinary("recursos/Armas.dat");
				inputOutput.IOData.writeTxt("recursos/Armas.txt", vArmas2, "recursos/Armas.dat");
				
				System.out.println("Archivos desencriptados");
				}
				break;
			case 8:
				// System.out.println("Buena suerte, Don Vivi");
				break;
			}

		} while (opt != 8);

	}

}
