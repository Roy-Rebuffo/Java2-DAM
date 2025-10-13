package Principal;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/*Agregar nuevos contactos al fichero.
Mostrar todos los contactos en consola.
Objetivo: Este ejercicio tiene como objetivo que te familiarices con el manejo básico de ficheros de texto, practicando la lectura y escritura secuencial.

Ideas básicas para la resolución:

Usar la clase ‘FileWriter’ para escribir en el fichero.
Usar la clase ‘BufferedReader’ para leer los contactos desde el fichero.
El fichero debe actualizarse en cada ejecución sin borrar el contenido previo (modo ‘append’).
Utilizar una estructura de datos como ‘ArrayList’ para manejar los contactos temporalmente antes de escribirlos en el fichero.
Normas básicas de entrega:

El código debe estar comentado y ser claro.
Subir el proyecto en un único archivo comprimido (.zip) con un README que explique cómo ejecutarlo.
El nombre del fichero de texto debe ser "contactos.txt".*/
public class main {
	public static Scanner sc = new Scanner(System.in);

	public static void crearFichero() {
		/* Definimos donde vamos a guardar los contacos */
		ArrayList<String> contactos = new ArrayList<String>();/* Importamos ArrayList */

		/* Preguntamos al usuario para que introduzca los datos del contacto */
		System.out.println("Desea introducir algun usuario a la lista de contactos? (S/N)");
		String res = sc.nextLine();
		
		/*Si no existe la carpeta la crea*/
		File carpeta = new File("contactos");
		if (!carpeta.exists()) carpeta.mkdir();


		while (res.equalsIgnoreCase("S")) {
			System.out.print("Introduzca el nombre: ");
			String nombre = sc.nextLine();
			System.out.print("Introduzca el apellido: ");
			String apellido = sc.nextLine();
			System.out.print("Introduzca el telefono: ");
			int telefono = Integer.valueOf(sc.nextLine());

			String contacto = nombre + "," + apellido + "," + telefono;/* variable que recoge los datos introducidos. Separamos por comas*/

			contactos.add(contacto); /* Meto el contacto en el ArrayList */

			/* Vuelvo a preguntar por si quiere introducir mas contactos */
			System.out.println("¿Desea introducir otro contacto? (S/N)");
			res = sc.nextLine();
		}

		try (BufferedWriter bw = new BufferedWriter(new FileWriter("contactos/contactos.txt",true)); /* Creamos el fichero con modo append (true)*/
		) {
			/* Recorro los contactos y los introduzco dentro del archivo */
			for (String c : contactos) {
				bw.write(c + "\n");
			}
			System.out.println("Contactos guardados correctamente.");

		} catch (FileNotFoundException ex) {
			System.err.println("Fichero no encontrado");
		} catch (IOException ex) {
			System.err.println(ex.getMessage());
		}
	}

	public static void leerFichero() {
	    String linea = "";
	    ArrayList<String> lista = new ArrayList<>();
	    
	    try (BufferedReader br = new BufferedReader(new FileReader("contactos/contactos.txt"))) {
	    	linea = br.readLine();
	        while (linea!=null) {
	            // mostramos la línea
	            System.out.println(linea);
	            // guardamos la línea completa en la lista
	            lista.add(linea);
	            linea = br.readLine();
	        }

	        System.out.println("\nContactos cargados en la lista correctamente.");

	    } catch (FileNotFoundException ex) {
	        System.err.println("Fichero no encontrado");
	    } catch (IOException ex) {
	        System.err.println("Error al leer el fichero: " + ex.getMessage());
	    }
	}


	public static void main(String[] args) {
		crearFichero();
		leerFichero();
	}

}
