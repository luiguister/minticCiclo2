package Persistencia;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {
	
	Connection c;
		public Connection conexion() {
			
			try { // Cargar driver de Class.forName("org.sqlite.JDBC");
				c = DriverManager.getConnection("jdbc:sqlite:"+System.getProperty("user.dir")+"/pacientes.db");
				//rs.close(); // Cerrar ResultSet
				///st.close(); // Cerrar Statement
				
				System.out.println("Conectado");
				
				} catch (SQLException e) {
					e.printStackTrace();
				}
			return c;
		}
}
