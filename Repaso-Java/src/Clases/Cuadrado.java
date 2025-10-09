package Clases;

public class Cuadrado extends FiguraGeometrica{

	public Cuadrado(double dato1) {
		super(dato1);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double perimetro() {
		return 4*dato1; // lado por lado por lado por lado (4 por lado)
	}

	@Override
	public double area() {
		return Math.pow(dato1,2); // lado al cuadrado
	}

	@Override
	public String toString() {
		return "Cuadrado [lado = ]" + dato1;
	}

	
}
