package modelo;

public class Consultoria extends Producto {

  private double ppc; // Precio por cabeza

  public Consultoria() {

    super();
    // TODO Auto-generated constructor stub
  }

  public Consultoria(final Integer idProducto, final String nombre,
      final float stock, final double ppc) {

    super(idProducto, nombre, stock);
    this.ppc = ppc;
  }

  public double getPpc() {

    return this.ppc;
  }

  public void setPpc(final double ppc) {

    this.ppc = ppc;
  }

}
