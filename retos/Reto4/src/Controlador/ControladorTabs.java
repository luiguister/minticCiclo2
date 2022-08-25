package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Persistencia.Connect;
import Vista.ProcesarDatos;
import Vista.RegistroPaciente;

public class ControladorTabs {
	private RegistroPaciente v_registroPaciente;
	private ProcesarDatos v_procesarDatos;
	
	public ControladorTabs(RegistroPaciente registroPaciente) {
		v_registroPaciente = registroPaciente;
		
		registroPaciente.addRegistroPacienteListener(new RegistroPacienteListener());
	}

	public ControladorTabs(ProcesarDatos procesarDatos) {
		v_procesarDatos = procesarDatos;
		
	}
	
	public ArrayList<ProcesarDatos> ver() {
    	Connection c2 = new Connect().conexion();
    	ArrayList<ProcesarDatos> lista = new ArrayList<ProcesarDatos>();
    	try {
			PreparedStatement ps = c2.prepareStatement("SELECT * FROM paciente");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				String texto = rs.getString(1)+" - "+String.valueOf(rs.getInt(2))+" - "+String.valueOf(rs.getInt(3))+" - "+
								rs.getString(4)+" - "+rs.getString(5)+" - "+rs.getString(6);
				
				ProcesarDatos v_procesarDatos = new ProcesarDatos(rs.getString(1), rs.getInt(2), 
																	rs.getInt(3), rs.getString(4), 
																	rs.getString(5), rs.getString(6));
				lista.add(v_procesarDatos);
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
    	return lista;
    }
		
	class RegistroPacienteListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			registrarPaciente();
			JOptionPane.showMessageDialog(v_registroPaciente, "Paciente Registrado");
	    }
		
		public boolean registrarPaciente() {
			Connection c2 = new Connect().conexion();
			try {
				PreparedStatement ps = c2.prepareStatement("INSERT INTO paciente" 
						+"(nombre, cedula, edad, ciudad, eps, enfermedad)" 
						+"VALUES" +"(?,?,?,?,?,?);");
				ps.setString(1,v_registroPaciente.getTfNombre());
				ps.setInt(2,v_registroPaciente.getTfCedula());
				ps.setInt(3, v_registroPaciente.getJsEdad());
				ps.setString(4, v_registroPaciente.getCiudades());
				ps.setString(5, v_registroPaciente.getEpss());
				ps.setString(6, v_registroPaciente.getEnfermedades());
				
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
	
	/*class ListarPacientesListener implements ActionListener{
		@Override
    	public void actionPerformed(ActionEvent e) {
			//v_procesarDatos.SetDatos(ver()); //setDatos(ver());
    	}
    }*/
    
    
	
}


