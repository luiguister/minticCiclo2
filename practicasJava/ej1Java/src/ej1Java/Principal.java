package ej1Java;

import java.util.Scanner;

public class Principal {
	
	public static void main(String[] args) {
		
		Conexion con = new Conexion();
		con.conectar();
		
		// TODO Auto-generated method stub
				Scanner sc = new Scanner(System.in);
		        // entrada de una cadena
		        //String name = sc.nextLine();
		        // entrada de un car�cter
		        //char gender = sc.next().charAt(0);
		        // Entrada de datos num�ricos
		        // byte, short y float
		        System.out.println("Digite cantidad en bodega: ");
		        int bodega = sc.nextInt();
		        System.out.println("Digite cantidad requerida: ");
		        int requerida = sc.nextInt();
		        //long mobileNo = sc.nextLong();
		        //double average = sc.nextDouble();
		        System.out.println(con.editar(requerida, bodega));
				con.listar();
				con.closeConnection();

	}
	
}