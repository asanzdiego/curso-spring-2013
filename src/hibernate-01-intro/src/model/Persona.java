package model;

public class Persona {

  private int idPersona;

  private String nombre;

  private int edad;

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

  public int getEdad() {

    return this.edad;
  }

  public void setEdad(final int edad) {

    this.edad = edad;
  }

  @Override
  public String toString() {

    return super.toString() + " [idPersona=" + this.idPersona + ", nombre="
        + this.nombre + ", edad=" + this.edad + "]";
  }

}
