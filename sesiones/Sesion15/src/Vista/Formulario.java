package Vista;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Modelo.Producto;

public class Formulario extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//... Constants
    private static final String INITIAL_VALUE = "";
    private static final int INITIAL_VALUE2 = 0;

    //... Components
    private JButton jbnCrear = new JButton("Crear");
    private JButton jbnVer = new JButton("Ver");
    private JButton createSaleButton = new JButton("Registrar venta");
    private JTextArea productos = new JTextArea(4, 35);
    private Producto m_producto;
	private JTextField tfCodigo = new JTextField(15);
	private JTextField tfNombre = new JTextField(15);
	private JTextField tfPCompra = new JTextField(15);
	private JTextField tfPVenta = new JTextField(15);
	private JTextField tfCantB = new JTextField(15);
	private JTextField tfCantMin = new JTextField(15);
	private JTextField tfCantMax = new JTextField(15);
	GridLayout gl = new GridLayout(9,2);
	GridLayout gl2 = new GridLayout(2,1);
	
    //======================================================= constructor
    /** Constructor */
    public Formulario(Producto producto) {
    	super();
        //... Set up the logic
    	m_producto = producto;
    	m_producto.setCodigo(INITIAL_VALUE2);
    	m_producto.setNombre(INITIAL_VALUE);
    	m_producto.setP_compra(INITIAL_VALUE2);
    	m_producto.setP_venta(INITIAL_VALUE2);
    	m_producto.setCant_b(INITIAL_VALUE2);
    	m_producto.setCant_min(INITIAL_VALUE2);
    	m_producto.setCant_max(INITIAL_VALUE2);
    	
        
        //... Layout the components.
    	JPanel p = new JPanel();
        
    	JPanel pTitulo = new JPanel();
        pTitulo.add(new JLabel("Almacen"));
        
        JPanel content = new JPanel();
        content.setLayout(gl);
        content.add(new JLabel("Codigo"));
        content.add(tfCodigo);
        content.add(new JLabel("Nombre"));
        content.add(tfNombre);
        content.add(new JLabel("Precio Compra"));
        content.add(tfPCompra);
        content.add(new JLabel("Precio Venta"));
        content.add(tfPVenta);
        content.add(new JLabel("Cantidad en bodega"));
        content.add(tfCantB);
        content.add(new JLabel("Cantidad Minima"));
        content.add(tfCantMin);
        content.add(new JLabel("Cantidad Maxima"));
        content.add(tfCantMax);
        content.add(jbnCrear);
        content.add(jbnVer);
        content.add(createSaleButton);
        content.setBackground(Color.GREEN);
        
        JPanel pVer = new JPanel();
        pVer.setLayout(gl2);
        JScrollPane jsp  = new JScrollPane(productos);
        
        pVer.add(new JLabel("Datos Ingresados", SwingConstants.CENTER), BorderLayout.NORTH);
        pVer.add(jsp);
        pVer.setBackground(Color.CYAN);
        //... finalize layout
        p.setBackground(Color.YELLOW);
        p.add(pTitulo, BorderLayout.NORTH);
        p.add(content, BorderLayout.CENTER);
        p.add(pVer, BorderLayout.SOUTH);

        this.setContentPane(p);
        
        this.pack();
        this.setResizable(false);
        this.setSize(420, 450);
        //this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setTitle("Ventana 2");
        // El evento de cerrar ventana deberia ser pasado al controller en ambiente de produccion pero esto es un ejemplo 
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public JButton getJbnCrear() {
  		return jbnCrear;
  	}
  	
    public void addCrearListener(ActionListener mal) {
    	jbnCrear.addActionListener(mal);
    }
    public void addVerListener(ActionListener mal) {
    	jbnVer.addActionListener(mal);
    }
    
    public void addFormRegistrosListener(ActionListener mal) {
    	createSaleButton.addActionListener(mal);
    }
    
    public int getTfCodigo() {
		return Integer.parseInt(tfCodigo.getText());
	}

	public void setTfCodigo(JTextField tfCodigo) {
		this.tfCodigo = tfCodigo;
	}

	public String getTfNombre() {
		return tfNombre.getText();
	}

	public void setTfNombre(JTextField tfNombre) {
		this.tfNombre = tfNombre;
	}

	public int getTfPCompra() {
		return Integer.parseInt(tfPCompra.getText());
	}

	public void setTfPCompra(JTextField tfPCompra) {
		this.tfPCompra = tfPCompra;
	}

	public int getTfPVenta() {
		return Integer.parseInt(tfPVenta.getText());
	}

	public void setTfPVenta(JTextField tfPVenta) {
		this.tfPVenta = tfPVenta;
	}

	public int getTfCantB() {
		return Integer.parseInt(tfCantB.getText());
	}

	public void setTfCantB(JTextField tfCantB) {
		this.tfCantB = tfCantB;
	}

	public int getTfCantMin() {
		return Integer.parseInt(tfCantMin.getText());
	}

	public void setTfCantMin(JTextField tfCantMin) {
		this.tfCantMin = tfCantMin;
	}

	public int getTfCantMax() {
		return Integer.parseInt(tfCantMax.getText());
	}

	public void setTfCantMax(JTextField tfCantMax) {
		this.tfCantMax = tfCantMax;
	}
	
	public String getProductos() {
		return productos.getText();
	}

	public void setProductos(ArrayList<String> prod) {
		productos.setText(INITIAL_VALUE);
		for(String a : prod){
			
			   this.productos.append(a + "\n");
			}
	}
}
