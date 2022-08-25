package Vista;
import javax.swing.*;

import Modelo.Cliente;
import Modelo.Venta;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
//import java.awt.event.*;

public class RegistrosVC extends JFrame {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final int INITIAL_VALUE2 = 0;
	private Venta m_venta;
	private Cliente m_cliente;
	JTabbedPane tabs;
    RegistroVentas registroVentas;
    RegistroClientes registroClientes;
    
    

     public RegistrosVC(Venta venta, Cliente cliente) {
        super();
        m_venta = venta;
        m_cliente = cliente;
        m_venta.setCantidad(INITIAL_VALUE2);
        // Setting the JTabbedPane Position and Layout as Wrap
        tabs = new JTabbedPane(JTabbedPane.TOP, JTabbedPane.WRAP_TAB_LAYOUT);

        registroVentas = new RegistroVentas();
        registroClientes = new RegistroClientes();
        // Adding user defined pannels to JTabbedPane
        tabs.addTab("Registro de ventas", registroVentas);
        tabs.addTab("Creacion de usuarios", registroClientes);
        
        // Adding JPanels to JTabbedPane
        tabs.addTab("Comment", new JTextArea(10, 40));

        getContentPane().add(tabs);
        
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //setVisible(true);
    }
     
     public JTabbedPane getTabs() {
 		return tabs;
 	}

 	public void setTabs(JTabbedPane tabs) {
 		this.tabs = tabs;
 	}

 	public RegistroVentas getRegistroVentas() {
 		return registroVentas;
 	}

 	public void setRegistroVentas(RegistroVentas rVentas) {
 		this.registroVentas = rVentas;
 	}

 	public RegistroClientes getRegistroClientes() {
 		return registroClientes;
 	}

 	public void setRegistroClientes(RegistroClientes RClientes) {
 		this.registroClientes = RClientes;
 		
 	}
 	
 	public void addRegistroVentaListener(ActionListener mal) {
    	registroVentas.registrar.addActionListener(mal);
    	
     }
 	
 	
     
}

/*Creating CoursePanel by extending JPanel*/
class RegistroVentas extends JPanel {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JButton registrar;
    JComboBox<String> productos, clientes;

    public RegistroVentas() {
    	
    	productos = new JComboBox<String>();
		String prods[] = new String[]{"prod1","prod2","prod3"};
		for (String string : prods) 
			productos.addItem(string);
		
		clientes = new JComboBox<String>();
		String clients[] = new String[]{"client1","client2","client3"};
		for (String string : clients) 
			clientes.addItem(string);
		
        JTextField cantidad = new JTextField();
        setLayout(new GridLayout(5,2));

        add(new JLabel("Nueva venta"));
        add(new JLabel(""));
        add(new JLabel("Producto: "));
        add(productos);
        add(new JLabel("Cliente: "));
        add(clientes);
        add(new JLabel("Cantidad: "));
        add(cantidad);
        add(registrar = new JButton("Registrar"));
    }
}
/*Creating SelectCoursePanel by extending JPanel*/


//class JTabbedPaneDemo {
    //public static void main(String args[]) throws Exception {
        //TabbedPane frame = new TabbedPane();
        //frame.setSize(400, 400);
        //frame.setVisible(true);
    //}
//}

