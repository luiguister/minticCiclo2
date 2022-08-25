package Lambda3;
public class ImpMiInterfaz {

	
	public static void main(String[] args) {
		
		//ICalculadora calc =(n)-> System.out.println(n+" Bienvenido");
				//calc.mensaje("Luis");
		MiInterfaz mi = () -> System.out.println("Un saludo"); 
		//mi.saluda();
	}

}
