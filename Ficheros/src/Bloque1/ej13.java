package Bloque1;

import java.io.File;

public class ej13 {
	
	public static void main(String[] args) {
		String ruta = "C:\\Users\\Alumno\\Desktop\\CLASE\\Programación\\Proyecto01\\Ficheros", permisos;
		
		File fich = new File(ruta);
		
		if(fich.isDirectory()) {
			for (File f : fich.listFiles()) {
				permisos = f.isDirectory() ? "d" : "-";
				permisos += f.canRead() ? "r" : "-";
				permisos += f.canWrite() ? "w" : "-";
				permisos += f.canExecute() ? "x" : "-";
				
				System.out.println(permisos + " " + f.getName());
			}
		}
		
	}
}
//decir que permisos tienen los ficheros