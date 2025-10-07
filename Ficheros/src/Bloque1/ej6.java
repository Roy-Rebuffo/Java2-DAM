package Bloque1;
//leer una sola vez el fichero y nos cree para cada una de las comunidades autonamos distintas que hay en el fichero
//cuyo nombre sera la comunidades.csv
//y que contenga las comunidades autonomas

//HashMap (Clave(String equipo), valor (ArrayList <String> integrantes[]))
//contains key

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

public class ej6 {

	public static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) throws IOException{
		String linea = "";
		String matriz [];
		HashMap<String,ArrayList<String>> provincias = new HashMap<String,ArrayList<String>>();
		
		try(
				BufferedReader br = new BufferedReader(new FileReader("provincias.csv"));
				) {
			
			linea = br.readLine(); //leemos la linea del fichero
			while(linea!=null) {
				matriz = linea.split(","); // metemos en una variable nueva el valor 7 de la linea
				
				if(!provincias.containsKey(matriz[0])) {
					provincias.put(matriz[0], new ArrayList<String>()); //Si no esta el equipo lo creamos en el hashmap
				}
				//accede al arraylist tanto si existe como si no existe
				ArrayList<String> nuevo = provincias.get(matriz[0]);
				nuevo.add(linea);
				provincias.put(matriz[0], nuevo);
				linea = br.readLine();
			}
		} catch(FileNotFoundException ex) {
			System.out.println("Fichero no encontrado");
		}catch(IOException ex) {
			System.out.println(ex.getMessage());
		}
		
		ArrayList<String> comunidades;
		
		for(Entry<String, ArrayList<String>> pr : provincias.entrySet()){//Acceder a la clave y al valor mediante la colección Entry
			System.out.println(pr.getKey() + pr.getValue());
			comunidades = pr.getValue();
			
			try(
					BufferedWriter bw = new BufferedWriter(new FileWriter("./provincias/" + pr.getKey() + ".csv"));) {
				for (String item : comunidades) bw.write(item + "\n");
				
			}catch(FileNotFoundException ex) {
				System.out.println("Fichero no encontrado");
			}catch(IOException ex) {
				System.out.println(ex.getMessage());
			}
		}
	}
}