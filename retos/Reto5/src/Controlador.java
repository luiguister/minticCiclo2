import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map.Entry;
import java.util.Set;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Controlador extends Gui{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<PacienteModel> apm = new ArrayList<PacienteModel>();
	private ArrayList<MedicoModel> amm = new ArrayList<MedicoModel>();
	private HashMap<Integer, String> asignacion = new HashMap<Integer, String>();
	public int asignaciones = 0;
	
	public Controlador() {
		super();
		crearPaciente();
		crearMedico();
		if (btnListarP!=null) {
			obtenerMatriz();
		}
		if (btnProcesar!=null) {
			procesar();
		}
		if (btnListarP!=null) {
			obtenerPacientes();
		}
		if (btnAsignar!=null) {
			asignar();
		}
		if(btnBuscarM!=null) {
			buscarMedico();
		}
		if (btnListarAtender!=null) {
			atender();
		}
	}
	
	private void crearPaciente() {
		btnCrearPaciente.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				PacienteModel pm = new PacienteModel();
				
				if (validaRegistros(tfNombreP, tfCedulaP, apm).equals("next")) {
					pm.setNombre(tfNombreP.getText());
					try {
						pm.setCedula(Integer.parseInt(tfCedulaP.getText()));
					} catch (NumberFormatException e2) {
						e2.printStackTrace();
					}
					pm.setEdad(Integer.parseInt(jsEdad.getValue().toString()));
					pm.setCiudad(cbCiudad.getSelectedItem().toString());
					pm.setEps(cbEps.getSelectedItem().toString());
					pm.setEnfermedad(cbEnfermedad.getSelectedItem().toString());
					apm.add(pm);
					JOptionPane.showMessageDialog(null, "Paciente Creado");
				} else
					JOptionPane.showMessageDialog(rootPane, validaRegistros(tfNombreP, tfCedulaP, apm));
				tfNombreP.setText("");
				tfCedulaP.setText("");
			}
		});
		numero(tfCedulaP);
	}
	
	private void crearMedico() {
		numero(tfCedulaM);
		btnCrearMedico.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MedicoModel mm = new MedicoModel();
				
				if (validarRegistros(tfNombreM, tfCedulaM, amm).equals("next")) {
					mm.setNombre(tfNombreM.getText());
					try {
						mm.setCedula(Integer.parseInt(tfCedulaM.getText()));
					} catch (Exception e2) {
						e2.printStackTrace();
					}
					mm.setEspecialidad(cbEspecialidad.getSelectedItem().toString());
					amm.add(mm);
					JOptionPane.showMessageDialog(null, "Medico Creado");
				} else 
					JOptionPane.showMessageDialog(rootPane, validarRegistros(tfNombreM, tfCedulaM, amm));
				tfCedulaM.setText("");
				tfNombreM.setText("");
			}
		});
	}
	
	private String validarRegistros(JTextField tf1, JTextField tf2, ArrayList<MedicoModel> a) {
		if (tf1.getText().isEmpty() || tf2.getText().isEmpty()) 
			return "Se deben diligenciar todos los campos";
		else if(!a.isEmpty()){
			for (int i = 0; i < amm.size(); i++) {
				if (a.get(i).getCedula() == Integer.parseInt(tf2.getText()))
					return "Esta cedula ya se encuentra registrada";
			}
		}
		return "next";
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
	
	private void obtenerMatriz(){
		btnListarP.addActionListener(new ActionListener() {
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
    }
	
	private void procesar() {
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
	}
	private void asignar() {
		btnAsignar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				boolean flag3 = false;
				if (apm.isEmpty() || amm.isEmpty()) 
					JOptionPane.showMessageDialog(null, "No hay pacientes o medicos registrados");
				if(lbCedulaMBuscada.getText().equals(""))
					JOptionPane.showMessageDialog(null, "Debe buscar una cedula del medico a asignar");
				else if(seleccionados(2)){
					for (int i = 0; i < tablePacientes2.getRowCount(); i++) {
						if (tablePacientes2.getValueAt(i, 2) != null) {
							boolean sel = (boolean)tablePacientes2.getValueAt(i, 2);
							if(sel) {
								MedicoModel mm = new MedicoModel();
								mm.setCedula(Integer.parseInt(lbCedulaMBuscada.getText()));
								mm.setCedulaP(Integer.parseInt((String) tablePacientes2.getValueAt(i, 1)));
								boolean flag2 = false;
								if (!asignacion.isEmpty()) {
									for (Entry<Integer, String> tuple : asignacion.entrySet()) {
								        if (tuple.getValue().equals(mm.toString())) 
											flag2 = true;
									}
								}
								if (!flag2) {
									asignacion.put(asignaciones, mm.toString());
									asignaciones++;
									flag3 = true;
									tfCedulaM2.setText("");
								}
							}
						}
					}
					if (flag3) 
						JOptionPane.showMessageDialog(null, "Pacientes asignados a medicos");
					System.out.println("\n");
					System.out.println("start");
					for (Entry<Integer, String> entrada : asignacion.entrySet()) {
						System.out.println(entrada);
					}
					System.out.println("end");
					
				}else
					JOptionPane.showMessageDialog(null, "Debe seleccionar por lo menos un paciente");
			}
		});
	}
	
	public boolean seleccionados(int pos) {
		int cont = 0; boolean flag = true;
		for (int i = 0; i < tablePacientes2.getRowCount(); i++) {
			if(tablePacientes2.getValueAt(i, pos) != null) {
				boolean seleccion = (boolean)tablePacientes2.getValueAt(i, pos);
				if (seleccion) 
					cont++;
			}
		}
		if (cont==0) 
			flag = false;
		return flag;
	}
	
	private void obtenerPacientes() {
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
	}
	
	private void buscarMedico() {
		lbCedulaMBuscada.setText("");
		lbNombreMBuscada.setText("");
		numero(tfCedulaM2);
		btnBuscarM.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (validarMedico(tfCedulaM2).equals("next")) {
					for (int i = 0; i < amm.size(); i++) {
						if (amm.get(i).getCedula() == Integer.parseInt(tfCedulaM2.getText())) {
							lbCedulaMBuscada.setText(String.valueOf(amm.get(i).getCedula()));
							lbNombreMBuscada.setText(amm.get(i).getNombre());
						}
					}
				}
				else
					JOptionPane.showMessageDialog(null, validarMedico(tfCedulaM2));
			}
		});
	}
	
	private String validarMedico(JTextField tf) {
		boolean flag = false;
		if (amm.isEmpty()) 
			return "No hay medicos registrados";
		else if (tf.getText().equals(""))
			return "Debe digitar una cedula a buscar";
		else {
			for (int i = 0; i < amm.size(); i++) {
				if (amm.get(i).getCedula() == Integer.parseInt(tf.getText())) 
					flag = true;
				else if(!flag)
					return "Cedula de medico no encontrada";
			}
		}
		return "next";
	}
	
	private void atender() {
		btnListarAtender.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MedicoModel mm = new MedicoModel();
				ArrayList<Integer> cedulas = new ArrayList<Integer>();
								
				if (validarMedico(tfCedulaM3).equals("next")) {
					cedulas = mm.pacientes(asignacion, Integer.parseInt(tfCedulaM3.getText()));
					String texto = "";
					if (cedulas.size() == 0) {
						JOptionPane.showMessageDialog(rootPane, "El medico no tiene pacientes asociados");
					} else {
						for (int i = 0; i < apm.size(); i++) {
							for (int j = 0; j < cedulas.size(); j++) {
								if (apm.get(i).getCedula() == cedulas.get(j)) {
									if (texto.equals(null)) 
										texto = apm.get(i).toString()+"\n";
									else 
										texto += apm.get(i).toString()+"\n";
								}
							}
						}
						textArea_1.setText(texto);
						tfCedulaM3.setText("");
						for (Integer integer : cedulas) {
							System.out.println(integer);
						}
					}
				} else
					JOptionPane.showMessageDialog(rootPane, validarMedico(tfCedulaM3));
			}
		});
		numero(tfCedulaM3);
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
