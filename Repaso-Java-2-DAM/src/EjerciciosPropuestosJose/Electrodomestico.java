package EjerciciosPropuestosJose;

import Clases.Biblioteca;
import Clases.Circulo;
import Clases.Cuadrado;
import Clases.Cubo;
import Clases.Rectangulo;

public class Electrodomestico {

	// Constantes
	protected static final int PRECIO_BASE_DEF = 100;
	protected static final String COLOR_DEF = "blanco";
	protected static final char CONSUMO_ENERGETICO_DEF = 'F';
	protected static final int PESO_DEF = 5;

	// Atributos
	protected int precioBase;
	protected String color;
	protected char consumoEnergetico;
	protected int peso;

	// Getters and Setters
	public int getPrecioBase() {
		return precioBase;
	}

	public void setPrecioBase(int precioBase) {
		this.precioBase = precioBase;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public char getConsumoEnergetico() {
		return consumoEnergetico;
	}

	public void setConsumoEnergetico(char consumoEnergetico) {
		this.consumoEnergetico = consumoEnergetico;
	}

	public int getPeso() {
		return peso;
	}

	public void setPeso(int peso) {
		this.peso = peso;
	}

	// Constructors
	public Electrodomestico() {
		super();
	}

	public Electrodomestico(int precioBase, int peso) {
		super();
		this.precioBase = precioBase;
		this.peso = peso;
	}

	public Electrodomestico(int precioBase, String color, char consumoEnergetico, int peso) {
		super();
		this.precioBase = precioBase;
		this.color = color;
		this.consumoEnergetico = consumoEnergetico;
		this.peso = peso;
	}

	// toString
	@Override
	public String toString() {
		return "Electrodomestico \n" + "precioBase: " + precioBase + "\n" + "color: " + color + "\n"
				+ "consumoEnergetico: " + consumoEnergetico;
	}

	// Método para comprobar letra
	// char → es un tipo primitivo en Java, no tiene métodos.
	// Como los char son valores numéricos en Unicode, se comparan con operadores
	// relacionales (==, <, >, >=, <=).
	public char comprobarConsumoEnergetico(char letra) {
		if (letra >= 'A' && letra <= 'F') {
			return letra;
		} else {
			return CONSUMO_ENERGETICO_DEF;
		}
	}

	// Método para comprobar el color
	public String comprobarColor(String color) {
		String[] colores = { "negro", "rojo", "azul", "gris" };
		boolean valido = false;

		for (String c : colores) {
			if (c.equalsIgnoreCase(c)) {
				valido = true;
				break;
			}
		}
		if (!valido) {
			return COLOR_DEF;
		}
		return color;
	}
	
	public void precioFinal() {
		int precioFinal = precioBase;

		switch (consumoEnergetico) {
		case 'A':
			precioFinal += 100;
			break;
		case 'B':
			precioFinal += 80;
			break;
		case 'C':
			precioFinal += 60;
			break;
		case 'D':
			precioFinal += 50;
			break;
		case 'E':
			precioFinal += 30;
			break;
		case 'f':
			precioFinal += 10;
			break;
		}

		if (peso >= 0 && peso <= 20) {
			precioFinal += 10;
		} else if (peso >= 20 && peso <= 50) {
			precioFinal += 50;
		} else if (peso >= 50 && peso <= 80) {
			precioFinal += 80;
		} else {
			precioFinal += 100;
		}
	}
}
