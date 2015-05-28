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

  public Factura(final Integer idFactura, final String codigo,
      final Date fecha, final Cliente cliente) {

    super();
    this.idFactura = idFactura;
    this.codigo = codigo;
    this.fecha = fecha;
    this.cliente = cliente;
  }

  public Integer getIdFactura() {

    return this.idFactura;
  }

  public void setIdFactura(final Integer idFactura) {

    this.idFactura = idFactura;
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
