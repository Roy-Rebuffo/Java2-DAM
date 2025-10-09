package EjerciciosPropuestosJose;

public class Television extends Electrodomestico {
	// Constantes
	private static final String RES_DEF = "20";
	private static final boolean TDT_DEF = false;
	// Atributos
	private String resolucion;
	private boolean tdt;
	
	//Getters And Setters
	public String getResolucion() {
		return resolucion;
	}
	public void setResolucion(String resolucion) {
		this.resolucion = resolucion;
	}
	public boolean isTDT() {
		return tdt;
	}
	public void setTDT(boolean tdt) {
		tdt = tdt;
	}
	
	//Constructores

	public Television() {
		super();
		this.resolucion = RES_DEF;
		this.tdt = TDT_DEF;
	}
	public Television(int precioBase, int peso) {
		super(precioBase, peso);
		this.resolucion = RES_DEF;
		this.tdt = TDT_DEF;
	}
	public Television(int precioBase, String color, char consumoEnergetico, int peso, String resolucion, boolean tdt) {
		super(precioBase, color, consumoEnergetico, peso);
		this.resolucion = resolucion;
		this.tdt = tdt;
	}
	@Override
	public void precioFinal() {
		// Primero llamamos al método del padre para calcular precio base
		super.precioFinal();
		int newRes = Integer.valueOf(resolucion);
		
		if(newRes>=40) {
			this.precioBase += this.precioBase * 0.30;
		}
		if(tdt==true) this.precioBase +=50;
	}
}
