package EjerciciosPropuestosJose;

public class Lavadora extends Electrodomestico {
	// Constantes
	private static final int CARGA_DEF = 5;
	// Atributos
	private int carga;

	// Getter and Setter
	public int getCarga() {
		return carga;
	}

	public void setCarga(int carga) {
		this.carga = carga;
	}

	// Constructores
	public Lavadora() {
		super();
		this.carga = CARGA_DEF;
	}

	public Lavadora(int precioBase, int peso) {
		super(precioBase, peso);
		this.carga = CARGA_DEF;
	}

	public Lavadora(int precioBase, String color, char consumoEnergetico, int peso, int carga) {
		super(precioBase, color, consumoEnergetico, peso);
		this.carga = carga;
	}

	@Override
	public void precioFinal() {
		// Primero llamamos al método del padre para calcular precio base
		super.precioFinal();

		if (this.carga > 30) {
			this.precioBase += 50;
		}
	}

}
