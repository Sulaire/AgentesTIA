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
import java.util.ArrayList;
import java.util.Scanner;

import agentesTIA.Agente;

public class IOData {

	
	/**
	 * Desencripta los archivos pisos y armas
	 * Recibe la ruta de los archivo, el vector y la ruta del archivo a borrar
	 * 
	 * @param route				ruta del archivo destino
	 * @param vString			Vector que se va a guardar
	 * @param routeToDelete		ruta del archivo origen(la cual se borrara)
	 */
	public static void decrypt(String route, ArrayList<String> vString, String routeToDelete) {

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
			for (int i = 0; i < vString.size(); i++) {
					write.writeUTF(vString.get(i));

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
	
	/**
	 * Encripta los archivos pisos y armas
	 * Recibe la ruta de los archivo, el vector y la ruta del archivo a borrar
	 * 
	 * @param route				ruta del archivo destino
	 * @param vString			Vector que se va a guardar
	 * @param routeToDelete		ruta del archivo origen
	 */
	public static void encrypt(String route, ArrayList<String> vString, String routeToDelete) {

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
			for (int i = 0; i < vString.size(); i++) {
				if (i<(vString.size()-1)) {
					write.write(vString.get(i));
					break;
				} else
					write.write(vString.get(i) + "\n");

			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Borra el archivo anterior
		f2.delete();
	}
	
	/**
	 * Escribe el archivo en txt
	 * @param add		String que va a añadir en el fichero
	 * @param route		Ruta del fichero destino
	 */
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
 
	/**
	 * Lee los archivos armas y pisos
	 * @param route		ruta del archivo que lee
	 * @return			devuelve un vector String con lo que ha leido
	 */
	public static ArrayList<String> readTxt(String route) {

		ArrayList<String> vString = new ArrayList<>();

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
				vString.add(read.nextLine());
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
		
	/**
	 * Lee el archivo en Binario (lo mismo que el anterior)
	 * @param route		ruta del archivo que lee
	 * @return			devuelve un vector String con lo que ha leido
	 */
	public static ArrayList<String> readBinary(String route) {

		ArrayList<String> vString = new ArrayList<>();

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
				vString.add(read.readUTF());
			}
		//Se controla el error aqui pues es bucle infinito
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
		}

		return vString;
	}
		
	/**
	 * Guarda el archivo agentes
	 * @param route			ruta del fichero donde guardara la informacion
	 * @param vAgents		vector que se guardara en el fichero
	 */
	public static void saveAgentsFile(String route, ArrayList<Agente> vAgents) {
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
		
	/**
	 * Carga el archivo agtentes en el programa
	 * @param route		ruta del fichero para leerlo
	 * @return			devuelve un vector con los agentes guardados en el fi
	 */
	public static ArrayList<Agente> uploadAgentsFile(String route) {
		//Se inicia el vector
		ArrayList<Agente> vAgents = new ArrayList<Agente>();

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
				vAgents = (ArrayList<Agente>) read.readObject();
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

	
	public static void delAllTxt(String route) {
		File f = new File(route);
		
		if (!f.exists()) {
			try {
				f.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		for (File file : f.listFiles()) {
			   if (file.getName().endsWith(".txt")) {
			    file.delete();
			   }
		}
		
	}
}
