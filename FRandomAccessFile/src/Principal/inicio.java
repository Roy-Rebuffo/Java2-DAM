package Principal;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import Clases.Biblioteca;
import Clases.CListaRegistros;
import Clases.CListaTfnos;
import Clases.CPersona;
import Clases.CRegistro;

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
	  /********************************************************************************/
	  /*****************************Métodos CRegistro**********************************/
	  /********************************************************************************/
	  /********************************************************************************/
	  public static int buscarRegistro(CListaRegistros lis, int posicion, String ref)throws IOException {
		  int n = lis.buscar(ref, posicion);
			if(n<0) {
				System.out.println("Nombre no encontrado");
			}else {
				System.out.println(lis.valorEn(n));
			}
			return n;
	  }
	  /********************************************************************************/
	  public static void añadirRegistro(CListaRegistros lis) throws IOException {
			//parametro que llega desde el main. primero lo declaramos en el main,
			//luego lo llamamos en el case 3(listin) y luego llega a este metodo como (lis)
				String referencia;
				double precio;
				System.out.print("Referencia: "); referencia = sc.nextLine();
				System.out.print("Precio: "); precio = Double.valueOf(sc.nextLine());
				
				lis.añadir(new CRegistro(referencia,precio));
			}
	  /********************************************************************************/
	  public static void listarRegistro(CListaRegistros lis) throws IOException {
			for (int i = 0; i < lis.longitud(); i++) {//recorremos el numero de registros para listar las personas
				System.out.println(lis.valorEn(i));
			}
		}
	  /********************************************************************************/
	  public static void modificarRegistro (CListaRegistros lis) throws IOException{
			System.out.print("Dime la referencia: ");
			String ref = sc.nextLine();
			
			int n = lis.buscar(ref, 0);
			if(n<0) {
				System.err.println("Referencia no encontrada");
				return ;
			}
			
			CRegistro r = lis.valorEn(n);
			
			String referencia, precio;
			System.out.print("Referencia: "); referencia = sc.nextLine();
			System.out.print("Precio: "); precio = sc.nextLine();
			
			if(!referencia.equals(""))r.setReferencia(referencia);;
			if(!precio.equals(""))r.setPrecio(Double.valueOf(precio));
			lis.ponerValorEn(n, r);
		} 
	  /********************************************************************************/
	  public static void actualizarRegistro(File factual,CListaRegistros lis) throws IOException {
	    	File fnuevo=new File("temp.tmp");//crea un fichero nuevo
	    	CListaRegistros nuevo=new CListaRegistros(fnuevo);//crea un fichero nuevo
	    	CRegistro r;
	    	for(int i=0;i<lis.longitud();i++) {//recorremos a las personas
	    		r=lis.valorEn(i);
	    		//if(!r.getReferencia().isEmpty()) nuevo.añadir(r);// si no hay referencia vacia guardamos en el nuevo fichero
	    		//if(r.getReferencia() == null) nuevo.añadir(r);
	    		if(r.getPrecio() != -100) nuevo.añadir(r);
	    		
	    	}
	    	lis.cerrar();
	    	nuevo.cerrar();
	    	factual.delete();
	    	if (!fnuevo.renameTo(factual)) throw new IOException("no se renombro el fichero");
	    }
	  /********************************************************************************/
	public static void main(String[] args) throws IOException {
		File fichero = null;

	    while (true) {
	        System.out.println("Introduce el nombre del fichero (sin extensión): ");
	        String nombreFichero = sc.nextLine();

	        fichero = new File(nombreFichero + ".dat");

	        if (fichero.exists()) {
	            System.out.println("✅ Fichero encontrado: " + fichero.getAbsolutePath());
	            break;
	        } else {
	            System.err.println("❌ El fichero no existe. Intenta de nuevo.\n");
	        }
	    }
	    menuListaTfnos(fichero);
	    menuListaRegistros(fichero);
	}
	
	public static void menuListaRegistros(File f) throws IOException {
		
		//File fichero = new File ("listaRegistros.dat");
		CListaRegistros listin = new CListaRegistros(f);
		String basura;
		String referencia = null;
		boolean eliminado = false;
		int pos = 0;
		int op;
		boolean seguir = true;
		String [] opciones = {
				"1.-Buscar",
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
				System.out.print("Dime la referencia: "); referencia = sc.nextLine();
				buscarRegistro(listin, pos, referencia);
				break;
			case 2://buscar siguiente
				if(referencia == null) {
					System.out.print("Dime la referencia: "); referencia = sc.nextLine();
					pos = -1;
				}else {
					pos = buscarRegistro(listin,pos+1,referencia);
				}
				break;
			case 3://modificar
				modificarRegistro(listin);
				break;
			case 4://añadir registros
				añadirRegistro(listin);
				break;
			case 5://eliminar
				System.out.print("Dime la referencia a borrar: "); referencia = sc.nextLine();
				if(listin.eliminar(referencia)) eliminado = true;
				break;
			case 6://listar
				listarRegistro(listin);
				break;
			case 7 : //actualizar
				if(eliminado) actualizarRegistro(f,listin);
			}
			if(op!=7) {
				System.out.print("Presione una tecla para continuar");
				basura = sc.nextLine();
			}
			
		} while (op!=7);
		}
	
	public static void menuListaTfnos (File f) throws IOException {
		//File fichero = new File("listintfn.dat");
		CListaTfnos listin =  new CListaTfnos(f); 
		String basura;
		String nombre = null;
		int pos = 0;
		long tel;
		boolean eliminado = false;
		int op;
		boolean seguir = true;
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
				if(eliminado) actualizar(f,listin);
			}
			if(op!=7) {
				System.out.print("Presione una tecla para continuar");
				basura = sc.nextLine();
			}
			
		} while (op!=7);
	}

}
