
public class Persona {

  private String nombre;

  private int edad;

  public Persona() {

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

    return "Persona [nombre=" + this.nombre + ", edad=" + this.edad + "]";
  }

}
