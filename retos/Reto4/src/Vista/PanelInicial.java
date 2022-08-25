package Vista;
//import java.awt.event.ActionListener;

import javax.swing.*;

public class PanelInicial extends JFrame {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//private static final int INITIAL_VALUE2 = 0;
	
	JTabbedPane tabs;
    private RegistroPaciente rPaciente;
    
    ProcesarDatos pDatos;
    EditarEliminar editarEliminar;
    
        
     public PanelInicial() {
    	 //public RegistrosVC(Venta venta, Cliente cliente) {	 
        super();
        
        // Setting the JTabbedPane Position and Layout as Wrap
        tabs = new JTabbedPane(JTabbedPane.TOP, JTabbedPane.WRAP_TAB_LAYOUT);

        rPaciente = new RegistroPaciente();
        //pDatos = new ProcesarDatos();
        editarEliminar = new EditarEliminar();
        // Adding user defined pannels to JTabbedPane
        tabs.addTab("Registro de pacientes", rPaciente);
        tabs.addTab("Procesar Datos", new ProcesarDatos());
        tabs.addTab("Editar/Eliminar", editarEliminar);
        
        rPaciente.setOpaque(true);
        
        // Adding JPanels to JTabbedPane
        //tabs.addTab("Comment", new JTextArea(10, 40));
        
        //getContentPane().add(tabs);
        
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //setVisible(true);
    }
     
 	/*public void addRegistroPacienteListener(ActionListener mal) {
    	rPaciente.registrar.addActionListener(mal);
    	
     }*/
}






