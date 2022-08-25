package Vista;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;

import Controlador.ControladorTabs;

public class RegistroPaciente extends JPanel {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ControladorTabs ct;
	private ProcesarDatos pd;
	
	private JButton registrar = new JButton("Registrar");
    JComboBox<String> ciudades, epss, enfermedades;
	JTextField tfNombre, tfCedula;
    JSpinner jsEdad;
    
    public RegistroPaciente() {
    	
    	//pd = new ProcesarDatos();
        //ct = new ControladorTabs(this, pd);
    	ct = new ControladorTabs(this);
    	
    	ciudades = new JComboBox<String>();
		String arrayCities[] = new String[]{"ciu1","ciu2","ciu3"};
		for (String string : arrayCities) 
			ciudades.addItem(string);
		
		epss = new JComboBox<String>();
		String arrayEps[] = new String[]{"eps1","eps2","eps3"};
		for (String string : arrayEps) 
			epss.addItem(string);
		
		enfermedades = new JComboBox<String>();
		String arraySicks[] = new String[]{"sick1","sick2","sick3"};
		for (String string : arraySicks) 
			enfermedades.addItem(string);
				
        setLayout(new GridLayout(6,3));

        add(new JLabel("Nombre"));
        add(new JLabel("Cedula"));
        add(new JLabel("Edad"));
        add(tfNombre = new JTextField());
        add(tfCedula = new JTextField());
        jsEdad = new JSpinner(new SpinnerNumberModel(21,21, 130,1));
        add(jsEdad);
        add(new JLabel("Ciudad"));
        add(new JLabel("EPS"));
        add(new JLabel("Enfermedad Diagnosticada"));
        add(ciudades);
        add(epss);
        add(enfermedades);
        
        
        add(registrar);
        add(new JLabel(""));
        add(new JLabel(""));
    }
    
    public String getCiudades() {
		return ciudades.getSelectedItem().toString();
	}
	public void setCiudades(JComboBox<String> ciudades) {
		this.ciudades = ciudades;
	}
	public String getEpss() {
		return epss.getSelectedItem().toString();
	}
	public void setEpss(JComboBox<String> epss) {
		this.epss = epss;
	}
	public String getEnfermedades() {
		return enfermedades.getSelectedItem().toString();
	}
	public void setEnfermedades(JComboBox<String> enfermedades) {
		this.enfermedades = enfermedades;
	}
	public String getTfNombre() {
		return tfNombre.getText();
	}
	public void setTfNombre(JTextField tfNombre) {
		this.tfNombre = tfNombre;
	}
	public int getTfCedula() {
		return Integer.parseInt(tfCedula.getText());
	}
	public void setTfCedula(JTextField tfCedula) {
		this.tfCedula = tfCedula;
	}
	public int getJsEdad() {
		return Integer.parseInt(jsEdad.getValue().toString());
	}
	public void setJsEdad(JSpinner jsEdad) {
		this.jsEdad = jsEdad;
	}
    
    public void addRegistroPacienteListener(ActionListener al) {
    	registrar.addActionListener(al);
    }
}