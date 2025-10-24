package Clases;

import java.io.Serializable;
import java.time.LocalDate;

//tendran nombre autor y fecha de publicacion (localDate)
public class CLibros implements Serializable{
	private String nombre;
	private String autor;
	private LocalDate publicacion;

	public CLibros(String nombre, String autor, LocalDate publicacion) {
		super();
		this.nombre = nombre;
		this.autor = autor;
		this.publicacion = publicacion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public LocalDate getPublicacion() {
		return publicacion;
	}

	public void setPublicacion(LocalDate publicacion) {
		this.publicacion = publicacion;
	}

	@Override
	public String toString() {
		return "CLibros [nombre=" + nombre + ", autor=" + autor + ", publicacion=" + publicacion + "]";
	}
	
	
}
