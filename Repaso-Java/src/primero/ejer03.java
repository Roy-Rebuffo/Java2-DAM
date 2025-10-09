package primero;
import java.util.Scanner;

public class ejer03 {

	public static Scanner sc = new Scanner(System.in);
	/*
	public static void main(String[] args) {
		//pedir un año por pantalla y quiero saber si es bisiesto o no bisiesto
		//divisibles entre 4(% == 0) que no son divisibles entre 100, o son divisibles entre 400
		
		System.out.println("Escriba un numero por pantalla");
		int anio = Integer.valueOf(sc.nextLine());
		
		if( (anio % 4 == 0 && anio % 100!=0) || anio % 400 == 0) {
			System.out.println("Es bisiesto :)");
		}else {
			System.out.println("NO es bisiesto");
		}
	}*/
	
	 public static void main(String[] args) {
		//pedir un año por pantalla y quiero saber si es bisiesto o no bisiesto
		//divisibles entre 4(% == 0) que no son divisibles entre 100, o son divisibles entre 400
		
		System.out.println("Escriba un numero por pantalla");
		int anio = Integer.valueOf(sc.nextLine());
		
		System.out.println(bisiesto(anio) ? "Es bisiesto" : "No es bisiesto");
		
	}
	
	public static boolean bisiesto(int a) {
		return a % 4 == 0 && a % 100!=0 || a % 400 == 0;
	}
}