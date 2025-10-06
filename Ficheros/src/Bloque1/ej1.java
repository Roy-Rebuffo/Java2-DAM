package Bloque1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class ej1 {

	//Primero leemos
	//Imprimimos
	//Metemos en el arraylist
	//Se crea el fichero automaticamente
	//Se lee el fichero escrito con el for
	public static void main(String[] args) throws IOException {
		ArrayList <Integer> lista = new ArrayList<Integer>();
		//metemos el reader y el writer dentro del parentesis para asi evitar cerrarlos con el .close
		try(
				BufferedReader br = new BufferedReader(new FileReader("numeros.dat"));
				BufferedWriter bw = new BufferedWriter(new FileWriter("numero_sort.dat"));
				
				){
			String linea = "";
			linea = br.readLine();
			while(linea!=null) {
				System.out.println(linea);
				lista.add(Integer.valueOf(linea));
				linea = br.readLine();
			}
			Collections.sort(lista);
			for (Integer l : lista) {
				bw.write(l+ "\n");
				System.out.println(l);
			}
			
		} catch (FileNotFoundException ex) {
			System.out.println("Fichero no encontrado");
		}
	}
}

