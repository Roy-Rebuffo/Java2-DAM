package Clases;

import java.util.Objects;

public class persona {
	private String nombre;
	private String apellido;
	private int edad;
	
	//Getter and Setter
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getApellido() {
		return apellido;
	}
	
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	//Constructor
	public persona(String nombre, String apellido, int edad) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
	}
	//metodo toString
	@Override
	public String toString() {
		return "nombre: " + nombre + "\n"+
				"apellido: " + apellido +"\n"+
				"edad: " + edad;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(apellido, edad, nombre);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		persona other = (persona) obj;
		return Objects.equals(apellido, other.apellido) && edad == other.edad && Objects.equals(nombre, other.nombre);
	}
	
}
