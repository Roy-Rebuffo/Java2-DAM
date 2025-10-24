package Principal;

import java.io.EOFException;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

import Clases.Biblioteca;
import Clases.CLibros;
import Clases.CPersona;

public class mainLibrosHashMap {
	public static Scanner sc = new Scanner(System.in);

	/************************************************************************/
	public static void crearFichero(File fichero, boolean añadir) throws FileNotFoundException, IOException {
		ArrayList<CLibros> lista = new ArrayList<CLibros>();
		
		HashMap<String,ArrayList<CLibros>> listaHash = new HashMap<>();
		
		ObjectOutputStream oos = null;
		String respuesta, nombre, autor;
		LocalDate fecha;
		try {
			if (!añadir) {
				oos = new ObjectOutputStream(new FileOutputStream(fichero));
			} else {
				oos = new ObjectOutputStream(new FileOutputStream(fichero, true)) {
					protected void writeStreamHeader() throws IOException {
						reset();
					}
				};
			}
			do {
				System.out.print("Dime el nombre: ");
				nombre = sc.nextLine();
				System.out.print("Dime el autor: ");
				autor = sc.nextLine();
				System.out.print("Dime la fecha: ");
				fecha = LocalDate.parse(sc.nextLine());

				lista.add(new CLibros(nombre, autor, fecha));
				
				listaHash.put(nombre, lista);

				System.out.println("Quiere usted segir añadiendo registros?");
				respuesta = sc.nextLine();
			} while (respuesta.equalsIgnoreCase("SI"));
			oos.writeObject(listaHash);
		} finally {
			oos.close();
		}
	}

	/************************************************************************/
	public static void mostrarFichero(File fichero) {
	    HashMap<String, CLibros> aux = null;

	    try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fichero))) {
	        do {
	            aux = (HashMap<String, CLibros>) ois.readObject();

	            if (aux instanceof HashMap) {
	                for (Map.Entry<String, CLibros> entry : aux.entrySet()) {
	                    System.out.println("Clave: " + entry.getKey() + " → " + entry.getValue());
	                }
	            }
	        } while (true);

	    } catch (EOFException ex) {
	        System.out.println("Fin del fichero");
	    } catch (Exception ex) {
	        System.out.println("Error leyendo fichero: " + ex.getMessage());
	    }
	}


	/************************************************************************/
	public static void crear() {
		File fichero = null;
		String nombreFichero = null, respuesta;
		
		try {
			System.out.println("Indique el nombre del fichero");
			nombreFichero = sc.nextLine();
			fichero = new File(nombreFichero);
			
			if(fichero.exists()) {
				System.out.println("El fichero existe. Quiere usted añadir registros?");
				respuesta = sc.nextLine();
				if(respuesta.equalsIgnoreCase("SI")) {
					crearFichero(fichero, true);
				}
			}else {
				crearFichero(fichero,false);
			}
		} catch (IOException ex) {
			System.out.println(ex.getMessage());
		}
	}
	/************************************************************************/
	public static void leer() throws IOException {
		File fichero = null;
		String nombreFichero = null, respuesta;
		
		System.out.println("Indique el nombre del fichero");
		nombreFichero = sc.nextLine();
		fichero = new File(nombreFichero);
		
		if(fichero.exists()) {
			mostrarFichero(fichero);
			
		} else {
			System.out.println("El fichero " + nombreFichero + " no existe.");
		}	
	}
	/****************************************************************************/
	public static void main(String[] args) throws IOException {
		String[] opciones = { "1.-Crear Fichero", "2.-Leer fichero", "3.-Salir" };
		int op;
		String basura;

		do {
			op = Biblioteca.menu(sc, opciones);

			switch (op) {
			case 1: //Crear fichero
				crear();
				break;
			case 2: //Leer fichero
				leer();
				break;
			}
			if (op != opciones.length) {
				System.out.print("\tPresione una tecla para continuar");
				basura = sc.nextLine();
			}
		} while (op != opciones.length);
	}
	/************************************************************************/

}
