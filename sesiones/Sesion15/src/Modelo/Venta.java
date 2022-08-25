package Modelo;

public class Venta {
    
    private static final String INITIAL_VALUE = "";
    private static final int INITIAL_VALUE2 = 0;

    String productos;
    String clientes;
    int cantidad;

    public Venta() {
        reset();
    }

    public void reset() {
    	productos = INITIAL_VALUE;
    	clientes = INITIAL_VALUE;
    	cantidad = INITIAL_VALUE2;
    }
    

    public void setProductos(String value) {
        
    	productos = value;
    }
    public void setClientes(String value) {
        
    	clientes = value;
    }
public void setCantidad(int value) {
        
    	cantidad = value;
    }

    public String getProductos() {
        return productos.toString();
    }
    public String getClientes() {
        return clientes.toString();
    }
    public int getCantidad() {
        return cantidad;
    }
}
