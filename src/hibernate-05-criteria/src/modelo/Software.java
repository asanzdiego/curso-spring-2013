package modelo;

public class Software extends Producto {

	private String tecnologia;

	public Software() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Software(Integer idProducto, String nombre, float stock,
			String tecnologia) {
		super(idProducto, nombre, stock);
		this.tecnologia = tecnologia;
	}

	public String getTecnologia() {
		return tecnologia;
	}

	public void setTecnologia(String tecnologia) {
		this.tecnologia = tecnologia;
	}

	

	
	
	
}
