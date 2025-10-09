package Principal;
//clase que se llame cregistro que contenga de atributos de tipo string referencia y de tipo double precio.
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import Clases.Biblioteca;
import Clases.CListaTfnos;
import Clases.CPersona;

public class inicio {
	
	public static Scanner sc = new Scanner(System.in);
	/********************************************************************************/
	public static void añadirListin(CListaTfnos lis) throws IOException {
	//parametro que llega desde el main. primero lo declaramos en el main,
	//luego lo llamamos en el case 3(listin) y luego llega a este metodo como (lis)
		String nombre, direccion;
		long telefono;
		System.out.print("Nombre: "); nombre = sc.nextLine();
		System.out.print("Direccion: "); direccion = sc.nextLine();
		System.out.print("Telefono: "); telefono =Long.valueOf(sc.nextLine());
		
		lis.añadir(new CPersona(nombre, direccion, telefono));
	}
	/********************************************************************************/
	public static void listar(CListaTfnos lis) throws IOException {
		for (int i = 0; i < lis.longitud(); i++) {//recorremos el numero de registros para listar las personas
			System.out.println(lis.valorEn(i));
		}
	}
	/********************************************************************************/
	public static int buscarNombre(CListaTfnos lis, int posicion, String nom) throws IOException {
		int n = lis.buscar(nom, posicion);
		if(n<0) {
			System.out.println("Nombre no encontrado");
		}else {
			System.out.println(lis.valorEn(n));
		}
		return n;
	}
	/********************************************************************************/
	public static void modificar (CListaTfnos lis) throws IOException{
		System.out.print("Dime el nombre: ");
		String nom = sc.nextLine();
		
		int n = lis.buscar(nom, 0);
		if(n<0) {
			System.out.println("Nombre no encontrado");
			return ;
		}
		
		CPersona p = lis.valorEn(n);
		
		String nombre , direccion, telefono;
		System.out.print("Nombre: "); nombre = sc.nextLine();
		System.out.print("Direccion: "); direccion = sc.nextLine();
		System.out.print("Telefono: "); telefono = sc.nextLine();
		
		if(!nombre.equals(""))p.setNombre(nombre);
		if(!direccion.equals(""))p.setDireccion(direccion);
		if(!telefono.equals(""))p.setTelefono(Long.valueOf(telefono));
		
		lis.ponerValorEn(n, p);
	}
	/********************************************************************************/
	  public static void actualizar(File factual,CListaTfnos lis) throws IOException {
	    	File fnuevo=new File("temporal.tmp");//crea un fichero nuevo
	    	CListaTfnos nuevo=new CListaTfnos(fnuevo);//crea un fichero nuevo
	    	CPersona p;//las obtenemos y las guardamos en p
	    	for(int i=0;i<lis.longitud();i++) {//recorremos a las personas
	    		p=lis.valorEn(i);
	    		if (p.getTelefono()!=0)nuevo.añadir(p);// si hay telefono distinto de 0 guardamos en el nuevo fichero
	    	}
	    	lis.cerrar();
	    	nuevo.cerrar();
	    	factual.delete();
	    	if (!fnuevo.renameTo(factual)) throw new IOException("no se renombro el fichero");
	    }
	  /********************************************************************************/
	public static void main(String[] args) throws IOException {
		File fichero = new File("listintfn.dat");
		CListaTfnos listin =  new CListaTfnos(fichero); 
		String basura;
		String nombre = null;
		int pos = 0;
		long tel;
		boolean eliminado = false;
		int op;
		String [] opciones = {"1.-Buscar",
				"2.-Buscar Siguiente",
				"3.-Modificar",
				"4.-Añadir",
				"5.-Eliminar",
				"6.-Listar",
				"7.-Salir"};
		
		do {
			op = Biblioteca.menu(sc, opciones);//llamamos a la biblioteca
			
			switch (op) {
			case 1://buscar
				//buscar(listin);
				System.out.print("Dime el nombre: "); nombre = sc.nextLine();
				buscarNombre(listin, pos, nombre);
				break;
			case 2://buscar siguiente
				if(nombre == null) {
					System.out.print("Dime el nombre: "); nombre = sc.nextLine();
					pos = -1;
				}else {
					pos = buscarNombre(listin,pos+1,nombre);
				}
				break;
			case 3://modificar
				modificar(listin);
				break;
			case 4://añadir registros
				añadirListin(listin);
				break;
			case 5://eliminar
				System.out.print("Dime el telefono a borrar: "); tel = Long.valueOf(sc.nextLine());
				if(listin.eliminar(tel)) eliminado = true;
				break;
			case 6://listar
				listar(listin);
				break;
			case 7 : //actualizar
				if(eliminado) actualizar(fichero,listin);
			}
			if(op!=7) {
				System.out.print("Presione una tecla para continuar");
				basura = sc.nextLine();
			}
			
		} while (op!=7);
		
	}

}
