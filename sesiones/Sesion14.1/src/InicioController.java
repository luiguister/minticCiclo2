import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

//import CalcController;

public class InicioController {
	private Inicio in;
	Connect conecta = new Connect();
	int codigo, precio_compra, precio_venta, cantidad_en_bodega, cantidad_min_req_en_bodega, cantidad_max_inventario;
	String nombre;
	
	InicioController(Inicio ini){
		in = ini; 
		ini.addMensaje(new Mensaje());
	}
	
	//view.addMultiplyListener(new MultiplyListener());
	
	class Mensaje implements ActionListener {
        public void actionPerformed(ActionEvent e) {
        	JOptionPane.showMessageDialog(null, "just do it");
            //String userInput = "";
        	/*Connection con = new Connect().conexion();
            try {
            	PreparedStatement ps = con.prepareStatement("INSERT INTO productos"
						+"(codigo, nombre, precio_compra, precio_venta, cantidad_en_bodega, cantidad_min_req_en_bodega, cantidad_max_inventario)"
						+"values"
						+"(?,?,?,?,?,?,?);");
            	ps.setInt(1, ini.getTfCodigo());
				ps.setString(2, ini.getTfNombre());
				ps.setInt(3, ini.getTfPCompra());
				ps.setInt(4, ini.getTfPVenta());
				ps.setInt(5, ini.getTfCantBod());
				ps.setInt(6, ini.getTfCantMin());
				ps.setInt(7, ini.getTfCantMax());
				int res = ps.executeUpdate();


            } catch (SQLException e1) {
    			// TODO Auto-generated catch block
    			e1.printStackTrace();
    		}*/
        }
    }
}
