package Vista;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class EditarEliminar extends JPanel {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
    JTextField tfCedulaBuscar, tfNombre, tfCedula, tfEdad, tfCiudad, tfEps, tfEnfermedad;
    JButton buscar, editar, eliminar;

    public EditarEliminar() {
    	
    	GridLayout gl = new GridLayout(6,3);
        setLayout(gl);

        add(new JLabel("Cedula del paciente"));
        add(tfCedulaBuscar = new JTextField());
        add(buscar = new JButton("Buscar"));
        add(new JLabel("Nombre"));
        add(new JLabel("Cedula"));
        add(new JLabel("Edad"));
        add(tfNombre = new JTextField());
        add(tfCedula = new JTextField());
        add(tfEdad = new JTextField());
        add(new JLabel("Ciudad"));
        add(new JLabel("EPS"));
        add(new JLabel("Enfermedad Diagnosticada"));
        add(tfCiudad = new JTextField());
        add(tfEps = new JTextField());
        add(tfEnfermedad = new JTextField());
        add(editar = new JButton("Editar"));
        add(eliminar = new JButton("Eliminar"));
        add(new JLabel(""));
    }
}