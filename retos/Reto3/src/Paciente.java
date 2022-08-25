import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;

public class Paciente extends Persona{
	private String eps;
	private String enfermedad;
	
	public Paciente(String eps, String enfermedad) {
		super();
		this.eps = eps;
		this.enfermedad = enfermedad;
	}
	
	public Paciente() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Paciente(String nombre, String cedula, int edad, String ciudad) {
		super(nombre, cedula, edad, ciudad);
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
	public String mostrar() {
		return this.getNombre()+" "+this.getCedula()+" "+this.getEdad()+" "+this.getCiudad()+" "+this.getEps()+" "+this.getEnfermedad();
	}
	
	public String procesar(ArrayList<Paciente> vector, ArrayList<String>ciudades) {
		Set<String> s = new LinkedHashSet<String>(ciudades);
		ciudades.clear();
		ciudades.addAll(s);
		int max = 0;
	    String repetido = null;
		for (int i = 0; i < ciudades.size(); i++) {
			int cont = 0;
			for (int j = 0; j < vector.size(); j++) {
				if(ciudades.get(i).equals(vector.get(j).getCiudad())) 
					cont++;
			}
			if(cont > max) {
				max = cont;
				repetido = ciudades.get(i); 
			}
		}
		String texto2 = "";
		texto2 += repetido+"\n";
		for (int i = 0; i < vector.size(); i++) {
			texto2 += vector.get(i).getCedula()+" "+vector.get(i).clasificarEdad(vector.get(i).getEdad())+"\n";
		}
		return texto2;
	}
}
