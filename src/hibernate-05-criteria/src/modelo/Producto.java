package modelo;

public class Producto {

	protected Integer idProducto;
	protected String nombre;
	protected float stock;

	public Producto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Producto(Integer idProducto, String nombre, float stock) {
		super();
		this.idProducto = idProducto;
		this.nombre = nombre;
		this.stock = stock;
	}

	public Integer getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(Integer idProducto) {
		this.idProducto = idProducto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public float getStock() {
		return stock;
	}

	public void setStock(float stock) {
		this.stock = stock;
	}

}
