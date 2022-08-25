import java.util.Scanner;
public class reto1 {
	public static void main(String[] args) {
		int cant;
		String cities;
		Scanner sc = new Scanner(System.in);
		cant = Integer.parseInt(sc.nextLine());
		String citiesSick[] = new String[cant];
		for (int i = 0; i < cant; i++) {
			    String paciente;
				paciente = sc.nextLine();
				String[] partes = paciente.split("-");
				citiesSick[i] = partes[3];
		}
		cities = sc.nextLine();
		String[] citiesSplit = cities.split("-");
		int max = 0;
		int j;
		String repetido = null;
		for (int i = 0; i < citiesSplit.length; i++) {
			int cont = 0;
			for (j = 0; j < citiesSick.length; j++) {
				if(citiesSplit[i].equals(citiesSick[j])) {
					cont++;
				}
			}
			if(cont > max) {
				max = cont;
				repetido = citiesSplit[i];
			}
		}
		System.out.println(repetido);
	}
}


