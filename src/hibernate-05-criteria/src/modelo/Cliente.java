package modelo;

import java.util.List;
import java.util.Set;

public class Cliente {

	private Integer idCliente;
	private String nombre;
	private Direccion direccion;
	private String telefono;
	// One-to-one
	private DatosBancarios datosBancarios;
	// One-to-many
	private Set<Pedido> pedidos;
	// One-to-many con List
	private List<Factura> facturas;

	// Many-to-many
	private Set<Comercial> comerciales;

	public Cliente() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Cliente(Integer idCliente, String nombre, Direccion direccion,
			String telefono) {
		super();
		this.idCliente = idCliente;
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
	}

	public Integer getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public DatosBancarios getDatosBancarios() {
		return datosBancarios;
	}

	public void setDatosBancarios(DatosBancarios datosBancarios) {
		this.datosBancarios = datosBancarios;
	}

	public Set<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(Set<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	public Set<Comercial> getComerciales() {
		return comerciales;
	}

	public void setComerciales(Set<Comercial> comerciales) {
		this.comerciales = comerciales;
	}

	public List<Factura> getFacturas() {
		return facturas;
	}

	public void setFacturas(List<Factura> facturas) {
		this.facturas = facturas;
	}

}
