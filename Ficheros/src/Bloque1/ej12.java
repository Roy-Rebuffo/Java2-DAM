package Bloque1;

import java.io.File;

public class ej12 {
	
	public static void main(String[] args) {
		String nombre = ".csv";
		String ruta = ".";
		if(args.length >= 1) ruta=args[0];
		
		File fich = new File(ruta); //hace referencia a un fichero/directorio
		
		if(!fich.exists()) {
			System.out.println("No existe el fichero o directorio ("+ ruta +").");
		}
		else {
			if(fich.isFile()) {
				System.out.println(ruta + " es un fichero.");
			}
			else {//si llega hasta aqui es que es un directorio
				System.out.println(ruta + "es un directorio. Contenidos: ");
				File [] ficheros = fich.listFiles();
				for (File f : ficheros) {
					if(f.isFile() && (f.getName()).endsWith(".csv")) f.delete();
				}
			}
		}
	}
}