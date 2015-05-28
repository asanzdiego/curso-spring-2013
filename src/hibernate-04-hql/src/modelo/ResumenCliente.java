package modelo;

public class ResumenCliente {

  private String nombre;

  private String telefono;

  // Hibernate exige el constructor con parametros
  public ResumenCliente(final String nombre, final String telefono) {

    super();
    this.nombre = nombre;
    this.telefono = telefono;
  }

  public String getNombre() {

    return this.nombre;
  }

  public void setNombre(final String nombre) {

    this.nombre = nombre;
  }

  public String getTelefono() {

    return this.telefono;
  }

  public void setTelefono(final String telefono) {

    this.telefono = telefono;
  }

}
