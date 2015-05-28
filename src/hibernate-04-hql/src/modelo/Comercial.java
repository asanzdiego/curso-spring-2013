package modelo;

import java.util.Set;

public class Comercial {

  private Integer idComercial;

  private String nombre;

  private Set<Cliente> clientes;

  public Comercial() {

    super();
  }

  public Comercial(final Integer idComercial, final String nombre,
      final Set<Cliente> clientes) {

    super();
    this.idComercial = idComercial;
    this.nombre = nombre;
    this.clientes = clientes;
  }

  public Integer getIdComercial() {

    return this.idComercial;
  }

  public void setIdComercial(final Integer idComercial) {

    this.idComercial = idComercial;
  }

  public String getNombre() {

    return this.nombre;
  }

  public void setNombre(final String nombre) {

    this.nombre = nombre;
  }

  public Set<Cliente> getClientes() {

    return this.clientes;
  }

  public void setClientes(final Set<Cliente> clientes) {

    this.clientes = clientes;
  }

}
