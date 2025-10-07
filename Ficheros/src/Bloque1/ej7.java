package Bloque1;
//escribe en un programa que guarde en un fichero con nombre primos.dat los nº primos que hay entre 1 y 500
//coger del 2 a n-1 y si cualquiera es divisible es primo

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;


public class ej7 {

	public static void main(String[] args) {
		String cadena = "";
		
		try(
				BufferedWriter bw = new BufferedWriter(new FileWriter("primos/primos.dat"));) {
			
			for (int i = 2; i <= 500; i++) {
				if(esPrimo(i)) {
					bw.write(i + "\n");
				}
			}
			
		}catch(FileNotFoundException ex) {
			System.out.println("Fichero no encontrado");
		}catch(IOException ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	public static boolean esPrimo(int n) {
		//Un nº es primo si solo es divisible entre 1 y si mismo
		for (int i = 2; i <= n-1; i++) {
			if(n%i == 0) return false;
		}
		return true;
	}
}
