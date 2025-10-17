package Clases;

import java.util.Scanner;

public class Biblioteca {

	public static int menu(Scanner sc, String[] opciones) {
		int op = 0;
		do {
			for (String items : opciones)
				System.out.println(items);
			System.out.print("Dime la opcion a realizar: ");
			try {
				op = Integer.valueOf(sc.nextLine());
			} catch (NumberFormatException e) {
				continue;
			}
			
		} while (op < 1 || op > opciones.length);
		return op;
	}
	
	public static double redondear(double numero, int decimales) {
		//10.24567,2
		int exponente = (int)Math.pow(10, decimales);
		return (double)Math.round(numero*exponente)/exponente; //10.25567,2
	}
	
	public static double truncar(double numero, int decimales) {
		//10.24567,2
		int exponente = (int)Math.pow(10, decimales);
		return (double)Math.floor(numero*exponente)/exponente; //1024.567
	}
	
	public static int alea(int li, int ls) {//función (método)
        return (int) ((Math.round(Math.random() * (ls - li)) + li));
    }
}
