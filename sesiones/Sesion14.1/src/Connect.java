import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Connect {
	
		public Connection conexion() {
			Connection c = null;
			try { // Cargar driver de Class.forName("org.sqlite.JDBC");
				c = DriverManager.getConnection("jdbc:sqlite:"+System.getProperty("user.dir") + "/almacen.db");
				System.out.println("conexion establecida");
				// Preparamos la consulta
				//PreparedStatement
				Statement st = c.createStatement();
				//ResultSet rs = st.executeQuery("SELECT * FROM primera_tabla");
				//RECORREMOS EL RESULTADO PARA VISUALIZAR CADA FILA
				/*while (rs.next()) {
					//System.out.println(result.getInt(1) + " " + result.getString(2) + " " + result.getString(3));
					System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3));
				}*/
				//rs.close(); // Cerrar ResultSet
				st.close(); // Cerrar Statement
				c.close(); // Cerrar conexion
				System.out.println("Conectado");
				} catch (SQLException e) {
					e.printStackTrace();
				}
			return c;
		}
		
}
