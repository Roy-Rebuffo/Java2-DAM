package Clases;

public class Circulo extends FiguraGeometrica {
	
	//Constructor
	public Circulo(double dato1) {
		super(dato1);
	}

	@Override
	public double perimetro() {
		return 2*Math.PI*dato1;
	}

	@Override
	public double area() {
		return Math.PI*Math.pow(dato1,2); //pi por radio al cuadrado
	}

	@Override
	public String toString() {
		return "Circulo ->" + super.toString();
	}
}
