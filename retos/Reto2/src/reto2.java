import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;
public class reto2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int cant;
		cant = Integer.parseInt(sc.nextLine());
		ArrayList<String> citiesSick = new ArrayList<String>(cant);
		Paciente sicks[] = new Paciente[cant];
		for (int i = 0; i < cant; i++) {
			String paciente;
			Paciente p = new Paciente();
			paciente = sc.nextLine();
			String[] partes = paciente.split("-");
			citiesSick.add(partes[3]);
			p.setNombre(partes[0]);
			p.setCedula(partes[1]);
			p.setEdad(Integer.parseInt(partes[2]));
			p.setCiudad(partes[3]);
			p.setEps(partes[4]);
			p.setEnfermedad(partes[5]);
			sicks[i] = p;
		}
		Set<String> s = new LinkedHashSet<String>(citiesSick);
		citiesSick.clear();
		citiesSick.addAll(s);
		int max = 0;
	    String repetido = null;
		for (int i = 0; i < citiesSick.size(); i++) {
			int cont = 0;
			for (int j = 0; j < sicks.length; j++) {
				if(citiesSick.get(i).equals(sicks[j].getCiudad())) 
					cont++;
			}
			if(cont > max) {
				max = cont;
				repetido = citiesSick.get(i); 
			}
		}
		System.out.println(repetido);
		for (int i = 0; i < sicks.length; i++) {
			System.out.println(sicks[i].getCedula()+" "+sicks[i].clasificarEdad(sicks[i].getEdad()));
		}
	}
}