public class Producto {
	private String codigo;
	private String descripcion;
	private double precioCompra;
	private double precioVenta;
	private int cantidadB;
	private int cantMinB;
	private int cantMaxInvP;
	private final float DESCUENTO = 0.01F;
	
	public Producto(String codigo, String descripcion, double precioCompra, double precioVenta, int cantB, int cantMinB, int cantMaxInvP) {
		//super();
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.precioCompra = precioCompra;
		this.precioVenta = precioVenta;
		this.cantidadB = cantB;
		this.cantMinB = cantMinB;
		this.cantMaxInvP = cantMaxInvP;
	}
	
	public Producto() {
		
	}
	
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public double getPrecioCompra() {
		return precioCompra;
	}
	public void setPrecioCompra(double precioCompra) {
		this.precioCompra = precioCompra;
	}
	public double getPrecioVenta() {
		return precioVenta;
	}
	public void setPrecioVenta(double precioVenta) {
		this.precioVenta = precioVenta;
	}
	public int getCantMinB() {
		return cantMinB;
	}
	public void setCantMinB(int cantMinB) {
		if (cantMinB < 0) {
			this.cantMinB = 0;
		}
		else
			this.cantMinB = cantMinB;
	}
	public int getCantMaxInvP() {
		return cantMaxInvP;
	}
	public void setCantMaxInvP(int cantMaxInvP) {
		this.cantMaxInvP = cantMaxInvP;
	}
	public float getDESCUENTO() {
		return DESCUENTO;
	}
	public int getCantidadB() {
		return cantidadB;
	}

	public void setCantidadB(int cantidadB) {
		this.cantidadB = cantidadB;
	}
	
	public boolean solicitarPedido() { //metodo 1
		if(cantidadB < cantMinB)
			return true;
		else
			return false;
	}
	
	public double calcularTotalPagar(int cant) { //metodo 2
		return (cant * precioCompra)*(1-DESCUENTO);
	}
	
	public String mostrar() { //metodo 3
		
		return this.getCodigo()+"-"+this.getDescripcion()+"-"+this.getPrecioCompra()+"-"+this.getPrecioVenta()+"-"+this.getCantidadB()+"-"+
			this.getCantMinB()+"-"+this.getCantMaxInvP()+"-";
	}
	
	public double calcularTotalPagarVenta(int cant, boolean desc) {
		if (desc) 
			return (cant * precioVenta)*(1-DESCUENTO);	
		else
			return (cant * precioVenta);
		
	}
}