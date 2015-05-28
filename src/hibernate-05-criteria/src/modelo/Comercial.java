package modelo;

import java.util.Set;

public class Comercial {

	private Integer idComercial;
	private String nombre;
	
	private Set<Cliente> clientes;

	public Comercial() {
		super();
	}

	public Comercial(Integer idComercial, String nombre, Set<Cliente> clientes) {
		super();
		this.idComercial = idComercial;
		this.nombre = nombre;
		this.clientes = clientes;
	}

	public Integer getIdComercial() {
		return idComercial;
	}

	public void setIdComercial(Integer idComercial) {
		this.idComercial = idComercial;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Set<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(Set<Cliente> clientes) {
		this.clientes = clientes;
	}
	
	
	
}
