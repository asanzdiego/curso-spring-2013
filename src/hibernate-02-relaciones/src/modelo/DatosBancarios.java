package modelo;

public class DatosBancarios {

  private Integer idCliente;

  private Cliente cliente;

  private String banco;

  private int numeroTC;

  public DatosBancarios() {

    super();
  }

  public DatosBancarios(final Integer id, final Cliente cliente,
      final String banco, final int numeroTC) {

    super();
    this.idCliente = id;
    this.cliente = cliente;
    this.banco = banco;
    this.numeroTC = numeroTC;
  }

  public Cliente getCliente() {

    return this.cliente;
  }

  public void setCliente(final Cliente cliente) {

    this.cliente = cliente;
  }

  public String getBanco() {

    return this.banco;
  }

  public void setBanco(final String banco) {

    this.banco = banco;
  }

  public int getNumeroTC() {

    return this.numeroTC;
  }

  public void setNumeroTC(final int numeroTC) {

    this.numeroTC = numeroTC;
  }

  public Integer getIdCliente() {

    return this.idCliente;
  }

  public void setIdCliente(final Integer id) {

    this.idCliente = id;
  }

}
