package inputOutput;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

import agentesTIA.Agente;

public class IOData {

	
	/**
	 * Desencripta los archivos pisos y armas
	 * Recibe la ruta de los archivo, el vector y la ruta del archivo a borrar
	 * 
	 * @param route				ruta del archivo destino
	 * @param vString			Vector que se va a guardar
	 * @param routeToDelete		ruta del archivo origen
	 */
	public static void decrypt(String route, String[] vString, String routeToDelete) {

		File f = new File(route);
		File f2 = new File(routeToDelete);
		// Comprueba si el archivo est� creado
		if (!f.exists()) {
			try {
				f.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// Se declara FileOutputStream y DataOutputStream (escribe en UTF)
		try (FileOutputStream fi = new FileOutputStream(f); DataOutputStream write = new DataOutputStream(fi)) {
			// Recorre el array comprobando si la posicion del vector esta vacia
			for (int i = 0; i < vString.length; i++) {
				if (vString[i] == null) {
					break;
				} else
					write.writeUTF(vString[i]);

			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Borra el archivo anterior
		f2.delete();
	}

	// Encripta los archivos pisos y armas
	// Recibe la ruta de los archivo, el vector y la ruta del archivo a borrar
	public static void encrypt(String route, String[] vString, String routeToDelete) {

		File f = new File(route);
		File f2 = new File(routeToDelete);
		// Comprueba si el archivo existe
		if (!f.exists()) {
			try {
				f.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// Se declaran FileWriter y PrintWriter (escribe en UTF)
		try (FileWriter fw = new FileWriter(f); PrintWriter write = new PrintWriter(fw)) {
			// Recorre el array comprobando si la posicion del vector esta vacia para
			// escribir
			for (int i = 0; i < vString.length; i++) {
				if (vString[i + 1] == null) {
					write.write(vString[i]);
					break;
				} else
					write.write(vString[i] + "\n");

			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Borra el archivo anterior
		f2.delete();
	}

	// Escribe el archivo en txt
	public static void writeTxt(String add, String route) {
		File f = new File(route);
		// Comprueba si el archivo existe
		if (!f.exists()) {
			try {
				f.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		try (FileWriter fw = new FileWriter(f, true); PrintWriter write = new PrintWriter(fw)) {

			write.write("\n" + add);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// Lee los archivos armas y pisos
	public static String[] readTxt(String route) {

		String[] vString = new String[50];
		int cont = 0;

		File f = new File(route);

		if (!f.exists()) {
			try {
				f.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		try (FileReader fr = new FileReader(f); Scanner read = new Scanner(fr)) {
			
			while (read.hasNextLine()) {
				vString[cont] = read.nextLine();

				cont++;
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return vString;
	}
	//Lee el archivo en Binario (lo mismo que el anterior)
	public static String[] readBinary(String route) {

		String[] vString = new String[50];
		int cont = 0;

		File f = new File(route);

		if (!f.exists()) {
			try {
				f.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		try (FileInputStream fi = new FileInputStream(f); DataInputStream read = new DataInputStream(fi);) {
			//Recorres array hasta que reciba error por no leer mas
			while (true) {
				vString[cont] = read.readUTF();
				cont++;
			}
		//Se controla el error aqui pues es bucle infinito
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
		}

		return vString;
	}
	//Guarda el archivo agentes
	public static void saveAgentsFile(String route, Agente[] vAgents) {
		File f = new File(route);
		
		if (!f.exists()) {
			try {
				f.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//Escribe en el vector vAgentes
		try (FileOutputStream fo = new FileOutputStream(f); ObjectOutputStream write = new ObjectOutputStream(fo);) {
			write.writeObject(vAgents);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	//Actualiza el archivo agtentes
	public static Agente[] uploadAgentsFile(String route) {
		//Se inicia el vector
		Agente[] vAgents = null;

		File f = new File(route);
		
		if (!f.exists()) {
			try {
				f.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		try (FileInputStream fi = new FileInputStream(f); ObjectInputStream read = new ObjectInputStream(fi)) {
			//Se rellena el vector
			try {
				//Se lee como clase Object y se parsea a la clase Agente, para poder usarla
				vAgents = (Agente[]) read.readObject();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return vAgents;
	}

}
