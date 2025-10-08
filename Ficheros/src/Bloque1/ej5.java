package Bloque1;
//leer una sola vez el fichero y nos cree para cada uno de los equipos distintos que hay en el fichero
//cuyo nombre sera nombre del equipo.csv
//y que contenga los integrantes de cada equipo

//HashMap (Clave(String equipo), valor (ArrayList <String> integrantes[]))
//contains key

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

public class ej5 {
	public static void crearSubdirectorio(String directorio) {
		//Ejemplo C:\\Ficheros;
		
		File fich = new File(directorio);
		if(!fich.exists()) {
			fich.mkdir();
		}else {
			if (!fich.isDirectory()) fich.mkdir();
		}	
	}

	public static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) throws IOException{
		String camino = "C:\\Users\\Alumno\\Desktop\\CLASE\\Programación\\Proyecto01\\Ficheros\\Equipos";
		String linea = "";
		String matriz [];
		crearSubdirectorio(camino);
		
		HashMap<String,ArrayList<String>> equipos = new HashMap<String,ArrayList<String>>();
		
		try(
				BufferedReader br = new BufferedReader(new FileReader("jugadores.csv"));
				) {
			
			linea = br.readLine(); //leemos la linea del fichero jugadores
			while(linea!=null) {
				matriz = linea.split(","); // metemos en una variable nueva el valor 7 de la linea
				
				if(!equipos.containsKey(matriz[7])) {
					equipos.put(matriz[7], new ArrayList<String>()); //Si no esta el equipo lo creamos en el hashmap
				}
				//accede al arraylist tanto si existe como si no existe
				ArrayList<String> nuevo = equipos.get(matriz[7]);
				nuevo.add(linea);
				equipos.put(matriz[7], nuevo);
				linea = br.readLine();
			}
		} catch(FileNotFoundException ex) {
			System.out.println("Fichero no encontrado");
		}catch(IOException ex) {
			System.out.println(ex.getMessage());
		}
		
		ArrayList<String> integrantes;
		
		for(Entry<String, ArrayList<String>> eq : equipos.entrySet()){//Acceder a la clave y al valor mediante la colección Entry
			System.out.println(eq.getKey() + eq.getValue());
			integrantes = eq.getValue();
			
			try(
					BufferedWriter bw = new BufferedWriter(new FileWriter(camino+ "\\" + eq.getKey() + ".csv"));) {
				for (String item : integrantes) bw.write(item + "\n");
				
			}catch(FileNotFoundException ex) {
				System.out.println("Fichero no encontrado");
			}catch(IOException ex) {
				System.out.println(ex.getMessage());
			}
		}
	}
}