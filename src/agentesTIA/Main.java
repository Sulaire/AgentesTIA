package agentesTIA;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int option = 0 ;
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Bienvenido, Don Vivi");
		
		System.out.println("¿Que acción quiere realizar?");
		System.out.println("1º: Ver los Agentes alistados");
		System.out.println("2º: Filtrar los Agentes por su salario");
		System.out.println("3º: Dar de alta un nuevo piso ");
		System.out.println("4º: Dar de alta un nuevo arma");
		System.out.println("5º: Dar de alta un nuevo agente");
		System.out.println("6º: Encriptar toda la inforamción");
		System.out.println("7º: Desencriptar toda la información");
		System.out.println("8º: Salir del programa");
		
		option = scan.nextInt();
		
		switch (option) {
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
			System.out.println("Aqui el agente");
			
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
		
	}

}
