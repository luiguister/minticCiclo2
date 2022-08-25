package ej3Java;

public class Producto {
	private int codigo; // codigo de producto
	private double precioCompra; // precio de compra
	private int cantidadBod; //cantidad en bodega
	private int cantMinReq; //cantidad minima requerida en bodega
	
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public double getPrecioCompra() {
		return precioCompra;
	}

	public void setPrecioCompra(double precioCompra) {
		this.precioCompra = precioCompra;
	}

	public int getCantidadBod() {
		return cantidadBod;
	}

	public void setCantidadBod(int cantidadBod) {
		this.cantidadBod = cantidadBod;
	}

	public int getCantMinReq() {
		return cantMinReq;
	}

	public void setCantMinReq(int cantMinReq) {
		this.cantMinReq = cantMinReq;
	}
	
	public boolean solicitar(int cant, int cantMin){
		boolean bandera = false;
		if(cant < cantMin)
			bandera = true;
		else
			bandera = false;
		
		return bandera;
	}

}
