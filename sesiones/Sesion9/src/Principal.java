import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		var sc = new Scanner(System.in);
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
		boolean salir = false;
		do {
			System.out.println("1. consultar producto");
			System.out.println("2. verificar productos a pedir");
			System.out.println("3. calzado con mayor cantidad de unidades");
			System.out.println("4. ropa con mayor cantidad de unidades");
			System.out.println("5. modificar cantidad minima requerida en bodega");
			System.out.println("6. vender productos");
			System.out.println("7. salir");
			int op = Integer.parseInt(sc.nextLine());
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
			case 3:
			case 4:
			case 5:
			case 6:
			case 7:
			}
			
		}while(!salir);
		
		

	}

}
