package modelo;

public class Persona {

  private int idPersona;

  private String nombre;

  private String direccion;

  private float altura;

  private long telefono;

  public Persona() {

    super();
  }

  public Persona(final int idPersona, final String nombre,
      final String direccion, final float altura, final long telefono) {

    super();
    this.idPersona = idPersona;
    this.nombre = nombre;
    this.direccion = direccion;
    this.altura = altura;
    this.telefono = telefono;
  }

  public int getIdPersona() {

    return this.idPersona;
  }

  public void setIdPersona(final int idPersona) {

    this.idPersona = idPersona;
  }

  public String getNombre() {

    return this.nombre;
  }

  public void setNombre(final String nombre) {

    this.nombre = nombre;
  }

  public String getDireccion() {

    return this.direccion;
  }

  public void setDireccion(final String direccion) {

    this.direccion = direccion;
  }

  public float getAltura() {

    return this.altura;
  }

  public void setAltura(final float altura) {

    this.altura = altura;
  }

  public long getTelefono() {

    return this.telefono;
  }

  public void setTelefono(final long telefono) {

    this.telefono = telefono;
  }

  @Override
  public String toString() {

    return "Persona [idPersona=" + this.idPersona + ", nombre=" + this.nombre
        + ", direccion=" + this.direccion + ", altura=" + this.altura
        + ", telefono=" + this.telefono + "]";
  }

}
