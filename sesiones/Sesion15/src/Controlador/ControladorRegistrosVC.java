package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.sql.Connection;

import javax.swing.JOptionPane;

import Modelo.Cliente;
import Vista.RegistroClientes;
//import Persistencia.Connect;
import Vista.RegistrosVC;

public class ControladorRegistrosVC {

	private RegistrosVC v_registrosVc;
	private RegistroClientes v_registroClientes;
	private Cliente m_cliente;
	
	public ControladorRegistrosVC(RegistrosVC registrosVC, Cliente cliente, RegistroClientes registroClientes) {
		v_registrosVc = registrosVC;
		m_cliente = cliente;
		v_registroClientes = registroClientes;
		
		v_registrosVc.addRegistroVentaListener(new RegistroVentaListener());
		v_registroClientes.addRegistroClienteListener(new RegistroClienteListener());
	}
	
	class RegistroVentaListener implements ActionListener{
		@Override
        public void actionPerformed(ActionEvent e) {
    		//insertarCliente();
        }
		
		public boolean insertarVenta() {
    		//Connection c2 = new Connect().conexion();
    		/*try {
    			
				PreparedStatement ps = c2.prepareStatement("INSERT INTO clientes" 
						+"(cedula, nombre, apellido, genero)" 
						+"VALUES" +"(?,?,?,?);");
				ps.setInt(1, m_cliente.get);
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
			}*/
    		//System.out.println(m_cliente.getCedula());
    		return true;
    	}
	}
	
	class RegistroClienteListener implements ActionListener{
		@Override
        public void actionPerformed(ActionEvent e) {
			JOptionPane.showMessageDialog(null, e+"boton registro clientes");
    		insertarCliente();
    		//System.out.println(v_registroClientes.getCedula());
    		JOptionPane.showMessageDialog(null, "boton añadir cliente");
        }
		
		public boolean insertarCliente() {
    		//Connection c2 = new Connect().conexion();
    		/*try {
    			
				PreparedStatement ps = c2.prepareStatement("INSERT INTO clientes" 
						+"(cedula, nombre, apellido, genero)" 
						+"VALUES" +"(?,?,?,?);");
				ps.setInt(1, m_cliente.get);
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
			}*/
    		return true;
    	}
	}
	
}
