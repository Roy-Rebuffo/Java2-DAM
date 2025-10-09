package Clases;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class CListaTfnos {
	private RandomAccessFile fes; //fes = flujo//fichero
	private int nregs; //nº de registros
	private int tamañoReg = 140;
	
	public CListaTfnos(File fichero) throws IOException {
		if(fichero.exists() && !fichero.isFile()) {
			throw new IOException(fichero.getName() + "no es un fichero");
		}
		fes = new RandomAccessFile(fichero,"rw");
		
		//es importante que la division de double para que devuelva el ultimo registro
		nregs =(int) Math.ceil((double)fichero.length() /(double)this.tamañoReg); 
	}
	/********************************************************************************************/
	public void cerrar()throws IOException {
		fes.close();
	}
	/********************************************************************************************/
	public int longitud() {
		return nregs;
	}
	/********************************************************************************************/
	public void añadir(CPersona p) throws IOException {
		if(ponerValorEn(nregs,p)) nregs ++;
	}
	/********************************************************************************************/
	public int buscar(String str, int pos) throws IOException {
		CPersona p ;
		String nombre;
		if(str == null) return -1;
		if(pos < 0) pos = 0;
		for (int i = pos; i < nregs; i++) {//busqueda secuencial
			p = valorEn(i); //leer la persona en la posicion (i)
			if (str.equalsIgnoreCase(p.getNombre())) return i; //si es verdad existe la persona y la devuelve
		}
		return -1;
	}
	/********************************************************************************************/
	public boolean eliminar(long tel) throws IOException{
		CPersona p;
		for (int i = 0; i < nregs; i++) {//busqueda secuencial
			p = valorEn(i);//leer la persona en la posicion (i)
			if(tel == p.getTelefono()) {
				p.setTelefono(0);//si existe el telefono, poner su valor en 0
				ponerValorEn(i,p);//volver a grabar
				return true;
			}
		}
		return false;
	}
	/********************************************************************************************/
	public boolean ponerValorEn(int i, CPersona p) throws IOException {//metodo que pone en la posicion del registro(i) una Persona (p)
		
		if(i>=0 && i<=nregs) {
			if(p.tamaño()+4>tamañoReg) {
				System.out.println("tamaño del registro excedido");
			}else {
				fes.seek(i*tamañoReg);
				fes.writeUTF(p.getNombre());
				fes.writeUTF(p.getDireccion());
				fes.writeLong(p.getTelefono());
				return true;
			}
		}else {
			System.err.println("nº de registro fuera de limites");
		}
		return false;
	}
	 /********************************************************************/
	public CPersona valorEn(int i) throws IOException {//obtener la persona
		if (i>=0 && i<=nregs) {
			fes.seek(i*tamañoReg);
			/*
			String nombre = fes.readUTF();
			String direccion = fes.readUTF();
			long telefono = fes.readLong();*/
			return new CPersona(fes.readUTF(),fes.readUTF(),fes.readLong());
		}else {
			System.err.println("nº de registro fuera de limites");
		}
		return null;
	}
}
