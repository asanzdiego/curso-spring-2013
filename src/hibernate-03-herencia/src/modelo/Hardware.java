package modelo;

public class Hardware extends Producto {

  private float peso;

  public Hardware() {

    super();
  }

  public Hardware(final Integer idProducto, final String nombre,
      final float stock, final float peso) {

    super(idProducto, nombre, stock);
    this.peso = peso;
  }

  public float getPeso() {

    return this.peso;
  }

  public void setPeso(final float peso) {

    this.peso = peso;
  }

}
