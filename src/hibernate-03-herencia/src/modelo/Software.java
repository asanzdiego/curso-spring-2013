package modelo;

public class Software extends Producto {

  private String tecnologia;

  public Software() {

    super();
  }

  public Software(final Integer idProducto, final String nombre,
      final float stock, final String tecnologia) {

    super(idProducto, nombre, stock);
    this.tecnologia = tecnologia;
  }

  public String getTecnologia() {

    return this.tecnologia;
  }

  public void setTecnologia(final String tecnologia) {

    this.tecnologia = tecnologia;
  }

}
