public class Persona {
	private String nombre;
	private String cedula;
	private int edad;
	private String ciudad;
	
	public Persona() {
		
	}
		
	public Persona(String nombre, String cedula, int edad, String ciudad) {
		this.nombre = nombre;
		this.cedula = cedula;
		this.edad = edad;
		this.ciudad = ciudad;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
}
