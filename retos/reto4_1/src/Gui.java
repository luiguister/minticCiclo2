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

import javax.swing.SpinnerModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Gui extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	protected JTextField tfNombre;
	protected JTextField tfCedula;
	protected JTable tablePacientes;
	protected JTextField tfCedulaBuscar;
	protected JButton btnCrear;
	protected JButton btnListar;
	protected JButton btnProcesar;
	protected JButton btnEditar;
	protected JButton btnBuscar;
	protected JButton btnEliminar;
	protected JSpinner jsEdad;
	protected JTextField tfEdadB;
	protected JComboBox<String> cbCiudad;
	protected JComboBox<String> cbEps;
	protected JComboBox<String> cbEnfermedad;
	protected JTextArea textArea;
	protected JTextField tfNombreB;
	protected JTextField tfCedulaB;
	protected JTextField tfEpsB;
	protected JTextField tfCiudadB; 
	protected JTextField tfEnfermedadB; 
	
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
		tabbedPane.addTab("Ingresar", null, layeredPane, null);
		
		JLabel lblNewLabel = new JLabel("Datos del Paciente");
		lblNewLabel.setBounds(172, 11, 117, 14);
		layeredPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre");
		lblNewLabel_1.setBounds(23, 43, 63, 14);
		layeredPane.add(lblNewLabel_1);
		
		tfNombre = new JTextField();
		tfNombre.setBounds(23, 60, 196, 20);
		layeredPane.add(tfNombre);
		tfNombre.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Cedula");
		lblNewLabel_2.setBounds(254, 43, 46, 14);
		layeredPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Edad");
		lblNewLabel_3.setBounds(23, 91, 46, 14);
		layeredPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Ciudad");
		lblNewLabel_4.setBounds(254, 91, 46, 14);
		layeredPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("EPS");
		lblNewLabel_5.setBounds(23, 142, 46, 14);
		layeredPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Enfermedad");
		lblNewLabel_6.setBounds(254, 142, 86, 14);
		layeredPane.add(lblNewLabel_6);
		
		tfCedula = new JTextField();
		
		tfCedula.setBounds(253, 60, 86, 20);
		layeredPane.add(tfCedula);
		tfCedula.setColumns(10);
		
		cbCiudad = new JComboBox<String>();
		cbCiudad.setBounds(254, 110, 80, 22);
		layeredPane.add(cbCiudad);
		
		cbEps = new JComboBox<String>();
		cbEps.setBounds(20, 167, 86, 22);
		layeredPane.add(cbEps);
		
		jsEdad = new JSpinner(new SpinnerNumberModel(21,21, 130,1));
		jsEdad.setBounds(23, 111, 53, 20);
		layeredPane.add(jsEdad);
		
		cbEnfermedad = new JComboBox<String>();
		cbEnfermedad.setBounds(254, 167, 108, 22);
		layeredPane.add(cbEnfermedad);
		
		btnCrear = new JButton("Crear");
		
		btnCrear.setBounds(145, 225, 89, 23);
		layeredPane.add(btnCrear);
		
		
		
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
		
		btnListar = new JButton("Listar");
		
		btnListar.setBounds(10, 7, 89, 23);
		layeredPane_2.add(btnListar);
		
		JLayeredPane layeredPane_4 = new JLayeredPane();
		tabbedPane.addTab("Editar_Eliminar", null, layeredPane_4, null);
		
		JLabel lblNewLabel_13 = new JLabel("Cedula del paciente");
		lblNewLabel_13.setBounds(10, 17, 121, 14);
		layeredPane_4.add(lblNewLabel_13);
		
		tfCedulaBuscar = new JTextField();
		
		tfCedulaBuscar.setBounds(141, 11, 86, 20);
		layeredPane_4.add(tfCedulaBuscar);
		tfCedulaBuscar.setColumns(10);
		
		btnEditar = new JButton("Editar");
		
		btnEditar.setBounds(344, 102, 89, 23);
		layeredPane_4.add(btnEditar);
		
		btnBuscar = new JButton("Buscar");
		
		
		btnBuscar.setBounds(237, 11, 89, 23);
		layeredPane_4.add(btnBuscar);
		
		btnEliminar = new JButton("Eliminar");
		
		btnEliminar.setBounds(344, 148, 89, 23);
		layeredPane_4.add(btnEliminar);
		
		JLabel lblNewLabel_1_1 = new JLabel("Nombre");
		lblNewLabel_1_1.setBounds(20, 61, 63, 14);
		layeredPane_4.add(lblNewLabel_1_1);
		
		tfNombreB = new JTextField();
		tfNombreB.setColumns(10);
		tfNombreB.setBounds(112, 58, 196, 20);
		layeredPane_4.add(tfNombreB);
		
		JLabel lblNewLabel_2_1 = new JLabel("Cedula");
		lblNewLabel_2_1.setBounds(21, 92, 46, 14);
		layeredPane_4.add(lblNewLabel_2_1);
		
		tfCedulaB = new JTextField();
		tfCedulaB.setColumns(10);
		tfCedulaB.setBounds(112, 86, 86, 20);
		layeredPane_4.add(tfCedulaB);
		
		tfEpsB = new JTextField();
		tfEpsB.setBounds(112, 181, 86, 22);
		layeredPane_4.add(tfEpsB);
		
		tfCiudadB = new JTextField();
		tfCiudadB.setBounds(112, 148, 80, 22);
		layeredPane_4.add(tfCiudadB);
		
		tfEdadB = new JTextField();
		tfEdadB.setBounds(112, 117, 53, 20);
		layeredPane_4.add(tfEdadB);
		
		JLabel lblNewLabel_3_1 = new JLabel("Edad");
		lblNewLabel_3_1.setBounds(21, 120, 46, 14);
		layeredPane_4.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_6_1 = new JLabel("Enfermedad");
		lblNewLabel_6_1.setBounds(20, 214, 86, 14);
		layeredPane_4.add(lblNewLabel_6_1);
		
		tfEnfermedadB = new JTextField();
		tfEnfermedadB.setBounds(112, 214, 108, 22);
		layeredPane_4.add(tfEnfermedadB);
		
		JLabel lblNewLabel_7 = new JLabel("Ciudad");
		lblNewLabel_7.setBounds(20, 152, 46, 14);
		layeredPane_4.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("EPS");
		lblNewLabel_8.setBounds(20, 184, 46, 14);
		layeredPane_4.add(lblNewLabel_8);
		
		String cities[] = new String[]{"Cali","Bogotá","Medellin", "Barranquilla", "Cali", "Cartagena", "Monteria", "Cucuta"};
		for (String string : cities) 
			cbCiudad.addItem(string);
		String eps[] = new String[]{"Sura","Mutual Ser","Coomeva", "Compensar", "Colsubsidio", "Salud Vida", "Colsanitas", "Sanitas"};
		for (String string : eps) 
			cbEps.addItem(string);
		String ilness[] = new String[]{"Hipertension","Diabetes","EPOC", "Artritis", "Obesidad", "Asma", "Bronquitis"};
		for (String string : ilness) 
			cbEnfermedad.addItem(string);
		
	}
}
