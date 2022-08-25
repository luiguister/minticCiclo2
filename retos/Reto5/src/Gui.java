import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JLayeredPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;

public class Gui extends JFrame {

	private JPanel contentPane;
	protected JTextField tfNombreP;
	protected JTextField tfNombreM;
	protected JTextField tfCedulaP;
	protected JTextField tfCedulaM;
	protected JTable tablePacientes;
	protected JTextField tfCedulaM3;
	protected JTextField tfCedulaM2;
	protected JButton btnCrearPaciente;
	protected JButton btnCrearMedico;
	protected JButton btnListarP;
	protected JButton btnProcesar;
	protected JButton btnListarP2;
	protected JButton btnAsignar;
	protected JButton btnBuscarM;
	protected JButton btnListarAtender;
	protected JSpinner jsEdad;
	protected JComboBox<String> cbCiudad;
	protected JComboBox<String> cbEps;
	protected JComboBox<String> cbEnfermedad;
	protected JComboBox<String> cbEspecialidad;
	protected JTextArea textArea;
	protected JTable tablePacientes2;
	protected JLabel lbCedulaMBuscada;
	protected JLabel lbNombreMBuscada;
	protected JTextArea textArea_1;
	protected JPanel panel;
	
	/**
	 * Create the frame.
	 */
	public Gui() {
		setTitle("Citas medicas Mintic");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 562, 416);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 0, 526, 366);
		contentPane.add(tabbedPane);
		
		JLayeredPane layeredPane = new JLayeredPane();
		tabbedPane.addTab("Paciente", null, layeredPane, null);
		
		JLabel lblNewLabel = new JLabel("Datos del Paciente");
		lblNewLabel.setBounds(172, 11, 117, 14);
		layeredPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre");
		lblNewLabel_1.setBounds(23, 43, 63, 14);
		layeredPane.add(lblNewLabel_1);
		
		tfNombreP = new JTextField();
		tfNombreP.setBounds(23, 60, 196, 20);
		layeredPane.add(tfNombreP);
		tfNombreP.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Cedula");
		lblNewLabel_2.setBounds(254, 43, 46, 14);
		layeredPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Edad");
		lblNewLabel_3.setBounds(23, 91, 46, 14);
		layeredPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Ciudad");
		lblNewLabel_4.setBounds(135, 91, 46, 14);
		layeredPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("EPS");
		lblNewLabel_5.setBounds(254, 91, 46, 14);
		layeredPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Enfermedad");
		lblNewLabel_6.setBounds(23, 157, 86, 14);
		layeredPane.add(lblNewLabel_6);
		
		tfCedulaP = new JTextField();
		
		tfCedulaP.setBounds(253, 60, 86, 20);
		layeredPane.add(tfCedulaP);
		tfCedulaP.setColumns(10);
		
		cbCiudad = new JComboBox<String>();
		cbCiudad.setBounds(135, 110, 80, 22);
		layeredPane.add(cbCiudad);
		
		cbEps = new JComboBox<String>();
		cbEps.setBounds(253, 116, 86, 22);
		layeredPane.add(cbEps);
		
		jsEdad = new JSpinner(new SpinnerNumberModel(21,21, 130,1));
		jsEdad.setBounds(23, 111, 53, 20);
		layeredPane.add(jsEdad);
		
		cbEnfermedad = new JComboBox<String>();
		cbEnfermedad.setBounds(23, 176, 108, 22);
		layeredPane.add(cbEnfermedad);
		
		btnCrearPaciente = new JButton("Crear");
		
		btnCrearPaciente.setBounds(200, 207, 89, 23);
		layeredPane.add(btnCrearPaciente);
		
		JLayeredPane layeredPane_1 = new JLayeredPane();
		tabbedPane.addTab("Medico", null, layeredPane_1, null);
		
		JLabel lblNewLabel_1_1 = new JLabel("Nombre");
		lblNewLabel_1_1.setBounds(21, 55, 63, 14);
		layeredPane_1.add(lblNewLabel_1_1);
		
		tfNombreM = new JTextField();
		tfNombreM.setColumns(10);
		tfNombreM.setBounds(21, 79, 175, 20);
		layeredPane_1.add(tfNombreM);
		
		JLabel lblNewLabel_2_1 = new JLabel("Cedula");
		lblNewLabel_2_1.setBounds(21, 110, 63, 14);
		layeredPane_1.add(lblNewLabel_2_1);
		
		tfCedulaM = new JTextField();
		
		tfCedulaM.setColumns(10);
		tfCedulaM.setBounds(21, 135, 86, 20);
		layeredPane_1.add(tfCedulaM);
		
		JLabel lblNewLabel_7 = new JLabel("Especialidad");
		lblNewLabel_7.setBounds(21, 166, 98, 14);
		layeredPane_1.add(lblNewLabel_7);
		
		cbEspecialidad = new JComboBox<String>();
		cbEspecialidad.setBounds(21, 191, 133, 22);
		layeredPane_1.add(cbEspecialidad);
		
		btnCrearMedico = new JButton("Crear");
		
		btnCrearMedico.setBounds(21, 238, 89, 23);
		layeredPane_1.add(btnCrearMedico);
		
		JLabel lblNewLabel_8 = new JLabel("Datos del Medico");
		lblNewLabel_8.setBounds(155, 11, 138, 14);
		layeredPane_1.add(lblNewLabel_8);
		
		
		
		JLayeredPane layeredPane_2 = new JLayeredPane();
		tabbedPane.addTab("Clasificacion", null, layeredPane_2, null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 30, 501, 84);
		layeredPane_2.add(scrollPane);
		
		tablePacientes = new JTable();
		scrollPane.setViewportView(tablePacientes);
		
		tablePacientes.setModel(new DefaultTableModel(
			new Object[][] {},new String[] {"Nombre", "Cedula", "Edad", "Ciudad", "EPS", "Enfermedad"}) {
				boolean[] columnEditables = new boolean[] {false, false, false, false, false, false};
				
				public boolean isCellEditable(int row, int column) {
					return columnEditables[column];
				}
			});
				
		JLabel lblNewLabel_9 = new JLabel("Listado de Pacientes");
		lblNewLabel_9.setBounds(147, 11, 166, 14);
		layeredPane_2.add(lblNewLabel_9);
		
		btnProcesar = new JButton("Procesar");
		
		btnProcesar.setBounds(10, 123, 89, 23);
		layeredPane_2.add(btnProcesar);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(20, 157, 389, 101);
		layeredPane_2.add(scrollPane_1);
		
		textArea = new JTextArea();
		scrollPane_1.setViewportView(textArea);
		
		JLabel lblNewLabel_11 = new JLabel("Pacientes por edad y ciudad con mas pacientes");
		lblNewLabel_11.setBounds(109, 127, 300, 14);
		layeredPane_2.add(lblNewLabel_11);
		
		btnListarP = new JButton("Listar");
		
		btnListarP.setBounds(10, 7, 89, 23);
		layeredPane_2.add(btnListarP);
		
		JLayeredPane layeredPane_4 = new JLayeredPane();
		tabbedPane.addTab("Asignaci\u00F3n", null, layeredPane_4, null);
		
		JLabel lblNewLabel_12 = new JLabel("Asignaci\u00F3n de medico a paciente");
		lblNewLabel_12.setBounds(10, 11, 305, 14);
		layeredPane_4.add(lblNewLabel_12);
		
		JLabel lblNewLabel_13 = new JLabel("Cedula del medico");
		lblNewLabel_13.setBounds(10, 42, 121, 14);
		layeredPane_4.add(lblNewLabel_13);
		
		tfCedulaM2 = new JTextField();
		
		tfCedulaM2.setBounds(141, 36, 86, 20);
		layeredPane_4.add(tfCedulaM2);
		tfCedulaM2.setColumns(10);
		
		btnAsignar = new JButton("Asignar");
		
		btnAsignar.setBounds(10, 294, 89, 23);
		layeredPane_4.add(btnAsignar);
		
		JScrollPane scrollPane_4 = new JScrollPane();
		scrollPane_4.setBounds(10, 176, 380, 107);
		layeredPane_4.add(scrollPane_4);
		
		tablePacientes2 = new JTable();
		scrollPane_4.setViewportView(tablePacientes2);
		tablePacientes2.setModel(new DefaultTableModel(
			new Object[][] {}, new String[] {"Cedula", "Nombre", "Seleccionar"}
		) {
			Class[] columnTypes = new Class[] { Object.class, Object.class, Boolean.class };
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		
		btnListarP2 = new JButton("Listar Pacientes disponibles");
		
		
		btnListarP2.setBounds(10, 142, 227, 23);
		layeredPane_4.add(btnListarP2);
		
		btnBuscarM = new JButton("Buscar");
		
		btnBuscarM.setBounds(237, 36, 89, 23);
		layeredPane_4.add(btnBuscarM);
		
		panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Resultado de busqueda", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(6, 67, 368, 59);
		layeredPane_4.add(panel);
		panel.setLayout(null);
		
		lbCedulaMBuscada = new JLabel("");
		lbCedulaMBuscada.setBounds(6, 16, 189, 14);
		panel.add(lbCedulaMBuscada);
		lbCedulaMBuscada.setForeground(Color.BLUE);
		
		lbNombreMBuscada = new JLabel("");
		lbNombreMBuscada.setBounds(6, 34, 189, 14);
		panel.add(lbNombreMBuscada);
		lbNombreMBuscada.setForeground(Color.BLUE);
		lbNombreMBuscada.setBackground(Color.LIGHT_GRAY);
		
		String cities[] = new String[]{"Cali","Bogotá","Medellin", "Barranquilla", "Cali", "Cartagena", "Monteria", "Cucuta"};
		for (String string : cities) 
			cbCiudad.addItem(string);
		String eps[] = new String[]{"Sura","Mutual Ser","Coomeva", "Compensar", "Colsubsidio", "Salud Vida", "Colsanitas", "Sanitas"};
		for (String string : eps) 
			cbEps.addItem(string);
		String ilness[] = new String[]{"Hipertension","Diabetes","EPOC", "Artritis", "Obesidad", "Asma", "Bronquitis"};
		for (String string : ilness) 
			cbEnfermedad.addItem(string);
		
		String esp[] = new String[]{"Neurologo","Nutricionista","Ortopeda", "Cardiologo", "Optometra", "Ginecologo", "Endocrinologo"};
		for (String string : esp) 
			cbEspecialidad.addItem(string);
		
		JLayeredPane layeredPane_3 = new JLayeredPane();
		tabbedPane.addTab("Pacientes a Atender", null, layeredPane_3, null);
		
		JLabel lblNewLabel_10 = new JLabel("Cedula del medico");
		lblNewLabel_10.setBounds(10, 26, 141, 14);
		layeredPane_3.add(lblNewLabel_10);
		
		btnListarAtender = new JButton("Listar");
		
		btnListarAtender.setBounds(10, 82, 89, 23);
		layeredPane_3.add(btnListarAtender);
		
		tfCedulaM3 = new JTextField();
		
		tfCedulaM3.setBounds(10, 51, 141, 20);
		layeredPane_3.add(tfCedulaM3);
		tfCedulaM3.setColumns(10);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(168, 29, 330, 197);
		layeredPane_3.add(scrollPane_2);
		
		textArea_1 = new JTextArea();
		scrollPane_2.setViewportView(textArea_1);
		
		JLabel lblNewLabel_14 = new JLabel("Listado de pacientes");
		scrollPane_2.setColumnHeaderView(lblNewLabel_14);
		
	}
}
