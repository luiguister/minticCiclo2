import java.awt.Color;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;

public class reto3 extends JFrame implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel p1;
	private JPanel p2;
	private JTextField tfNombre;
	private JTextField tfId;
	private JSpinner jsEdad;
	private JComboBox<String> cbCiudad;
	private JComboBox<String> cbEps;
	private JComboBox<String> cbEnfermedad;
	private JTextArea jta;
	private JTextArea jta2;
	private JButton bEnter;
	private JButton bProcess;
	GridLayout gl = new GridLayout(7,1);
	GridLayout gl2 = new GridLayout(4,1);
	ArrayList<Paciente> vector = new ArrayList<Paciente>();
	ArrayList<String> ciudades = new ArrayList<String>();
	String texto = "";
	int cont=0;
	
	public reto3() throws HeadlessException{
		super();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(500, 500);
		setTitle("Datos de paciente");
		setLayout(null);
		setLocationRelativeTo(null);
		startComponents();
	}

	private void startComponents() {
		p1 = new JPanel();
		p1.setBounds(5,10,450,150);
		p1.setBackground(Color.GREEN);
		p1.setLayout(gl);
		p1.setVisible(true);
		
		p2 = new JPanel();
		p2.setBounds(10,150,450,300);
		p2.setLayout(gl2);
		p2.setVisible(true); 
		
		chargeComponentsP1();
		chargeComponentsP2();
		add(p1);
		add(p2);
	}

	private void chargeComponentsP1() {
		JLabel lNombre = new JLabel("Nombre");
		JLabel lId = new JLabel("Cedula");
		JLabel lEdad = new JLabel("Edad");
		JLabel lCiudad = new JLabel("Ciudad");
		JLabel lEps = new JLabel("Eps");
		JLabel lEnfermedad = new JLabel("Enfermedad Diagnosticada");
		
		tfNombre = new JTextField();
		tfId = new JTextField();
		jsEdad = new JSpinner(new SpinnerNumberModel(21,21, 130,1));
	    
		cbCiudad = new JComboBox<String>();
		String cities[] = new String[]{"Cali","Bogotá","Medellin", "Barranquilla", "Cali", "Cartagena", "Monteria", "Cucuta"};
		for (String string : cities) 
			cbCiudad.addItem(string);
		
		cbEps = new JComboBox<String>();
		String eps[] = new String[]{"Sura","Mutual Ser","Coomeva", "Compensar", "Colsubsidio", "Salud Vida", "Colsanitas", "sanitas"};
		for (String string : eps) 
			cbEps.addItem(string);
		
		cbEnfermedad = new JComboBox<String>();
		String ilness[] = new String[]{"Hipertension","Diabetes","EPOC", "Artritis", "Obesidad", "Asma", "Bronquitis"};
		for (String string : ilness) 
			cbEnfermedad.addItem(string);
		
		bEnter = new JButton("Ingresar");
		bProcess = new JButton("Procesar");
		
		p1.add(lNombre);
		p1.add(tfNombre);
		p1.add(lId);
		p1.add(tfId);
		p1.add(lEdad);
		p1.add(jsEdad);
		p1.add(lCiudad);
		p1.add(cbCiudad);
		p1.add(lEps);
		p1.add(cbEps);
		p1.add(lEnfermedad);
		p1.add(cbEnfermedad);
		p1.add(bEnter);
		p1.add(bProcess);
		bEnter.addActionListener(this);
		bProcess.addActionListener(this);
	}
	
	private void chargeComponentsP2() {
		JLabel entradas = new JLabel("Datos ingresados");
		JLabel salida = new JLabel("Salidas");
		jta = new JTextArea();
		jta2 = new JTextArea();;
		JScrollPane sc = new JScrollPane(jta);
		JScrollPane sc2 = new JScrollPane(jta2);
		p2.add(entradas);
		p2.add(sc);
		p2.add(salida);
		p2.add(sc2);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == bEnter) {
			if (tfNombre.getText().isEmpty() || tfId.getText().isEmpty() || jsEdad.getValue().equals(null) || 
					cbCiudad.getSelectedItem().equals(null) || cbEps.getSelectedItem().equals(null) || 
					cbEnfermedad.getSelectedItem().equals(null)){
				JOptionPane.showMessageDialog(null, "Debe llenar todos los campos");
			}
			else {
				Paciente p = new Paciente();
				p.setNombre(tfNombre.getText());
				p.setCedula(tfId.getText());
				p.setEdad(Integer.parseInt(jsEdad.getValue().toString()));
				p.setCiudad(cbCiudad.getSelectedItem().toString());
				ciudades.add(p.getCiudad());
				p.setEps(cbEps.getSelectedItem().toString());
				p.setEnfermedad(cbEnfermedad.getSelectedItem().toString());
				vector.add(p);
				cont++;
				texto += p.mostrar()+"\n";
				jta.setText(texto);
				tfNombre.setText("");
				tfId.setText("");
			}
		}
		if (e.getSource() == bProcess) {
			if (jta.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Debe ingresar al menos un paciente");
			}
			else {
				Paciente p = new Paciente();
				jta2.setText(p.procesar(vector, ciudades));
				System.out.println(jta2.getText());
			}
		}
	}
	
	public static void main(String[] args) {
		reto3 gui = new reto3();
		gui.setVisible(true);
	}
}
