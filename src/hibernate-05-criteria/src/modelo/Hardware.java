package modelo;

public class Hardware extends Producto {

	private float peso;

	public Hardware() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Hardware(Integer idProducto, String nombre, float stock, float peso) {
		super(idProducto, nombre, stock);
		this.peso = peso;
	}

	public float getPeso() {
		return peso;
	}

	public void setPeso(float peso) {
		this.peso = peso;
	}
	
	
	
}
