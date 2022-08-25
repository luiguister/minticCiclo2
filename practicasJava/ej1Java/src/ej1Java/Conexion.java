package ej1Java;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Conexion {

	Connection c = null;
	//String url = "C:\\Users\\luis.diaz\\Documents\\ej1Java\\db/mydatabase.db";
	String url = "C:\\Users\\luis.diaz\\eclipse-workspace\\ej1Java\\db/mydatabase.db";
	Statement st = null;
	
	void conectar() {
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:"+url);
			System.out.println("conexion exitosa");
			
		}catch(Exception e){
			System.out.println(e.getMessage().toString());
		}
		
	}
	public void listar() {
		try {
			st = c.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM products");
			while(rs.next()) {
				int id = rs.getInt("id");
				int cantidad = rs.getInt("cantidad");
				int bodega = rs.getInt("bodega");
				System.out.println(id + " " + cantidad + " " + bodega);
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	public String editar(int cant, int bod) {
		PreparedStatement ps = null;
		try {
			String sql = "UPDATE products set cantidad = ?, bodega = ? WHERE id = ?";
			ps = c.prepareStatement(sql);
			ps.setInt(1, cant);
			ps.setInt(2, bod);
			ps.setInt(3, 1);
			ps.execute();
			//System.out.println("datos actualizados");
		}catch(SQLException e) {
			System.out.println(e.getMessage().toString());
		}
		if(cant > bod) {
			return "Es necesario realizar el pedido al proveedor "+realizarPedido();
			
		}
			
		else
			if(bod - cant < 10)
				return "No es necesario realizar el pedido al proveedor, hace falta "+(bod-cant)+" unidades para realizar pedido, ALERTA GENERADA";
			else return "No es necesario realizar el pedido al proveedor, hace falta "+(bod-cant)+" unidades para realizar pedido";
		
			
	}
	public String realizarPedido() {
		Scanner sc = new Scanner(System.in);
        // entrada de una cadena
        //String name = sc.nextLine();
        // entrada de un car�cter
        //char gender = sc.next().charAt(0);
        // Entrada de datos num�ricos
        // byte, short y float
        int valorCaja = 0;
        System.out.println("Digite valor de compra: ");
        int valorComp = sc.nextInt();
        try {
			st = c.createStatement();
			ResultSet rs = st.executeQuery("SELECT valorCaja FROM products WHERE id = 1");
			while(rs.next()) {
				//int id = rs.getInt("id");
				//int cantidad = rs.getInt("cantidad");
				//int bodega = rs.getInt("bodega");
				valorCaja = rs.getInt("valorCaja");
				//System.out.println(id + " " + cantidad + " " + bodega);
				
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
        if(valorCaja >= valorComp)
			return "Es posible realizar el pedido "+valorCaja;
		else
			return "No es posible realizar el pedido"+valorCaja;
	}
	public void closeConnection() {
		try {
			c.close();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	/*public void executeQuery(String query) {
		try {
			this.st = c.createStatement();
			st.executeQuery(query);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}*/
}
