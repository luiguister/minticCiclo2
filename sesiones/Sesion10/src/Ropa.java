
public class Ropa extends Producto{
	private String talla;
	private boolean planchado;
	
	public Ropa() {
		super();
	}
	
	public Ropa(String codigo, String descripcion, double precioCompra, double precioVenta, int cantB, int cantMinB,
			int cantMaxInvP, String talla, boolean planchado) {
		super(codigo, descripcion, precioCompra, precioVenta, cantB, cantMinB, cantMaxInvP);
		this.talla = talla;
		this.planchado = planchado;
	}

	public String getTalla() {
		return talla;
	}
	public void setTalla(String talla) {
		this.talla = talla;
	}
	public boolean isPlanchado() {
		return planchado;
	}
	public void setPlanchado(boolean planchado) {
		this.planchado = planchado;
	}
	
	@Override
	public String mostrar() { //metodo 3
		return this.getCodigo()+"-"+this.getDescripcion()+"-"+this.getPrecioCompra()+"-"+this.getPrecioVenta()+"-"+this.getCantidadB()+"-"+
				this.getCantMinB()+"-"+this.getCantMaxInvP()+"-"+this.getTalla()+"-"+this.isPlanchado();
	}

	@Override
	public boolean solicitarPedido() { //metodo 1
		if(this.getCantidadB()  < this.getCantMinB())
			return true;
		else
			return false;
	}

	@Override
	public double calcularTotalPagar(int cant) { //metodo 2
		return (cant * this.getPrecioCompra())*(1-this.getDESCUENTO());
	}
	
}
