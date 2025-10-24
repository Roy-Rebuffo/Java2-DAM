package Principal;

import java.io.EOFException;

//siempre que querramos añadir objetos al fichero de esta forma tenemos que
//solventar errores con el else. es de la unica forma que se puede hacer
/*oos = new ObjectOutputStream(new FileOutputStream(fichero, true)) {
protected void writeStreamHeader() throws IOException {
	reset();*/

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.Scanner;

import Clases.Biblioteca;
import Clases.CLibros;

public class mainLibros {
	public static Scanner sc = new Scanner(System.in);

	/************************************************************************/
	public static void crearFichero(File fichero, boolean añadir) throws FileNotFoundException, IOException {
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
				System.out.print("Dime el apellido: ");
				autor = sc.nextLine();
				System.out.print("Dime la fecha (yyyy-mm-dd): ");
				fecha = LocalDate.parse(sc.nextLine());

				oos.writeObject(new CLibros(nombre, autor, fecha));

				System.out.println("Quiere usted segir añadiendo registros?");
				respuesta = sc.nextLine();
			} while (respuesta.equalsIgnoreCase("SI"));
		} finally {
			oos.close();
		}
	}

	/************************************************************************/
	public static void mostrarFichero(File fichero) {
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fichero));) {
			do {
				Object aux = ois.readObject();// Lee CPersona
				if (aux instanceof CLibros)
					System.out.println(aux);
			} while (true);

		} catch (EOFException ex) {
			System.out.println("Fin del fichero");
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
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
