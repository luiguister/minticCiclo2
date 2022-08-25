public class Persona {
	private String nombre;
	private int cedula;
	private int edad;
	private String ciudad;
	
	public Persona() {
		
	}
		
	public Persona(String nombre, int cedula, int edad, String ciudad) {
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
	public int getCedula() {
		return cedula;
	}
	public void setCedula(int cedula) {
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
	@Override
	public String toString() {
		return nombre+" "+cedula+" "+edad+" "+ciudad;
	}
}
