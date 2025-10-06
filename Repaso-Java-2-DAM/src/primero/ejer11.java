package primero;

import java.util.Scanner;

import Clases.Biblioteca;

public class ejer11 {

	public static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		int opcion;
		String basura;
		boolean seguir = true;
		String[] opciones = {"1. -suma", "2.-resta", "3.-salir"};
		
		while(seguir) {
			opcion = Biblioteca.menu(sc, opciones);
			
			switch(opcion) {
			case 1: //suma
				System.out.println("quiero sumar");
				break;
			case 2: //resta
				System.out.println("quiero restar");
				break;
			case 3: //salir
				System.out.println("SALIENDO DE MENU...👌");
				seguir = false;
				break;
			}
			if(opcion !=3) {
				System.out.println("Pulse una tecla para continuar");
				basura = sc.nextLine();
			}
		}
	}
}
