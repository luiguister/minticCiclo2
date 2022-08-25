package ej3Java;

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Producto p = new Producto();
		int cod;
		double precio;
		int cant;
		int cantMin;
		
		System.out.println("Digite codigo del producto: ");
		cod = sc.nextInt();
		
		System.out.println("Digite precio del producto: ");
		precio = sc.nextDouble();
		
		System.out.println("Digite cantidad en bodega: ");
		cant = sc.nextInt();
		
		System.out.println("Digite cantidad minima requerida: ");
		cantMin = sc.nextInt();
		
		if(p.solicitar(cant, cantMin))
			System.out.println("Debe solicitar pedido al proveedor");
		else
			System.out.println("NO debe solicitar pedido al proveedor");
			
		
	}

}
