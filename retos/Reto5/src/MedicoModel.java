import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

public class MedicoModel extends Persona{
	private int cedula;
	private String especialidad;
	private int cedulaP;
	
	public MedicoModel() {
		super();
	}
	public MedicoModel(int cedula, int cedulaP) {
		this.cedula = cedula;
		this.cedulaP = cedulaP;
	}
	
	public int getCedulaP() {
		return cedulaP;
	}

	public void setCedulaP(int cedulaP) {
		this.cedulaP = cedulaP;
	}

	public int getCedula() {
		return cedula;
	}

	public void setCedula(int cedula) {
		this.cedula = cedula;
	}

	public String getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}
	@Override
	public String toString() {
		return cedula+"-"+cedulaP;
		
	}
	public ArrayList<Integer> pacientes(HashMap<Integer, String> hash, int cedula) {
		ArrayList<Integer> cedulas = new ArrayList<Integer>();
		for (Entry<Integer, String> tuple : hash.entrySet()) {
			String[] partes = new String[hash.size()];
			partes =tuple.getValue().split("-");
	        if(cedula == Integer.parseInt(partes[0])) {
				cedulas.add(Integer.parseInt(partes[1]));
			}
		}
		return cedulas;
	}
}
