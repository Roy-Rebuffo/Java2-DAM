package Bloque1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
//import Proyecto01.Clases.Biblioteca; //no llega a biblioteca

public class ej3 {
	
	public static int alea(int li, int ls) {//función (método)
        return (int) ((Math.round(Math.random() * (ls - li)) + li));
    }
	
	public static void crear() {
		String cadena="";
        try (
        		BufferedWriter bw1 = new BufferedWriter(new FileWriter("alumnos.dat"));) {
        	for (int i = 0; i <= 50; i++) {
				cadena = String.format("Alumno %d:%d:%d:%d", i, 
						alea(0,10),
						alea(0,10),
						alea(0,10));
				bw1.write(cadena + "\n");
			}
			
			/***************************************************************************************/
			
			/***************************************************************************************/
			
		}catch(FileNotFoundException ex) {
			System.out.println("Fichero no encontrado");
		}catch(IOException ex) {
			System.out.println(ex.getMessage());
		}
	}

	public static void aprobadosSuspensos () {
		String linea = "";
		String matriz [];
		
		try (BufferedReader br1 = new BufferedReader(new FileReader("alumnos.dat"));
				BufferedWriter bw1 = new BufferedWriter(new FileWriter("aprobados.dat"));
				BufferedWriter bw2 = new BufferedWriter(new FileWriter("suspensos.dat"));) {
			
			linea = br1.readLine();
			while(linea !=null) {
				matriz = linea.split(":");
				if(Integer.valueOf(matriz[1]) >=5 &&
						Integer.valueOf(matriz[2]) >=5 &&
						Integer.valueOf(matriz[3]) >=5) {
				bw1.write(linea + "\n");	
				}else {
					bw2.write(linea + "\n");
				}
				linea = br1.readLine();
			}
		} catch(FileNotFoundException ex) {
			System.out.println("Fichero no encontrado");
		}catch(IOException ex) {
			System.out.println(ex.getMessage());
		}
	}
	
    public static void main(String[] args) throws IOException {
        // Generar notas aleatorias para 50 alumnos (tres asignaturas)
        // y guardarlas en un fichero llamado "notas.dat"
    	crear();
    	aprobadosSuspensos();
    	
	}
}