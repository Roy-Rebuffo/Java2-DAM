package primero;

import java.util.Scanner;

/**
 * 
 */
public class ejer01 {
	
public static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		System.out.print("Escribe un dia de un mes(1-12):");
		
		int num = Integer.valueOf(sc.nextLine());
		String trimestre = "";
		String semestre = "";
		//Del mes introducido decir el trimestre y el semestre
			if(num<=3){
				trimestre = "Trimestre 1";
				semestre = "Semestre 1";
			}else if(num>3 && num<=6){
				trimestre = "Trimestre 2";
				semestre = "Semestre 1";
			}else if(num>6 && num<=9) {
				trimestre = "Trimestre 3";
				semestre = "Semestre 2";
			}else if(num>9 && num<=12) {
				trimestre = "Trimestre 4";
				semestre = "Semestre 2";
			}
		System.out.printf("El mes %2d pertenece %s %s",num,trimestre, semestre);
		System.out.println();
		
		//Dado un numero int del 1 al 100 decir en que decena esta
		System.out.println("Escriba un numero del 1 al 100");
		int num2 = Integer.valueOf(sc.nextLine());
		
		int res = (int)((num2-1)/10)+1;
		System.out.printf("El numero elegido pertenece a la decena %d",res);
		
	}	
}
