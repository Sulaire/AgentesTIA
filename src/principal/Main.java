package principal;

import java.io.File;
import java.util.Scanner;

import agentesTIA.Espionaje;
import agentesTIA.Jefazo;
import inputOutput.IOData;

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
				/*
				 * int money = 0; Scanner scanMoney = new Scanner(System.in);
				 * System.out.println("Dime la cifra a buscar"); money = scanMoney.nextInt();
				 * 
				 * System.out.println(money);
				 */
				break;
			case 3:
				// System.out.println("Aqui el piso");
				

				break;
			case 4:
				// System.out.println("Aqui el arma");

				break;
			case 5:
				switch (Funciones.printAgent()) {
				case 1:
					break;
				case 2:
					break;
				case 3:
					break;
				case 4:
					break;
				}
				// inputOutput.IOData.saveAgentsFile("Agentes.dat", vAgents);
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
