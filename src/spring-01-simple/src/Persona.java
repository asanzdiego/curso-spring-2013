import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;

public class Persona implements Serializable {

  private String nombre;

  private int edad;

  private float altura;

  private Date fecha;

  private Persona pareja;

  public Persona() {

  }

  public Persona(final String nombre, final int edad, final float altura) {

    this.nombre = nombre;
    this.edad = edad;
    this.altura = altura;
  }

  public Persona(final String nombre, final int edad, final float altura,
      final Date fecha) {

    super();
    this.nombre = nombre;
    this.edad = edad;
    this.altura = altura;
    this.fecha = fecha;
  }

  public void creacion() {

    System.out.println("==========");
    System.out.println("bean creada:\n" + this);
    System.out.println("==========");
  }

  public void destruccion() {

    System.out.println("==========");
    System.out.println("bean destruida:\n" + this);
    System.out.println("==========");
  }

  public Persona getPareja() {

    return this.pareja;
  }

  public void setPareja(final Persona pareja) {

    this.pareja = pareja;
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

  public float getAltura() {

    return this.altura;
  }

  public void setAltura(final float altura) {

    this.altura = altura;
  }

  public Date getFecha() {

    return this.fecha;
  }

  public void setFecha(final Date fecha) {

    this.fecha = fecha;
  }

  @Override
  public String toString() {

    return ToStringBuilder.reflectionToString(this);
  }

}
