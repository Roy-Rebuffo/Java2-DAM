package Bloque1;

import java.io.File;

public class ej11 {
	
	public static void crearSubdirectorio(String directorio) {
		//Ejemplo C:\\Ficheros;
		
		File fich = new File(directorio);
		if(!fich.exists()) {
			fich.mkdir();
		}else {
			if (!fich.isDirectory()) fich.mkdir();
		}	
	}

	public static void main(String[] args) {
		
	}
	
	
}
