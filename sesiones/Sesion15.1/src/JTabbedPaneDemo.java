import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class TabbedPane extends JFrame {
    JTabbedPane tabs;
    CoursePanel cource;
    SelectCoursePanel selectCourse;

    TabbedPane() {
        super("Tabbed Pane Example");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Setting the JTabbedPane Position and Layout as Wrap
        tabs = new JTabbedPane(JTabbedPane.TOP, JTabbedPane.WRAP_TAB_LAYOUT);

        cource = new CoursePanel();
        selectCourse = new SelectCoursePanel();
        // Adding user defined pannels to JTabbedPane
        tabs.addTab("Cources", cource);
        tabs.addTab("Select Course", selectCourse);
        
        // Adding JPanels to JTabbedPane
        tabs.addTab("Comment", new JTextArea(10, 40));

        getContentPane().add(tabs);
    }
}

/*Creating CoursePanel by extending JPanel*/
class CoursePanel extends JPanel {
    JButton registrar;
    JComboBox<String> productos, clientes;

    CoursePanel() {
    	
    	productos = new JComboBox<String>();
		String prods[] = new String[]{"prod1","prod2","prod3"};
		for (String string : prods) 
			productos.addItem(string);
		
		clientes = new JComboBox<String>();
		String clients[] = new String[]{"client1","client2","client3"};
		for (String string : clients) 
			clientes.addItem(string);
		
        registrar = new JButton("Registrar");
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
        add(registrar);
        
    }
}
/*Creating SelectCoursePanel by extending JPanel*/
class SelectCoursePanel extends JPanel {
    JCheckBox java, swing, hibernate;

    SelectCoursePanel() {
        java = new JCheckBox("Java");
        swing = new JCheckBox("Spring");
        hibernate = new JCheckBox("Hibernate");

        setLayout(new FlowLayout());
        add(java);
        add(swing);
        add(hibernate);
    }
}

class JTabbedPaneDemo {
    public static void main(String args[]) throws Exception {
        TabbedPane frame = new TabbedPane();
        frame.setSize(400, 400);
        frame.setVisible(true);
    }
}