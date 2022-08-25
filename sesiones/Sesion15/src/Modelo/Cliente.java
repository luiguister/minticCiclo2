package Modelo;
public class Cliente {
    
    private static final String INITIAL_VALUE = "";

    String cedula;
    String nombre;
    String apellido;
    String genero;
    
    public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	

    public Cliente() {
        reset();
    }

    public void reset() {
    	cedula = INITIAL_VALUE;
    	nombre = INITIAL_VALUE;
    	apellido = INITIAL_VALUE;
    	genero = INITIAL_VALUE;
    }
    

    }
