package Clases;

import java.util.Objects;

public abstract class FiguraGeometrica {
	protected double dato1;
	
	//GETTER AND SETTER
	@Override
	public int hashCode() {
		return Objects.hash(dato1);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FiguraGeometrica other = (FiguraGeometrica) obj;
		return Double.doubleToLongBits(dato1) == Double.doubleToLongBits(other.dato1);
	}
	//CONSTRUCTOR
	public FiguraGeometrica(double dato1) {
		super();
		this.dato1 = dato1;
	}
	//toString
	@Override
	public String toString() {
		return "FiguraGeometrica [dato1=" + dato1 + "]";
	}
	//MÉTODOS
	public abstract double perimetro();
	public abstract double area();
}
