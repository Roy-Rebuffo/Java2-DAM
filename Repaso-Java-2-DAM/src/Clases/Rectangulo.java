package Clases;

public class Rectangulo extends FiguraGeometrica {
	private double dato2;
	
	//Getter and setter
	public Rectangulo(double dato1, double dato2) {
		super(dato1);
		this.dato2 = dato2;
	}

	public double getDato2() {
		return dato2;
	}

	public void setDato2(double dato2) {
		this.dato2 = dato2;
	}

	@Override
	public double perimetro() {
		return 2*(dato1 + dato2);
	}

	@Override
	public double area() {
		return dato1*dato2;
	}

	@Override
	public String toString() {
		return "Rectángulo dato1 = " + dato1 + " dato2 = " + dato2;
	}

	
}
