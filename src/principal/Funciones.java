package principal;

import java.util.Scanner;

public class Funciones {

	/** 
	 * @author Jordi y Diego
	 * En esta clase se guardan algunas funciones que se repiten bastante a lo largo del programa
	 */
	
	/**
	 * @return esta funcion saca el menu por pantalla tantas veces como haga falta hasta que el usuario devuelva una opcion entre 1 y 8
	 */
	public static int printMenu() {

		int option = 0;

		Scanner scan = new Scanner(System.in);

		System.out.println("************" + "Bienvenido, Don Vivi" + "************");

		System.out.println("1: Ver los Agentes alistados");
		System.out.println("2: Filtrar los Agentes por su salario");
		System.out.println("3: Dar de alta un nuevo piso ");
		System.out.println("4: Dar de alta un nuevo arma");
		System.out.println("5: Dar de alta un nuevo agente");
		System.out.println("6: Encriptar toda la inforamcion");
		System.out.println("7: Desencriptar toda la informacion");
		System.out.println("8: Salir del programa");
		// Bucle para detectar errores
		do {

			try {

				option = scan.nextInt();
			} catch (Exception e) {
				System.out.println("El valor introducido no puede ser una letra");
				scan = new Scanner(System.in);
			}
			if (option < 1 || option > 8)
				System.out.println("Pon una opcion valida");
		} while (option < 1 || option > 8);

		return option;
	}
	
	/**
	 * @return esta funcion es parecida al menu anterior solo que es utilizada para a�adir el tipo de agente especifico segun la opcion escogida por el usuario (que debera ser un numero entre 1 y 4)
	 */
	public static int printAgent() {
		int option = 0;

		Scanner scan = new Scanner(System.in);

		System.out.println("Que tipo de agente quiere dar de alta");
		System.out.println("1: Jefazo");
		System.out.println("2: Agente 007");
		System.out.println("3: Agente de espionaje");
		System.out.println("4: Salir");

		do {

			try {

				option = scan.nextInt();
				
			} catch (Exception e) {

				System.out.println("El valor introducido no puede ser una letra");
				scan = new Scanner(System.in);
			}
			if (option < 1 || option > 4)
				System.out.println("Pon una opcion valida");
				
		} while (option < 1 || option > 4);

		return option;
	}

	/**
	 * @param vAgents
	 * @return devuelve la primera posicion libre para poder a�adir un nuevo agente
	 */
	public static int freePosition(agentesTIA.Agente[] vAgents) {
	int pos = 0;
	
	for (int i = 0; i < vAgents.length; i++) {
		if (vAgents[i] == null) {
			pos = i;
			break;
		}
	}
		
	return pos;
	}
	
}
