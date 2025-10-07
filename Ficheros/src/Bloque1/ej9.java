package Bloque1;
//pasar un argumento a un fichero y la palabra que queremos
//saber cuantas veces se repite

//indexOf
//substring

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ej9 {
	
	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) throws IOException{
		String linea = "";
		System.out.print("Escriba la palabra a buscar: ");
		String palabra = sc.nextLine();
		int c = 0;
		
		try(
				BufferedReader br = new BufferedReader(new FileReader("lolol.dat"));
				BufferedWriter bw = new BufferedWriter(new FileWriter("palabrasRepetidas.dat"));) {
			
			linea = br.readLine();
			
			while(linea!=null) {
				int pos = linea.indexOf("Jose");
				System.out.println(pos);
				while(pos >= 0) {
					c++;
					linea = linea.substring(pos + palabra.length());
					pos = linea.indexOf(palabra);
					System.out.println(pos);
					bw.write(c);
				}
				System.out.println("Cont p: " + c);
				linea = br.readLine();
			}
			
		} catch(FileNotFoundException ex) {
			System.out.println("Fichero no encontrado");
		}catch(IOException ex) {
			System.out.println(ex.getMessage());	
		}
	}
}
