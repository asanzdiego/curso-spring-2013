package modelo;

public class DatosBancarios {

	private Integer idCliente;
	private Cliente cliente;
	private String banco;
	private int numeroTC;

	public DatosBancarios() {
		super();
	}

	public DatosBancarios(Integer id, Cliente cliente, String banco,
			int numeroTC) {
		super();
		this.idCliente = id;
		this.cliente = cliente;
		this.banco = banco;
		this.numeroTC = numeroTC;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public String getBanco() {
		return banco;
	}

	public void setBanco(String banco) {
		this.banco = banco;
	}

	public int getNumeroTC() {
		return numeroTC;
	}

	public void setNumeroTC(int numeroTC) {
		this.numeroTC = numeroTC;
	}

	public Integer getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Integer id) {
		this.idCliente = id;
	}
	
}
