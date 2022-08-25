package Controlador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Modelo.Producto;
import Persistencia.Connect;
import Vista.RegistrosVC;
import Vista.Formulario;
import Vista.Login;




public class ControladorFormulario {
    //... The Controller needs to interact with both the Model and View.
    private Producto m_producto;
    private Login  v_login;
    private Formulario v_formulario;
    private RegistrosVC v_registrosVC;
    private Connect c;

    //========================================================== constructor
    /** Constructor */
    public ControladorFormulario(Producto producto, Formulario formulario, RegistrosVC registroVC, Connect c) {
        m_producto = producto;
        v_formulario = formulario;
        v_registrosVC = registroVC;
        this.c = c;

        //... Add listeners to the view.
        formulario.addCrearListener(new CrearListener());
        formulario.addVerListener(new VerListener());
        formulario.addFormRegistrosListener(new FormRegistrosListener());
        //registroVenta.addRegistroVentaListener(new RegistroVenta());
    }
   
    class CrearListener implements ActionListener {
    	@Override
        public void actionPerformed(ActionEvent e) {
    		insertar();
    		
    		JOptionPane.showMessageDialog(v_login, "Registro creado");
        }
    	
    	public boolean insertar() {
    		Connection c2 = new Connect().conexion();
    		try {
				PreparedStatement ps = c2.prepareStatement("INSERT INTO productos" 
						+"(codigo, nombre, precio_compra, precio_venta, cantidad_en_bodega, cantidad_min_req_en_bodega, cantidad_max_inventario)" 
						+"VALUES" +"(?,?,?,?,?,?,?);");
				ps.setInt(1, v_formulario.getTfCodigo());
				ps.setString(2, v_formulario.getTfNombre());
				ps.setInt(3, v_formulario.getTfPCompra());
				ps.setInt(4, v_formulario.getTfPVenta());
				ps.setInt(5, v_formulario.getTfCantB());
				ps.setInt(6, v_formulario.getTfCantMin());
				ps.setInt(7, v_formulario.getTfCantMax());
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
    	@Override
    	public void actionPerformed(ActionEvent e) {
    		v_formulario.setProductos(ver());
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
    
    class FormRegistrosListener implements ActionListener{
    	@Override
    	public void actionPerformed(ActionEvent e) {
    		v_formulario.setVisible(false);
    		v_registrosVC.setVisible(true);
    	}
    }
}