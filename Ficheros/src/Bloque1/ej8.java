package Bloque1;
//pediremos el numero de niveles de una pirámide
//grabar en un fichero la pirámide
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ej8 {
	
	public static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		String cadena = "";
		System.out.println("Escriba el nº de niveles de la pirámide");
		int res = sc.nextInt();
		pintarPiramide(res);
		piramideInversa(res);
		piramideDerecha(res);
		piramideIzquierda(res);
		try(
				BufferedWriter bw = new BufferedWriter(new FileWriter("niveles.dat"));) {
			
		}catch(FileNotFoundException ex) {
			System.out.println("Fichero no encontrado");
		}catch(IOException ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	public static void pintarPiramide(int n) {
		
		try(
				BufferedWriter bw = new BufferedWriter(new FileWriter("./piramides/piramide.dat"));) {
			for (int i = 1; i <= n; i++) {
				bw.write(" ".repeat(n - i) + "*".repeat((2*(i-1))+1) + "\n");
			}
			
		}catch(FileNotFoundException ex) {
			System.out.println("Fichero no encontrado");
		}catch(IOException ex) {
			System.out.println(ex.getMessage());
		}
		
	}
	public static void piramideInversa(int n) {

		try(
				BufferedWriter bw = new BufferedWriter(new FileWriter("./piramides/piramideInversa.dat"));) {
			for (int i = n ; i >= 1; i--) {
				bw.write(" ".repeat(n - i) + "*".repeat((2*(i-1))+1) + "\n");
			}
			
			for (int i = 1; i <= n; i++) {
				bw.write(" ".repeat(i - 1) + "*".repeat( (2*(i - 1)) + 1) + "\n");
			}
			
		}catch(FileNotFoundException ex) {
			System.out.println("Fichero no encontrado");
		}catch(IOException ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	public static void piramideDerecha(int n) {
		try(
				BufferedWriter bw = new BufferedWriter(new FileWriter("./piramides/piramideDerecha.dat"));) {
			for (int i = 1; i <= n; i++) {
				bw.write("*".repeat(i) + "\n");
			}
			for (int i = n - 1; i >= 1; i--) {
				bw.write("*".repeat(i) + "\n");
			}
			
		}catch(FileNotFoundException ex) {
			System.out.println("Fichero no encontrado");
		}catch(IOException ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	public static void piramideIzquierda(int n) {
		try(
				BufferedWriter bw = new BufferedWriter(new FileWriter("./piramides/piramideIzquierda.dat"));) {
			for (int i = 1; i <= n; i++) {
				bw.write(" ".repeat(n - i) + "*".repeat(i) + "\n");
			}
			for (int i = n - 1; i >= 1; i--) {
				bw.write(" ".repeat(n - i) +  "*".repeat(i) + "\n");
			}
			
		}catch(FileNotFoundException ex) {
			System.out.println("Fichero no encontrado");
		}catch(IOException ex) {
			System.out.println(ex.getMessage());
		}
	}
}