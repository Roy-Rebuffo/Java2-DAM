package Bloque1;
//pasar un directorio y quiero que borre todos los csv que haya en ese directorio
import java.io.File;

public class ej10 {

	public static void main(String[] args) {
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
					String textoDescr = f.isDirectory() ? "/":
						f.isFile() ? "_": "?";
					System.out.println("("+textoDescr+") " + f.getName());
				}
			}
		}
	}
}
