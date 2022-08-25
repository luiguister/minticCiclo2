import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Inicio extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/*private JLabel jlAlmacen;
	private JLabel jlCodigo;
	private JLabel jlNombre;
	private JLabel jlPCompra;
	private JLabel jlPVenta;
	private JLabel jlCantBod;
	private JLabel jlCantMin;
	private JLabel jlCantMax;*/
	private JTextField tfCodigo;
	private JTextField tfNombre;
	private JTextField tfPCompra;
	private JTextField tfPVenta;
	private JTextField tfCantBod;
	private JTextField tfCantMin;
	private JTextField tfCantMax;
	private JButton crear = new JButton("crear");
	GridLayout gl = new GridLayout(7,2);
	
	public Inicio(String name) {
        super(name);
        setResizable(false);
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


	public int getTfCantBod() {
		return Integer.parseInt(tfCantBod.getText());
	}


	public void setTfCantBod(JTextField tfCantBod) {
		this.tfCantBod = tfCantBod;
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
	
	public void addComponentsToPane(final Container pane) {
		final JPanel titulo = new JPanel();
		titulo.setLayout(new FlowLayout());
		titulo.add(new JLabel("Creación de productos"));
		final JPanel p1 = new JPanel();
		p1.setLayout(gl);
		p1.add(new JLabel("Nombre"));
		p1.add(tfNombre = new JTextField());
		p1.add(new JLabel("Codigo"));
		p1.add(tfCodigo= new JTextField());
		p1.add(new JLabel("Precio de compra"));
		p1.add(tfPCompra= new JTextField());
		p1.add(new JLabel("Precio de venta"));
		p1.add(tfPVenta= new JTextField());
		p1.add(new JLabel("Cantidad en bodega"));
		p1.add(tfCantBod= new JTextField());
		p1.add(new JLabel("Cantidad minima en bodega"));
		p1.add(tfCantMin= new JTextField());
		p1.add(new JLabel("Cantidad maxima de inventario"));
		p1.add(tfCantMax= new JTextField());
		JPanel p2 = new JPanel();
		p2.add(crear);
		pane.add(titulo, BorderLayout.NORTH);
		pane.add(p1, BorderLayout.CENTER);
		pane.add(p2, BorderLayout.SOUTH);
		//crear.addActionListener(null);
		
		
		
	}
	
	 void addMensaje(ActionListener mal) {
	        crear.addActionListener(mal);
	    }
	
	public void createAndShowGUI() {
        //Create and set up the window.
    	//Inicio frame = new Inicio("Inicio");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Set up the content pane.
        addComponentsToPane(getContentPane());
        //Display the window.
        pack();
        setSize(500,500);
        //frame.setVisible(true);
    }
	
	
}
