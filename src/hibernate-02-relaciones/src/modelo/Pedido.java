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

  public Pedido(final Integer idPedido, final String codigo, final Date fecha,
      final Cliente cliente) {

    super();
    this.idPedido = idPedido;
    this.codigo = codigo;
    this.fecha = fecha;
    this.cliente = cliente;
  }

  public Integer getIdPedido() {

    return this.idPedido;
  }

  public void setIdPedido(final Integer idPedido) {

    this.idPedido = idPedido;
  }

  public String getCodigo() {

    return this.codigo;
  }

  public void setCodigo(final String codigo) {

    this.codigo = codigo;
  }

  public Date getFecha() {

    return this.fecha;
  }

  public void setFecha(final Date fecha) {

    this.fecha = fecha;
  }

  public Cliente getCliente() {

    return this.cliente;
  }

  public void setCliente(final Cliente cliente) {

    this.cliente = cliente;
  }

}
