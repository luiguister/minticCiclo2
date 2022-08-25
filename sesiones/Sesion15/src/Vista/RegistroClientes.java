package Vista;

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class RegistroClientes extends JPanel {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//JCheckBox M, F;
	JTextField cedula, nombre, apellido;
	JButton anadir;
	String seleccion;
	
	public String getSeleccion() {
		return seleccion;
	}

	public String getCedula() {
		return cedula.getText();
	}

	public void setCedula(JTextField cedula) {
		this.cedula = cedula;
	}

	public String getNombre() {
		return nombre.getText();
	}

	public void setNombre(JTextField nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido.getText();
	}

	public void setApellido(JTextField apellido) {
		this.apellido = apellido;
	}
	
	public void addRegistroClienteListener(ActionListener mal) {
    	anadir.addActionListener(mal);
    	/*m_cliente.setCedula(registroClientes.getCedula());
 		m_cliente.setNombre(registroClientes.getNombre());
 		m_cliente.setApellido(registroClientes.getApellido());
 		m_cliente.setGenero(registroClientes.getSeleccion());*/
     }
	

	RegistroClientes() {
        
		JRadioButton fButton = new JRadioButton("F");
		fButton.setMnemonic(KeyEvent.VK_B);
		fButton.setActionCommand("F");
		fButton.setSelected(true);
 
        JRadioButton mButton = new JRadioButton("M");
        mButton.setMnemonic(KeyEvent.VK_C);
        mButton.setActionCommand("M");
 
        //Group the radio buttons.
        ButtonGroup group = new ButtonGroup();
        group.add(fButton);
        group.add(mButton);
        
        seleccion = group.getSelection().getActionCommand();
        
        setLayout(new GridLayout(5,3));
        
        add(new JLabel("Identificación (C.O.)"));
        add(cedula = new JTextField());
        add(new JLabel(""));
        add(new JLabel("Nombre"));
        add(nombre = new JTextField());
        add(new JLabel(""));
        add(new JLabel("Apellido"));
        add(apellido = new JTextField());
        add(new JLabel(""));
        add(new JLabel("Genero (F/M)"));
       // add(F = new JCheckBox("F"));
        //add(M = new JCheckBox("M"));
        add(fButton);
        add(mButton);
        add(anadir = new JButton("Añadir"));
    }
}