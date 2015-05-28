package modelo;

public class Direccion {

	private String ciudad    = "";
	private String calle     = "";
	private String codPostal = "";

	public Direccion() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Direccion(String ciudad, String calle, String codPostal) {
		super();
		this.ciudad = ciudad;
		this.calle = calle;
		this.codPostal = codPostal;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public String getCodPostal() {
		return codPostal;
	}

	public void setCodPostal(String codPostal) {
		this.codPostal = codPostal;
	}

}
