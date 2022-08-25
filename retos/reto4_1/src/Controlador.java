import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Controlador extends Gui{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<PacienteModel> apm = new ArrayList<PacienteModel>();
	
	public Controlador() {
		super();
		crear();
		
		/*if (btnListar!=null) {
			obtenerMatriz();
		}
		if (btnProcesar!=null) {
			procesar();
		}
		if (btnListar!=null) {
			obtenerPacientes();
		}*/
		
		if(btnBuscar!=null) {
			buscar();
		}
		
	}
	
	private void crear() {
		btnCrear.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//PacienteModel pm = new PacienteModel();
				
				Connection cone = new Connect().conexion();
				try {
					PreparedStatement ps = cone.prepareStatement("INSERT INTO paciente" 
							+"(nombre, cedula, edad, ciudad, eps, enfermedad)" 
							+"VALUES" +"(?,?,?,?,?,?);");
					ps.setString(1,tfNombre.getText());
					ps.setInt(2,Integer.parseInt(tfCedula.getText()));
					ps.setInt(3, Integer.parseInt(jsEdad.getValue().toString()));
					ps.setString(4, cbCiudad.getSelectedItem().toString());
					ps.setString(5, cbEps.getSelectedItem().toString());
					ps.setString(6, cbEnfermedad.getSelectedItem().toString());
					
					int res = ps.executeUpdate();
					if (res == 1) 
						JOptionPane.showMessageDialog(rootPane, "Paciente Creado"); //return true; 
					else
						JOptionPane.showMessageDialog(rootPane, "Paciente No Creado");
				} catch (SQLException e1) {
					e1.printStackTrace();
					
				}
			}
		});
		numero(tfCedula);
	}
	
	
	private String validaRegistros(JTextField tf1, JTextField tf2, ArrayList<PacienteModel> a) {
		if (tf1.getText().isEmpty() || tf2.getText().isEmpty()) 
			return "Se deben diligenciar todos los campos";
		else if(!a.isEmpty()){
			for (int i = 0; i < apm.size(); i++) {
				if (a.get(i).getCedula() == Integer.parseInt(tf2.getText()))
					return "Esta cedula ya se encuentra registrada";
			}
		}
		return "next";
	}
	
	/*private void obtenerMatriz(){
		btnListar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (apm.isEmpty()) 
					JOptionPane.showMessageDialog(null, "No hay pacientes registrados");
				else {
					Object datos[][] = new Object[apm.size()][6];
			    	for (int i = 0; i < apm.size(); i++) {
						datos[i][0] = apm.get(i).getNombre()+"";
						datos[i][1] = apm.get(i).getCedula()+"";
						datos[i][2] = apm.get(i).getEdad()+"";
						datos[i][3] = apm.get(i).getCiudad()+"";
						datos[i][4] = apm.get(i).getEps()+"";
						datos[i][5] = apm.get(i).getEnfermedad()+"";
					}
			    	DefaultTableModel model = (DefaultTableModel)tablePacientes.getModel();
			    	model.getDataVector().removeAllElements();
			    	model.fireTableDataChanged();
			    	
			    	model = (DefaultTableModel)tablePacientes.getModel();
			    	for (Object[] d : datos) 
			    		model.addRow(d);
				}
			}
		});
    }*/
	
	/*private void procesar() {
		btnProcesar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (apm.isEmpty()) 
					JOptionPane.showMessageDialog(null, "No hay pacientes registrados");
				else {
					ArrayList<String> ciudades = new ArrayList<String>();
					for (int i = 0; i < apm.size(); i++) {
						ciudades.add(apm.get(i).getCiudad());
					}
					Set<String> s = new LinkedHashSet<String>(ciudades);
					ciudades.clear();
					ciudades.addAll(s);
					int max = 0;
				    String repetido = null;
					for (int i = 0; i < ciudades.size(); i++) {
						int cont = 0;
						for (int j = 0; j < apm.size(); j++) {
							if(ciudades.get(i).equals(apm.get(j).getCiudad())) 
								cont++;
						}
						if(cont > max) {
							max = cont;
							repetido = ciudades.get(i); 
						}
					}
					String texto = "";
					texto += repetido+"\n";
					for (int i = 0; i < apm.size(); i++) {
						texto += apm.get(i).getCedula()+" "+apm.get(i).clasificarEdad(apm.get(i).getEdad())+"\n";
					}
					textArea.setText(texto);
				}
			}
		});
	}*/
	
	private void eliminar() {
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
	}
	
	
	
	/*private void obtenerPacientes() {
		btnListarP2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (apm.isEmpty() || amm.isEmpty()) {
					JOptionPane.showMessageDialog(null, "No hay pacientes o medicos registrados");
				}
				else {
					Object datos[][] = new Object[apm.size()][2];
			    	for (int i = 0; i < apm.size(); i++) {
						datos[i][0] = apm.get(i).getNombre()+"";
						datos[i][1] = apm.get(i).getCedula()+"";
					}
			    	
			    	DefaultTableModel model = (DefaultTableModel)tablePacientes2.getModel();
			    	model.getDataVector().removeAllElements();
			    	model.fireTableDataChanged();
			    	
			    	model = (DefaultTableModel)tablePacientes2.getModel();
			    	for (Object[] d : datos) 
			    		model.addRow(d);
				}
			}
		});
	}*/
	
	private void buscar() {
		numero(tfCedulaBuscar);
		btnBuscar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (validar(tfCedulaBuscar)) 
					System.out.println("encontrado");
				else
					System.out.println("no encontrado");
				
				
			}
		});
	}
	
	private boolean validar(JTextField tf) {
		if (tf.getText().equals(""))
			return false;
		else {
			try {
				Connection cone = new Connect().conexion();
				PreparedStatement ps; 
				ps = cone.prepareStatement("select * from paciente where cedula = ?");
				ps.setString(1, tf.getText());
				ResultSet myRs= ps.executeQuery();
				while (myRs.next()) {
					tfNombreB.setText(myRs.getString("nombre"));
					tfCedulaB.setText(myRs.getString("cedula"));
					tfEdadB.setText(myRs.getString("edad"));
					tfCiudadB.setText(myRs.getString("ciudad"));
					tfEpsB.setText(myRs.getString("eps"));
					tfEnfermedadB.setText(myRs.getString("enfermedad"));
		            String Name = myRs.getString("nombre");
	            int cedula = myRs.getInt("cedula");
	            int edad = myRs.getInt("edad");
	            String ciudad = myRs.getString("ciudad");
	            String eps = myRs.getString("eps");
	            String enfermedad = myRs.getString("enfermedad");
	            System.out.println(Name + " " + cedula+ " "+edad+ " "+ciudad+ " "+eps+ " "+enfermedad);
				}
				cone.close();
			} catch(SQLException ex){
				//setTitle(ex.toString());
			}
		}
		return true;
	}
	
	
	
	private void numero(JTextField x) {
		x.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!Character.isDigit(c)) {
					getToolkit().beep();
					e.consume();
					JOptionPane.showMessageDialog(rootPane, "ingresar solo numeros");
				}
			}
		});
	}
		
}
