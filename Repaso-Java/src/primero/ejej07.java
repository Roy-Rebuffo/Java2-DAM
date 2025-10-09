package primero;

import java.util.ArrayList;
import java.util.Scanner;

import Clases.persona;

public class ejej07 {

	public static ArrayList<persona> personas = new ArrayList<persona>();
	public static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
	
		personas.add(new persona("Mar", "Clara", 99));
		personas.add(new persona("Fabian", "Luna", 18));
		personas.add(new persona("Rafinha", "Balon d´or", 69));
		personas.add(new persona("Leo", "Te echamos de menos", 88));
		
		for (persona p : personas) {
			System.out.println(p);
		}
		int n = buscar(personas,"Mar","Clara");
		if(n==-1) {
			System.out.println("No encontrado");
		}else {
			System.out.println(n);
		}
		
		find_age(personas, "Mar","Clara");
	}
	
	//crear metodo pasando el arraylist, el nombre y el apellido y nos tiene que devolver la edad de esa persona
/*SOBRECARGADO. POR LOS PARAMETROS
	public static void find_age(ArrayList <persona> personas) {
		System.out.print("Escriba el nombre: ");
		String nombre = sc.nextLine();
		System.out.print("Escriba el apellido: ");
		String apellido = sc.nextLine();
		
		for (persona p : personas) {
			if(nombre.equalsIgnoreCase(p.getNombre()) && apellido.equalsIgnoreCase(p.getApellido())) {
				System.out.println(p.getNombre());
				System.out.println(p.getApellido());
				System.out.println(p.getEdad());
				break;
			}else {
				System.out.println("NO EXISTE ESTA PIPOL :)");
				break;
			}
		}
	}
	*/
	/*MENOS SOBRECARGADO, LLAMAMOS A LOS PARAMETROS EN EL MAIN*/
	public static void find_age(ArrayList <persona> personas,String nombre,String apellido) {
		System.out.println("Forma mia: ");
		System.out.println("-----------");
		for (persona p : personas) {
			if(nombre.equalsIgnoreCase(p.getNombre()) && apellido.equalsIgnoreCase(p.getApellido())) {
				System.out.println(p.getNombre());
				System.out.println(p.getApellido());
				System.out.println(p.getEdad());
				break;
			}else {
				System.out.println("NO EXISTE ESTA PIPOL :)");
				break;
			}
		}
	}
	
	//OTRA FORMA DE HACERLO
	public static int buscar(ArrayList<persona> f, String nom, String ape) {
		System.out.println("Forma del profe");
		System.out.println("-----------");
		for (persona p : f) {
			if( p.getNombre().compareToIgnoreCase(nom) == 0 &&
					p.getApellido().compareToIgnoreCase(ape) == 0)
				System.out.print("Edad: ");
				return p.getEdad();
		}
		return -1;
	}
}
