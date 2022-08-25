import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Controller {
    //... The Controller needs to interact with both the Model and View.
    private Model m_model;
    private Model2 m_model2;
    private View  m_view;
    private View2 m_view2;
    private Connect c;

    //========================================================== constructor
    /** Constructor */
    Controller(Model model, Model2 model2, View view, View2 view2, Connect c) {
        m_model = model;
        m_model2 = model2;
        m_view  = view;
        m_view2 = view2;
        this.c = c;

        //... Add listeners to the view.
        view.addLoginListener(new LoginListener());
        view2.addCrearListener(new CrearListener());
        view2.addVerListener(new VerListener());
    }
    
    class LoginListener implements ActionListener {
    	@Override
        public void actionPerformed(ActionEvent e) {
        	if (m_view.getUsuario().equals("prueba")) 
        		JOptionPane.showMessageDialog(null, "Usuario"+m_model.getUsuario()+" no valido", "validacion", JOptionPane.ERROR_MESSAGE);
			else if (m_view.getContrasena().length() < 6) 
        		JOptionPane.showMessageDialog(null, "pswd debe tener mas de 6", "validacion", JOptionPane.ERROR_MESSAGE);
			else if (m_view.getUsuario().equals(m_view.getContrasena())) 
				JOptionPane.showMessageDialog(null, "Contraseña no debe ser igual a usuario", "validacion", JOptionPane.ERROR_MESSAGE);
			else 
				m_view2.setVisible(true);
        }
    }
   
    class CrearListener implements ActionListener {
    	@Override
        public void actionPerformed(ActionEvent e) {
    		insertar();
    		
    		JOptionPane.showMessageDialog(m_view, "Registro creado");
        }
    	
    	public boolean insertar() {
    		Connection c2 = new Connect().conexion();
    		try {
				PreparedStatement ps = c2.prepareStatement("INSERT INTO productos" 
						+"(codigo, nombre, precio_compra, precio_venta, cantidad_en_bodega, cantidad_min_req_en_bodega, cantidad_max_inventario)" 
						+"VALUES" +"(?,?,?,?,?,?,?);");
				ps.setInt(1, m_view2.getTfCodigo());
				ps.setString(2, m_view2.getTfNombre());
				ps.setInt(3, m_view2.getTfPCompra());
				ps.setInt(4, m_view2.getTfPVenta());
				ps.setInt(5, m_view2.getTfCantB());
				ps.setInt(6, m_view2.getTfCantMin());
				ps.setInt(7, m_view2.getTfCantMax());
				int res = ps.executeUpdate();
				if (res == 1) 
					return true;
				else
					return false;
			} catch (SQLException e1) {
				e1.printStackTrace();
				return false;
			}
    	}
    }
    class VerListener implements ActionListener{
    	public void actionPerformed(ActionEvent e) {
    		
    		m_view2.setProductos(ver());
    		
        }
    }
    
    public ArrayList<String> ver() {
    	Connection c2 = new Connect().conexion();
    	ArrayList<String> lista = new ArrayList<String>();
    	try {
			PreparedStatement ps = c2.prepareStatement("SELECT * FROM productos");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				String texto = String.valueOf(rs.getInt(1))+" - "+rs.getString(2)+" - "+String.valueOf(rs.getInt(3))+" - "+
								String.valueOf(rs.getInt(4))+" - "+String.valueOf(rs.getInt(5))+" - "+String.valueOf(rs.getInt(6))+" - "+
								String.valueOf(rs.getInt(7));
				
				lista.add(texto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
    	return lista;
    }
}