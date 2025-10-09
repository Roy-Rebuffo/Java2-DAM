package Clases;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class CListaRegistros {
	private RandomAccessFile fes; // fes = flujo//fichero
	private int nregs; // nº de registros
	private int tamañoReg = 140;

	public CListaRegistros(File fichero) throws IOException {
		if (fichero.exists() && !fichero.isFile()) {
			throw new IOException(fichero.getName() + " no es un fichero");
		}
		fes = new RandomAccessFile(fichero, "rw");// creamos fichero de lectura y escritura

		nregs = (int) Math.ceil((double) fichero.length() / (double) this.tamañoReg);
	}
	/********************************************************************************************/
	public void cerrar() throws IOException {
		fes.close();
	}
	/********************************************************************************************/
	public int longitud() {
		return nregs;
	}
	/********************************************************************************************/
	public void añadir(CRegistro r) throws IOException {
		if(ponerValorEn(nregs,r)) nregs ++;
	}
	/********************************************************************************************/
	public int buscar(String str, int pos) throws IOException{
		CRegistro r;
		String referencia;
		if(str == null) return -1;
		if(pos < 0) pos = 0;
		for (int i = pos; i < nregs; i++) {
			r = valorEn(i);
			if(str.equalsIgnoreCase(r.getReferencia())) return i;
		}
		return -1;
	}
	/********************************************************************************************/
	public boolean eliminar(String referencia) throws IOException{
		CRegistro r;
		for (int i = 0; i < nregs; i++) {//busqueda secuencial
			r = valorEn(i);//leer la persona en la posicion (i)
			if(referencia.equalsIgnoreCase(r.getReferencia())) {
				r.setReferencia(null);
				ponerValorEn(i,r);
				return true;
			}
		}
		return false;
	}
	/********************************************************************************************/
	public boolean ponerValorEn(int i, CRegistro r) throws IOException {
		if (i >= 0 && i <= nregs) {
			if (r.tamaño() >= tamañoReg) {
				System.err.println("Numero de registros excedido");
			} else {
				fes.seek(i * tamañoReg);
				fes.writeUTF(r.getReferencia());
				fes.writeDouble(r.getPrecio());
				return true;
			}
		} else {
			System.err.println("Numero de registro fuera de limites");
		}
		return false;
	}
	/********************************************************************************************/
	public CRegistro valorEn(int i) throws IOException{ //obtiene un registro
		if(i>=0 && i<=nregs) {//si esta entre mayor a 0 y menor a nregs entonces busca
			fes.seek(i * tamañoReg);//obtiene el registro
			return new CRegistro(fes.readUTF(),fes.readDouble());
		}
		else {
			System.err.println("Numero de registro fuera de limites");
		}
		return null;//no ecuentra nada retorna null
	}
}
