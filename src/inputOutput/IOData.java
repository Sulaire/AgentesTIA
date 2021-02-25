package inputOutput;

import java.io.DataInputStream;
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

public class IOData {
	
		
		public static void writeBinary(String route) {
			
			File f = new File(route);
			
			if (!f.exists()) {
				try {
					f.createNewFile();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			
			
			
			try(FileInputStream fi = new FileInputStream(f);
				DataInputStream write = new DataInputStream(fi)){
				
				
				
				
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		
		public static void writeTxt(String route) {
			
			File f = new File(route);
			
			if (!f.exists()) {
				try {
					f.createNewFile();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			
			
			
			try(FileWriter fw = new FileWriter(f); 
				PrintWriter write = new PrintWriter(fw)){
				
				
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		public static String[] readTxt(String route) {
			
			String[] vString = new String[50];
			int cont=0;
			
			File f = new File(route);
			
			if (!f.exists()) {
				try {
					f.createNewFile();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			
			try (FileReader fr = new FileReader(f);
				 Scanner read = new Scanner(fr)){
				
				while (read.hasNextLine()) {
					vString[cont]= read.nextLine();
					
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
		
		
		public static String[] readBinary(String route) {
			
			String[] vString = new String[50];
			int cont=0;
			
			File f = new File(route);
			
			if (!f.exists()) {
				try {
					f.createNewFile();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			
			try (FileInputStream fi = new FileInputStream(f);
				DataInputStream read = new DataInputStream(fi);){
				/*
				
				while (true) {
					vString[cont]= read.readUTF();
					cont++;
				}
				
				VOY POR AQUI, PREGUNTAR LECTURA Y EL SALTO DE LINEA
				*/
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			
			
			return vString;
		}
		
		
		public static void saveAgentsFile(String route, agentesTIA.Agente[] vAgents) {
			File f = new File(route);
			
			if (!f.exists()) {
				try {
					f.createNewFile();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			try (FileOutputStream fo = new FileOutputStream(f);
				ObjectOutputStream write = new ObjectOutputStream(fo);){
				write.writeObject(vAgents);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		public static agentesTIA.Agente[] uploadAgentsFile(String route){
			
			agentesTIA.Agente[] vAgents = null;
			
			File f = new File(route);
			
			if (!f.exists()) {
				try {
					f.createNewFile();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			
			try (FileInputStream fi = new FileInputStream(f);
				ObjectInputStream read = new ObjectInputStream(fi)){
				
				try {
					vAgents = (agentesTIA.Agente[])read.readObject();
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
