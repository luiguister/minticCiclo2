public class Paciente {
  private String nombre;
  private String cedula;
  private int edad;
  private String ciudad;
  private String eps;
  private String enfermedad;
  
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
	public String getEps() {
		return eps;
	}
	public void setEps(String eps) {
		this.eps = eps;
	}
	public String getEnfermedad() {
		return enfermedad;
	}
	public void setEnfermedad(String enfermedad) {
		this.enfermedad = enfermedad;
	}
	public String clasificarEdad(int edad) {
		if (edad>=21 && edad <=30) 
			return "Joven adulto";
		else if (edad>30 && edad<=60)
			return "Adulto";
		else  if (edad>60)
			return "Tercera edad";
		return null;
	}
}