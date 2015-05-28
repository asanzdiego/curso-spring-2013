package modelo;

public class Consultoria extends Producto {

	private double ppc; // Precio por cabeza

	public Consultoria() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Consultoria(Integer idProducto, String nombre, float stock,
			double ppc) {
		super(idProducto, nombre, stock);
		this.ppc = ppc;
	}

	public double getPpc() {
		return ppc;
	}

	public void setPpc(double ppc) {
		this.ppc = ppc;
	}

}
