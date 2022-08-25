import java.util.Scanner;

public class Principal {

	private static Scanner sc;

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		int cantR = 0;
		int cantZ = 0;
		System.out.print("cantidad de prendas de vestir: ");
		cantR = Integer.parseInt(sc.nextLine());
		System.out.print("cantidad de Zapatos a usar: ");
		cantZ = Integer.parseInt(sc.nextLine());
		Calzado c[] = new Calzado[cantZ];
		Ropa r[] = new Ropa[cantR];
		
		for (int i = 0; i < r.length; i++) {
			
			System.out.print("Digite codigo de producto: ");
			String codigo = sc.nextLine();
			System.out.print("Digite descripcion: ");
			String desc = sc.nextLine();
			System.out.print("Digite precio de compra: ");
			double precioC = Double.parseDouble(sc.nextLine());
			System.out.print("Digite precio de venta: ");
			double precioV = Double.parseDouble(sc.nextLine());
			System.out.print("Digite cantidad en bodega: ");
			int cantB = Integer.parseInt(sc.nextLine());
			System.out.print("Digite cantidad minima requerida en bodega: ");
			int cantMin = Integer.parseInt(sc.nextLine());
			System.out.print("Digite cantidad maxima en inventario: ");
			int cantMax = Integer.parseInt(sc.nextLine());
			System.out.print("Digite talla de ropa: ");
			String talla = sc.nextLine();
			System.out.print("requiere planchado?: true o false ");
			boolean planchado = Boolean.parseBoolean(sc.nextLine());
			r[i] = new Ropa(codigo, desc, precioC, precioV, cantB, cantMin, cantMax, talla, planchado);
		}
		/*for (int i = 0; i < r.length; i++) {
			System.out.print(r[i].mostrar());
			
		}*/
		
		for (int i = 0; i < c.length; i++) {
			System.out.print("Digite codigo de producto: ");
			String codigo = sc.nextLine();
			System.out.print("Digite descripcion: ");
			String desc = sc.nextLine();
			System.out.print("Digite precio de compra: ");
			double precioC = Double.parseDouble(sc.nextLine());
			System.out.print("Digite precio de venta: ");
			double precioV = Double.parseDouble(sc.nextLine());
			System.out.print("Digite cantidad en bodega: ");
			int cantB = Integer.parseInt(sc.nextLine());
			System.out.print("Digite cantidad minima requerida en bodega: ");
			int cantMin = Integer.parseInt(sc.nextLine());
			System.out.print("Digite cantidad maxima en inventario: ");
			int cantMax = Integer.parseInt(sc.nextLine());
			System.out.print("Digite talla de zapato: ");
			int talla = Integer.parseInt(sc.nextLine());
			c[i] = new Calzado(codigo, desc, precioC, precioV, cantB, cantMin, cantMax, talla);
		}
		int op = 0;
		do {
			System.out.println("1. consultar producto");
			System.out.println("2. verificar productos a pedir");
			System.out.println("3. calzado con mayor cantidad de unidades");
			System.out.println("4. ropa con mayor cantidad de unidades");
			System.out.println("5. modificar cantidad minima requerida en bodega");
			System.out.println("6. vender productos");
			System.out.println("7. salir");
			op = Integer.parseInt(sc.nextLine());
			switch(op) {
			case 1:
				System.out.println("Digite codigo del producto");
				String codigoP = sc.nextLine();
				System.out.println("Digite tipo de producto 1-ropa, 2-calzado");
				int tipo = Integer.parseInt(sc.nextLine());
				if (tipo == 1) {
					for (int i = 0; i < r.length; i++) {
						if (r[i].getCodigo().equals(codigoP)) {
							System.out.println(r[i].mostrar());
						}
					}
					
				}
				else if (tipo == 2){
					for (int i = 0; i < c.length; i++) {
						if (c[i].getCodigo().equals(codigoP)) {
							System.out.println(c[i].mostrar());
						}
					}
				}
				break;
			case 2:
				for (int i = 0; i < r.length; i++) {
					if (r[i].solicitarPedido())
						System.out.println("Se debe solicitar pedido del codigo de ropa: "+r[i].getCodigo());
				}
				for (int i = 0; i < c.length; i++) {
					if (c[i].solicitarPedido())
						System.out.println("Se debe solicitar pedido del codigo de calzado: "+c[i].getCodigo());
				}
				break;
			case 3:
				int mayor = c[0].getCantidadB();
				String cod = c[0].getCodigo();
				for (int i = 1; i < c.length; i++) {
					if (mayor < c[i].getCantidadB()) {
						mayor = c[i].getCantidadB();
						cod = c[i].getCodigo();
					}
				}
				System.out.println("El calzado con mayor cantidad de unidades en bodega es: "+cod+" con "+mayor+" unidades");
				break;
			case 4:
				mayor = r[0].getCantidadB();
				cod = r[0].getCodigo();
				for (int i = 1; i < r.length; i++) {
					if (mayor < r[i].getCantidadB()) {
						mayor = r[i].getCantidadB();
						cod = r[i].getCodigo();
					}
				}
				System.out.println("La ropa con mayor cantidad de unidades en bodega es: "+cod+" con "+mayor+" unidades");
				break;
			case 5:
				System.out.println("Digite codigo del producto");
				codigoP = sc.nextLine();
				System.out.println("Digite tipo de producto 1-ropa, 2-calzado");
				tipo = Integer.parseInt(sc.nextLine());
				System.out.println("Digite nueva cantidad minima");
				int nCantM = Integer.parseInt(sc.nextLine());
				if (tipo == 1) {
					for (int i = 0; i < r.length; i++) {
						if (r[i].getCodigo().equals(codigoP)) {
							r[i].setCantMinB(nCantM);
						}
					}
					
				}
				else if (tipo == 2){
					for (int i = 0; i < c.length; i++) {
						if (c[i].getCodigo().equals(codigoP)) {
							c[i].setCantMinB(nCantM);
						}
					}
				}
				System.out.println("cantidad minima modificada");
				break;
			case 6:
				System.out.println("Digite codigo del producto");
				codigoP = sc.nextLine();
				System.out.println("Digite tipo de producto 1-ropa, 2-calzado");
				tipo = Integer.parseInt(sc.nextLine());
				System.out.println("Digite cantidad de venta");
				int cantV = Integer.parseInt(sc.nextLine());
				if (tipo == 1) {
					for (int i = 0; i < r.length; i++) {
						if (r[i].getCodigo().equals(codigoP)) {
							if (cantV <= r[i].getCantidadB() ) {
								r[i].setCantidadB(r[i].getCantidadB() - cantV);
								System.out.println("Valor de factura con descuento: "+r[i].calcularTotalPagarVenta(cantV, true));
								System.out.println("Valor de factura sin descuento: "+r[i].calcularTotalPagarVenta(cantV, false));
							}
							else
								System.out.println("Unidades insuficientes para la venta");
						}
					}
					
				}
				if (tipo == 2) {
					for (int i = 0; i < c.length; i++) {
						if (c[i].getCodigo().equals(codigoP)) {
							if (cantV <= c[i].getCantidadB() ) {
								c[i].setCantidadB(c[i].getCantidadB() - cantV);
								System.out.println("Valor de factura con descuento: "+c[i].calcularTotalPagarVenta(cantV, true));
								System.out.println("Valor de factura sin descuento: "+c[i].calcularTotalPagarVenta(cantV, false));
							}
							else
								System.out.println("Unidades insuficientes para la venta");
						}
					}
					
				}
				break;
			}
			
		}while(op != 7);
		
		

	}

}

