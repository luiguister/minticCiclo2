package Lambda;

public class Ejecutor {

	public static void main(String... args) {
		//ICalculadora calc =(n)-> System.out.println(n+" Bienvenido");
		//calc.mensaje("Luis");
		
		ICalculadora calc =(n, m)->{ 
			double resultado = n+m;
			System.out.println("La suma es "+resultado);
		};
		calc.operacion(5, 8);
		ICalculadora calc2 =(n, m)->{ 
			double resultado = n-m;
			System.out.println("La resta es "+resultado);
		};
		calc2.operacion(5, 8);
	}
}
