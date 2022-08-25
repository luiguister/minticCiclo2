package Vista;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

import Controlador.ControladorTabs;

public class ProcesarDatos extends JPanel {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JButton procesar;
	JTextArea proceso;
	ArrayList<ProcesarDatos> datos = new ArrayList<ProcesarDatos>();
	JScrollPane scrollPane;
	private String nombre, ciudad, eps, enfermedad;
	private int cedula, edad;
	
	private ControladorTabs ct;
	private RegistroPaciente rp;
    
    public ProcesarDatos(String nombre, int cedula, int edad, String ciudad, String eps, String enfermedad) {
		super();
		this.nombre = nombre;
		this.ciudad = ciudad;
		this.eps = eps;
		this.enfermedad = enfermedad;
		this.cedula = cedula;
		this.edad = edad;
		
	}
    
    public ProcesarDatos() {
    	ct = new ControladorTabs(this);
    	construirTabla();


		
		GridLayout gl = new GridLayout(4,1);
        setLayout(gl);
        add(new JLabel("Listado de pacientes", SwingConstants.CENTER));
      //Add the scroll pane to this panel.
        add(scrollPane);
        add(procesar = new JButton("Procesar"));
        add(proceso = new JTextArea(400, 60));
        
    }
    
    public ArrayList<ProcesarDatos> getDatos(){
    	return datos;
    }
    
    public Object[][] obtenerMatriz(){
    	Object datos2[][] = new Object[ct.ver().size()][6];
    	for (int i = 0; i < ct.ver().size(); i++) {
			datos2[i][0] = ct.ver().get(i).getNombre()+"";
			datos2[i][1] = ct.ver().get(i).getCedula()+"";
			datos2[i][2] = ct.ver().get(i).getEdad()+"";
			datos2[i][3] = ct.ver().get(i).getCiudad()+"";
			datos2[i][4] = ct.ver().get(i).getEps()+"";
			datos2[i][5] = ct.ver().get(i).getEnfermedad()+"";
		}
    	return datos2;
    }
    public void construirTabla() {
    	Object datos3[][] = new Object[ct.ver().size()][5]; 
    	datos3 = obtenerMatriz();
    	
		String[] columnNames = {"Nombre","Cedula","Edad","Ciudad","EPS","Enfermedad diagnosticada"};
		
		//final
		JTable table = new JTable(datos3, columnNames);
	    
		table.setPreferredScrollableViewportSize(new Dimension(500, 70));
		table.setFillsViewportHeight(true);
		
		//Create the scroll pane and add the table to it.
		scrollPane = new JScrollPane(table);    
		}
    
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	public String getEps() {
		return eps;
	}
	public void setEps(String eps) {
		this.eps = eps;
	}
	public String getEnfermedad() {
		return enfermedad;
	}
	public void setEnfermedad(String enfermedad) {
		this.enfermedad = enfermedad;
	}
	public int getCedula() {
		return cedula;
	}
	public void setCedula(int cedula) {
		this.cedula = cedula;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
}
