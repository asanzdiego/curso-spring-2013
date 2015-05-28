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

  // One-to-many con Set
  private Set<Pedido> pedidos;

  // One-to-many con List
  private List<Factura> facturas;

  // Many-to-many
  private Set<Comercial> comerciales;

  public Cliente() {

    super();
    // TODO Auto-generated constructor stub
  }

  public Cliente(final Integer idCliente, final String nombre,
      final Direccion direccion, final String telefono) {

    super();
    this.idCliente = idCliente;
    this.nombre = nombre;
    this.direccion = direccion;
    this.telefono = telefono;
  }

  public Integer getIdCliente() {

    return this.idCliente;
  }

  public void setIdCliente(final Integer idCliente) {

    this.idCliente = idCliente;
  }

  public String getNombre() {

    return this.nombre;
  }

  public void setNombre(final String nombre) {

    this.nombre = nombre;
  }

  public Direccion getDireccion() {

    return this.direccion;
  }

  public void setDireccion(final Direccion direccion) {

    this.direccion = direccion;
  }

  public String getTelefono() {

    return this.telefono;
  }

  public void setTelefono(final String telefono) {

    this.telefono = telefono;
  }

  public DatosBancarios getDatosBancarios() {

    return this.datosBancarios;
  }

  public void setDatosBancarios(final DatosBancarios datosBancarios) {

    this.datosBancarios = datosBancarios;
  }

  public Set<Pedido> getPedidos() {

    return this.pedidos;
  }

  public void setPedidos(final Set<Pedido> pedidos) {

    this.pedidos = pedidos;
  }

  public Set<Comercial> getComerciales() {

    return this.comerciales;
  }

  public void setComerciales(final Set<Comercial> comerciales) {

    this.comerciales = comerciales;
  }

  public List<Factura> getFacturas() {

    return this.facturas;
  }

  public void setFacturas(final List<Factura> facturas) {

    this.facturas = facturas;
  }

  @Override
  public String toString() {

    return "Cliente [idCliente=" + this.idCliente + ", nombre=" + this.nombre
        + ", direccion=" + this.direccion + ", telefono=" + this.telefono
        + ", datosBancarios=" + this.datosBancarios + ", pedidos="
        + this.pedidos + ", facturas=" + this.facturas + ", comerciales="
        + this.comerciales + "]";
  }

}
