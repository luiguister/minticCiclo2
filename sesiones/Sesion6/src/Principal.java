import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		int cantidad;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Digite numero de productos a manejar");
		cantidad = sc.nextInt();
		Producto vector[] = new Producto[cantidad];
		sc.nextLine();
		for (int i = 0; i < vector.length; i++) {
			Producto p = new Producto();
			System.out.println("Digite codigo del producto "+(i+1));
			p.setCodigo(sc.nextLine());
			System.out.println("Digite precio de venta del producto "+(i+1));
			p.setPrecioVenta(sc.nextDouble());
			System.out.println("Digite precio de compra del producto "+(i+1));
			p.setPrecioCompra(sc.nextDouble());
			System.out.println("Digite cantidad en bodega del producto "+(i+1));
			p.setCantidadB(sc.nextInt());
			System.out.println("Digite cantidad minima en bodega del producto "+(i+1));
			p.setCantMinB(sc.nextInt());
			System.out.println("Digite cantidad maxima permitida en inventario para producto "+(i+1));
			p.setCantMaxInvP(sc.nextInt());
			vector[i] = p;
			sc.nextLine();
		}
		int max = vector[0].getCantidadB();
		int index = 0;
		for (int i = 0; i < vector.length; i++) {
			System.out.println(vector[i].getCodigo()+" - "+vector[i].getPrecioCompra()+" - "+vector[i].getPrecioVenta()
								+" - "+vector[i].getCantidadB()+" - "+vector[i].getCantMinB()+" - "+vector[i].getCantMaxInvP()+" - "+vector[i].getDESCUENTO());
			if(vector[i].solicitarPedido())
				System.out.println("Se debe solicitar pedido al proveedor del producto con codigo: "+vector[i].getCodigo());
			if(max < vector[i].getCantidadB()) {
				max = vector[i].getCantidadB();
				index = i;
			}
		}
		System.out.println("El producto con mas unidades en bodega es: "+vector[index].getCodigo());
		int cantP;
		String codigoP;
		System.out.println("Digite codigo del producto a comprar");
		codigoP = sc.nextLine();
		System.out.println("Digite unidades del producto a comprar");
		cantP = sc.nextInt();
		
		for (int i = 0; i < vector.length; i++) {
			if (vector[i].getCodigo().equals(codigoP)) 
				System.out.println("El total a pagar es de: "+vector[i].calcularTotalPagar(cantP));
		}
	}
}
