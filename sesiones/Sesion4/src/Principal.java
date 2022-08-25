import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int cantidad;
				
		System.out.println("Digite numero de productos a manejar");
		cantidad = sc.nextInt();
		Producto vector[] = new Producto[cantidad]; // instancia de vector de tipo producto
		sc.nextLine();
		for (int i = 0; i < vector.length; i++) { // recorrido del vector para asignar objetos de tipo producto en el vector
			Producto p = new Producto(); // instancia de la clase producto
			System.out.println("Digite codigo de producto");
			p.setCodigo(sc.nextLine());
			System.out.println("Digite precio de producto");
			p.setPrecioProducto(sc.nextDouble());
			System.out.println("Digite cantidad en bodega de producto");
			p.setCantidadB(sc.nextInt());
			System.out.println("Digite cantidad minima en bodega de producto");
			p.setCantMinB(sc.nextInt());
			sc.nextLine();
			vector[i] = p; //asignación del objeto producto en la posición i del vector de productos
		}
		int minimo = vector[0].getCantidadB();
		int index = 0;
		for (int j = 0; j < vector.length; j++) {
			if(minimo > vector[j].getCantidadB()) {
				minimo = vector[j].getCantidadB();
				index = j;
			}
			if(vector[j].solicitarPedido())
				System.out.println("Es necesario hacer un pedido "+vector[j].getCodigo());
			else
				System.out.println("NO Es necesario hacer un pedido");
		}
		System.out.println("El codigo del producto mas escaso es: "+vector[index].getCodigo());
	}
}
