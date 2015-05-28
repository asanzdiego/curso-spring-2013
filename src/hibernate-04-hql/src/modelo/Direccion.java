package modelo;

public class Direccion {

  private String ciudad = "";

  private String calle = "";

  private String codPostal = "";

  public Direccion() {

    super();
  }

  public Direccion(final String ciudad, final String calle,
      final String codPostal) {

    super();
    this.ciudad = ciudad;
    this.calle = calle;
    this.codPostal = codPostal;
  }

  public String getCiudad() {

    return this.ciudad;
  }

  public void setCiudad(final String ciudad) {

    this.ciudad = ciudad;
  }

  public String getCalle() {

    return this.calle;
  }

  public void setCalle(final String calle) {

    this.calle = calle;
  }

  public String getCodPostal() {

    return this.codPostal;
  }

  public void setCodPostal(final String codPostal) {

    this.codPostal = codPostal;
  }

}
