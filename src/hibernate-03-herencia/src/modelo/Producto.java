package modelo;

public class Producto {

  protected Integer idProducto;

  protected String nombre;

  protected float stock;

  public Producto() {

    super();
  }

  public Producto(final Integer idProducto, final String nombre,
      final float stock) {

    super();
    this.idProducto = idProducto;
    this.nombre = nombre;
    this.stock = stock;
  }

  public Integer getIdProducto() {

    return this.idProducto;
  }

  public void setIdProducto(final Integer idProducto) {

    this.idProducto = idProducto;
  }

  public String getNombre() {

    return this.nombre;
  }

  public void setNombre(final String nombre) {

    this.nombre = nombre;
  }

  public float getStock() {

    return this.stock;
  }

  public void setStock(final float stock) {

    this.stock = stock;
  }

}
