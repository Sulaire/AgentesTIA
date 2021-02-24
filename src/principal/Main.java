package principal;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		int opt = 0;

		// Switch del menu principal
		do {

			opt = principal.Funciones.printMenu();
			
			switch (opt) {

			case 1:
				System.out.println("Agentes listados");

				break;
			case 2:
				int money = 0;
				Scanner scanMoney = new Scanner(System.in);
				System.out.println("Dime la cifra a buscar");
				money = scanMoney.nextInt();

				System.out.println(money);
				break;
			case 3:
				System.out.println("Aqui el piso");

				break;
			case 4:
				System.out.println("Aqui el arma");

				break;
			case 5:
				// Alistar un agente
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

				break;
			case 6:
				System.out.println("Aqui encriptar");

				break;
			case 7:
				System.out.println("Aqui desencriptar");

				break;
			case 8:
				System.out.println("Buena suerte, Don Vivi");
				break;
				
			}
			
			

		} while (opt != 8);

	}

}
