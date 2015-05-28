package modelo;

import java.util.Date;

public class Pedido {

	private Integer idPedido;
	private String codigo;
	private Date fecha;
	private Cliente cliente;

	public Pedido() {
		super();
	}

	public Pedido(Integer idPedido, String codigo, Date fecha, Cliente cliente) {
		super();
		this.idPedido = idPedido;
		this.codigo = codigo;
		this.fecha = fecha;
		this.cliente = cliente;
	}

	public Integer getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(Integer idPedido) {
		this.idPedido = idPedido;
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
