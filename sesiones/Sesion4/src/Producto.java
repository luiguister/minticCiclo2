
public class Producto {
	private String codigo;
	private double precioProducto;
	private int cantidadB;
	private int cantMinB;
	
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public double getPrecioProducto() {
		return precioProducto;
	}
	public void setPrecioProducto(double precioProducto) {
		this.precioProducto = precioProducto;
	}
	public int getCantidadB() {
		return cantidadB;
	}
	public void setCantidadB(int cantidadB) {
		this.cantidadB = cantidadB;
	}
	public int getCantMinB() {
		return cantMinB;
	}
	public void setCantMinB(int cantMinB) {
		this.cantMinB = cantMinB;
	}
	
	public boolean solicitarPedido() {
		return this.cantidadB < this.cantMinB; 
			
	}
	
	
}
