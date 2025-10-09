package Clases;
//clase que se llame cregistro que contenga de atributos de tipo string referencia y de tipo double precio.
public class CRegistro {
	private String referencia;
	private double precio; 
	
	//get and set
	public String getReferencia() {
		return referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}


	//constructores
	public CRegistro(String referencia, double precio) {
		super();
		this.referencia = referencia;
		this.precio = precio;
	}
	
	public CRegistro() {
		super();
	}

	@Override
	public String toString() {
		return "CRegistro [referencia=" + referencia + ", precio=" + precio + "]";
	}
	
	public int tamaño() {
		return referencia.length()*2 + 8; 
		//en java cada caracter ocupa 2 bytes -> ej. "juan", es decir 4 char. entonces 4(char) * 2(bytes cada char) = 8 bytes ocuparia ese nombre
		//8porque el double ocupa 8 bytes.
	}
}
