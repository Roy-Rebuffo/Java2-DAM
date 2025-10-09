//poner la nota del primer trimestre y la nota final de la asignatura
//queremos saber que nota tenemos que sacar en el segundo trimestre para obtener la nota final
//teniendo en cuenta que la nota del 1er trimestre cuenta un 40 % y el 2ºtrimestre un 60%
//e.j ponemos que en primer trimestre tenemos un 5 y queremos sacar un 8, 
//pues tendremos que sacar cuanto tenemos que sacar para sacar ese 8 final

//p,s,final
//final = 0.4*p + 0.6 * s 
package primero;

import java.util.Scanner;

public class Notas {

	public static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		System.out.print("Dime que has sacado en el primer trimestre: ");
		int primeraNota = sc.nextInt();
		
		System.out.print("Dime cual es tu objetivo final: ");
		int notaFinal = sc.nextInt();
		
		System.out.print("Esto es lo que tienes que sacar para obtener tu nota final: ");
		double segundaNota = ( notaFinal - (0.4 * primeraNota) ) / 0.6;

		System.out.println(segundaNota);
	}

}
