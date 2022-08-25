import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

class View extends JFrame {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//... Constants
    private static final String INITIAL_VALUE = "";

    //... Components
    private JTextField tfUsuario = new JTextField(10);
    private JPasswordField pswd = new JPasswordField(10);
    private JButton    btnIngresar = new JButton("Ingresar");
    GridLayout gl = new GridLayout(3,2);

    private Model m_model;

    //======================================================= constructor
    /** Constructor */
    View(Model model) {
        //... Set up the logic
        m_model = model;
        m_model.setUsuario(INITIAL_VALUE); 
        m_model.setContrasena(INITIAL_VALUE);
        
        //... Initialize components
        tfUsuario.setText(m_model.getUsuario());
        pswd.setText(m_model.getContrasena());
        
        //... Layout the components.      
        JPanel content = new JPanel();
        content.setLayout(gl);
        content.add(new JLabel("Usuario"));
        content.add(tfUsuario);
        content.add(new JLabel("Contrasena"));
        content.add(pswd);
        content.add(btnIngresar);
        
        //... finalize layout
        this.setContentPane(content);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setTitle("Ventana 1");
        // El evento de cerrar ventana deberia ser pasado al controller en ambiente de produccion pero esto es un ejemplo
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    void reset() {
    	pswd.setText(INITIAL_VALUE);
    	tfUsuario.setText(INITIAL_VALUE);
    }

    String getUsuario() {
        return tfUsuario.getText();
    }
    String getContrasena() {
        return String.valueOf(pswd.getPassword());
    }
    
    void setUsuario(String user) {
    	tfUsuario.setText(user);
    }
    	
    void setContrasena(String contra) {
    	pswd.setText(contra);
    }

    void showError(String errMessage) {
        JOptionPane.showMessageDialog(this, errMessage);
    }

    void addLoginListener(ActionListener mal) {
    	btnIngresar.addActionListener(mal);
    }
}