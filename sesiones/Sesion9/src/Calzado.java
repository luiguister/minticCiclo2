
public class Calzado extends Producto{
	private int talla;

	public int getTalla() {
		return talla;
	}

	public void setTalla(int talla) {
		this.talla = talla;
	}
	
	
	public Calzado() {
		super();
	}

	public Calzado(String codigo, String descripcion, double precioCompra, double precioVenta, int cantB, int cantMinB,
			int cantMaxInvP, int talla) {
		super(codigo, descripcion, precioCompra, precioVenta, cantB, cantMinB, cantMaxInvP);
		this.talla = talla;
	}

	@Override
	public String mostrar() { //metodo 3
		return super.mostrar()+this.getTalla()+"-";
	}
}
