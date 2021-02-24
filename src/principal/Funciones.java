package principal;

import java.util.Scanner;

public class Funciones {

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

	public static String printAgent() {
		String agent = "";

		return agent;
	}

}
