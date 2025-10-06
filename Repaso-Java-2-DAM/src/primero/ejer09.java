//hacer metodo estatico menu
//siempre que necesitemos un metodo estatico  accedemos al menu

package primero;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Map.Entry;

import Clases.persona;

public class ejer09 {

	public static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		//hacer metodo pasar hashmap, 
		//pasar dni, 
		//sino existe pedir los datos de la persona a inculuir y 
		//si existe nos de la opcion de modificar los datos que ya tenemos
		
		HashMap<String, persona> p = new HashMap<String, persona>();
		
		p.put("55024018Z", new persona("Pepe","Perez",99));
		p.put("12345678Y", new persona("Nepe","Marcos",88));
		p.put("87654321N", new persona("Pija","Neruda",77));		
		
		System.out.print("ESCRIBA UN DNI ->"); String dni = sc.nextLine();
		
		if(!p.containsKey(dni)) {
			System.out.println("Los datos introducidos no existen.");
			System.out.print("Escriba el nombre de la persona: "); String n = sc.nextLine();
			System.out.print("Escriba el apellido de la persona: "); String a = sc.nextLine();
			System.out.print("Escriba la edad de la persona: "); int e = Integer.valueOf(sc.nextLine());
			//crear el objeto 
			p.put(dni, new persona(n,a,e));
			for(Entry<String, persona> c : p.entrySet())//Acceder a la clave y al valor mediante la colección Entry
				System.out.println(c.getKey() + c.getValue());
		}else {
			System.out.println("Quiere modificar los datos de esta persona? (s/n)");
			String mod = sc.nextLine();
			if(mod.equalsIgnoreCase("s")) {
				System.out.print("Nuevo nombre: "); String nNombre = sc.nextLine();
				System.out.print("Nuevo apellido: "); String nApellido = sc.nextLine();
				System.out.print("Nueva edad: "); int nEdad = Integer.valueOf(sc.nextLine());
				for(Entry<String, persona> c : p.entrySet())//Acceder a la clave y al valor mediante la colección Entry
					System.out.println(c.getKey() + c.getValue());
			}else {
				System.out.println("Saliendo del programa...");
			}
		}
	}
}