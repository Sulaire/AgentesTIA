package principal;

import java.util.Scanner;

import agentesTIA.Espionaje;
import agentesTIA.Jefazo;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		agentesTIA.Agente[] vAgents = inputOutput.IOData.uploadAgentsFile("Agentes.dat");
		
	
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
				// System.out.println("Aqui encriptar");
				break;
			case 7:
				// System.out.println("Aqui desencriptar");

				break;
			case 8:
				// System.out.println("Buena suerte, Don Vivi");
				break;
			}

		} while (opt != 8);

	}

}
