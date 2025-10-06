package Bloque1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class ej2 {

	public static void main(String[] args) {
		String linea1="", linea2="";
		try (BufferedReader br1 = new BufferedReader(new FileReader("fich1_e_2.dat"));
				BufferedReader br2 = new BufferedReader(new FileReader("fich2_e_2.dat"));
				BufferedWriter bw1 = new BufferedWriter(new FileWriter("alternas.dat"));) {
			linea1 = br1.readLine();linea2 = br2.readLine();
			//si se sale de un uno de los ficheros se acaba el proceso, por eso luego hacemos lo mismo pero separado
			while(linea1!=null && linea2!=null) {//lee de forma alterna
				bw1.write(linea1 + "\n");
				bw1.write(linea2 + "\n");
				
				linea1=br1.readLine();
				linea2=br2.readLine();
			}
			/***************************************************************************************/
			while(linea1!=null) {
				bw1.write(linea1 + "\n");
				linea1=br1.readLine();
			}
			while(linea2!=null) {
				bw1.write(linea2 + "\n");
				linea2=br2.readLine();
			}
			/***************************************************************************************/
			
		}catch(FileNotFoundException ex) {
			System.out.println("Fichero no encontrado");
		}catch(IOException ex) {
			System.out.println(ex.getMessage());
		}
	}
}