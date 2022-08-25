import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;
public class reto2_1 {
	public static void main(String[] args) {
		int cant;
		Scanner sc = new Scanner(System.in);
		cant = Integer.parseInt(sc.nextLine());
		ArrayList<String> citiesSick = new ArrayList<String>(cant);
		Paciente sicks[] = new Paciente[cant];
		String entrada[] = {"Ann Chapman-1229130889-87-Villavicencio-Comfenalco Valle-hipertension",
				"Noella Urena-1163294672-50-Rioacha-Famisana-diabetes",
				"Justin Word-1090130996-94-Mocoa-Comfenalco Valle-hipertension",
				"Stanley Roper-1067081674-44-San Jose de Cucuta-Comfenalco Valle-respiratorias",
				"Thomas Troupe-1295640288-73-Ibague-Cruz Blanca-cancer",
				"James Johnson-1236033168-61-San Andres-SALUDCOLOMBIA-diabetes",
				"Joe Marshall-1171480034-87-Villavicencio-Salud Total-diabetes",
				"Patricia Conn-1071152004-93-Rioacha-Coomeva-hipertension",
				"Trina Dunn-1038865869-72-Santa Marta-Cruz Blanca-diabetes",
				"Cecil Gavenda-1021707716-56-Santa Marta-Solsalud-cancer",
				"Louise Walls-1269179545-24-Puerto Carreño-SALUDCOLOMBIA-cerebrovasculares",
				"Marisa Campbell-1116098282-72-Pasto-Colseguros-cerebrovasculares",
				"Theodore Fant-1093741936-28-Popayan-Salud Total-cardiovasculares",
				"Jodi Reyes-1071491814-28-Tunja-Coomeva-cardiovasculares",
				"Margaret Amin-1037494271-76-Tunja-Salud Total-hipertension"};
		for (int i = 0; i < cant; i++) {
			String paciente;
			Paciente p = new Paciente();
			//paciente = sc.nextLine();
			paciente = entrada[i];
			String[] partes = paciente.split("-");
			citiesSick.add(partes[3]);
			p.setNombre(partes[0]);
			p.setCedula(partes[1]);
			p.setEdad(Integer.parseInt(partes[2]));
			p.setCiudad(partes[3]);
			p.setEps(partes[4]);
			p.setEnfermedad(partes[5]);
			sicks[i] = p;
			sc.nextLine();
		}
		Set<String> s = new LinkedHashSet<String>(citiesSick);
		citiesSick.clear();
		citiesSick.addAll(s);
		/*ArrayList<String> vector = new ArrayList<String>();
		for (int i = 0; i < citiesSick.length-1; i++) {
	    	if (citiesSick[i].equals(citiesSick[i+1]) == false) 
	    		vector.add(citiesSick[i]);
	    }
	    vector.add(citiesSick[citiesSick.length -1]);*/
	    int max = 0;
	    int j;
		String repetido = null;
		for (int i = 0; i < citiesSick.size(); i++) {
			int cont = 0;
			for (j = 0; j < sicks.length; j++) {
				if(citiesSick.get(i).equals(sicks[j].getCiudad())) {
					cont++;
				}
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
		for (int i = 0; i < sicks.length; i++) {
			System.out.println(sicks[i].getCiudad());
		}
	}
}

///////////////////

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
	    int j;
		String repetido = null;
		for (int i = 0; i < citiesSick.size(); i++) {
			int cont = 0;
			for (j = 0; j < sicks.length; j++) {
				if(citiesSick.get(i).equals(sicks[j].getCiudad())) {
					cont++;
				}
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