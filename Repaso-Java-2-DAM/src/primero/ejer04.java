package primero;

import java.util.Iterator;
import java.util.Scanner;

public class ejer04 {

	public static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		//Pedir el año y numero de mes, indicar el nº del mes y el nº de dias que tiene ese año
		String [] meses= {"Enero","Febrero","Marzo","Abril","Mayo","Junio","Julio","Agosto","Septiembre",
	            "Octubre","Noviembre","Diciembre"};
		
		/* RECORREMOS EL ARRAY
		for (int i = 0; i < meses.length; i++) {
			System.out.printf("%d %s\n",i, meses[i]);
		}*/
		
		System.out.println("Escriba un año por pantalla");
		int anio = Integer.valueOf(sc.nextLine());
		System.out.println("Escriba un Nº mes por pantalla");
		int mes = Integer.valueOf(sc.nextLine());
		
		int ndias;
		
		switch(mes) {
		case 1: case 3: case 5: case 7: case 8: case 10: case 12:
			ndias = 31;
			break;
		case 2: //febrero
			ndias = bisiesto(anio) ? 29 : 28;
			break;
		default:
			ndias = 30;
			break;
		}
		System.out.printf("El mes %s tiene %d días",meses[mes - 1], ndias);
	}
	
	
	public static boolean bisiesto(int a) {
		return a % 4 == 0 && a % 100!=0 || a % 400 == 0;
	}
}

/*
 *public class EjemploSwitch {
    public static void main(String[] args) {
        int dia = 3; // Representa un día de la semana (1 = Lunes, 2 = Martes, etc.)

        switch (dia) {
            case 1:
                System.out.println("Hoy es Lunes");
                break;
            case 2:
                System.out.println("Hoy es Martes");
                break;
            case 3:
                System.out.println("Hoy es Miércoles");
                break;
            case 4:
                System.out.println("Hoy es Jueves");
                break;
            case 5:
                System.out.println("Hoy es Viernes");
                break;
            case 6:
                System.out.println("Hoy es Sábado");
                break;
            case 7:
                System.out.println("Hoy es Domingo");
                break;
            default:
                System.out.println("El número no corresponde a un día válido");
        }
    }
}
 
 */
