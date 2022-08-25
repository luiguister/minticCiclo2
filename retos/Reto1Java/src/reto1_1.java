import java.util.Iterator;
import java.util.Scanner;

public class reto1_1 {

	public static void main(String[] args) {
		/*int cant;
		String cities;
		Scanner sc = new Scanner(System.in);
		System.out.println("Numero de ciudades");
		cant = Integer.parseInt(sc.nextLine());
		System.out.println("Datos de pacienes");
		String pacientes[][] = new String [cant][6];
		String pacientes2[] = new String[cant];
		for (int i = 0; i < cant; i++) {
			for (int j = 0; j < 6; j++) {
				pacientes[i][j] = sc.nextLine();
				if(j == 0 )
					pacientes2[i] = pacientes[i][j];
				else
					pacientes2[i] = pacientes2[i]+"-"+pacientes[i][j];
			}
		}
		System.out.println("Digite ciudades");
		cities = sc.nextLine();
		int maxNumRep= 0;
	    String repetido = "";
	    for(int i=0; i<cant; i++)
	    {
	        int numRep= 0;
	        for(int j=0; j<cant; j++)
	        {
	            if(pacientes[i][3]==pacientes[j][3])
	            {
	                numRep++;
	            }   
	            if(numRep>maxNumRep)
	            {
	                repetido= pacientes[i][3];
	                maxNumRep = numRep;
	            }   
	        }
	    }
	    /*System.out.println(cant);
	    for (int i = 0; i < pacientes2.length; i++) {
			System.out.println(pacientes2[i]);
		}*/
	    //System.out.println(cities);
	    //System.out.print(repetido);
		int vector[] = new int[5];
		vector[0]=10;
		vector[1]=20;
		vector[2]=30;
		vector[3]=40;
		vector[4]=50;
		
		System.out.println(vector.length);
		
		for (int i = 0; i < vector.length; i++) {
			System.out.println(vector[i]);
		}
	}
}