package Clases;

public class Cubo extends Cuadrado {

	public Cubo(double dato1) {
		super(dato1);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "Cubo [lado = ]" + dato1;
	}

	public double Volumen() {
		return Math.pow(dato1, 3);
	}

}
