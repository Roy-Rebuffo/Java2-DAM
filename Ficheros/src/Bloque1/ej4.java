package Bloque1;
//pasarle un nombre del equipo y nos cree un fichero de nombre (nombre_de_equipo.csv)[7]
//que contenga los integrantes de ese equipo

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ej4 {

	public static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) throws IOException{
		String linea = "";
		String matriz;
		System.out.print("Introduzca el equipo: ");
		String eq = sc.nextLine();
		try(
				BufferedReader br = new BufferedReader(new FileReader("jugadores.csv"));
				BufferedWriter bw = new BufferedWriter(new FileWriter(eq + ".csv"));) {
			
			linea = br.readLine(); //leemos la linea del fichero jugadores
			while(linea!=null) {
				matriz = linea.split(",")[7]; // metemos en una variable nueva el valor 7 de la linea
				if(eq.compareToIgnoreCase(matriz) == 0) {//si es igual lo que escribimos al 7º valor metemos la linea en el fichero nuevo
					bw.write(linea + "\n");
				}
				linea = br.readLine();
			}
		} catch (Exception e) {
			
		}
	}
}