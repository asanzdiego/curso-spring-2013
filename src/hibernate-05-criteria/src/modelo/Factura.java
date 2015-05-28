package modelo;

import java.util.Date;

public class Factura {

	private Integer idFactura;
	private String codigo;
	private Date fecha;
	
	private Cliente cliente;

	public Factura() {
		super();
	}

	public Factura(Integer idFactura, String codigo, Date fecha, Cliente cliente) {
		super();
		this.idFactura = idFactura;
		this.codigo = codigo;
		this.fecha = fecha;
		this.cliente = cliente;
	}

	public Integer getIdFactura() {
		return idFactura;
	}

	public void setIdFactura(Integer idFactura) {
		this.idFactura = idFactura;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
}
