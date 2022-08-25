package Modelo;
public class Producto {
    
    private static final String INITIAL_VALUE = "";

    int codigo;
    
	String nombre;
    int p_compra;
    int p_venta;
    int cant_b;
    int cant_min;
    int cant_max;

    public Producto() {
        reset();
    }
    
    public void reset() {
    	codigo = 0;
        nombre = "";
        p_compra = 0;
        p_venta = 0;
        cant_b = 0;
        cant_min = 0;
        cant_max = 0;
    }
    
    public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getP_compra() {
		return p_compra;
	}

	public void setP_compra(int p_compra) {
		this.p_compra = p_compra;
	}

	public int getP_venta() {
		return p_venta;
	}

	public void setP_venta(int p_venta) {
		this.p_venta = p_venta;
	}

	public int getCant_b() {
		return cant_b;
	}

	public void setCant_b(int cant_b) {
		this.cant_b = cant_b;
	}

	public int getCant_min() {
		return cant_min;
	}

	public void setCant_min(int cant_min) {
		this.cant_min = cant_min;
	}

	public int getCant_max() {
		return cant_max;
	}

	public void setCant_max(int cant_max) {
		this.cant_max = cant_max;
	}

	public static String getInitialValue() {
		return INITIAL_VALUE;
	}


    
    //================================================================= setValue
    /** Set the total value. 
    *@param value New value that should be used for the calculator total. 
    */
    
}

