
public class PacienteModel extends Persona{

	private String eps;
	private String enfermedad;
	
	public PacienteModel() {
		super();
		// TODO Auto-generated constructor stub
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
	
	@Override
	public String toString() {
		return super.toString()+" "+eps+" "+enfermedad;
	}
	
}
