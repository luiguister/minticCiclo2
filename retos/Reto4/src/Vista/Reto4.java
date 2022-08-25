package Vista;

import Controlador.ControladorTabs;

public class Reto4 {
	
    public static void main(String args[]) throws Exception {
    	
    	PanelInicial panelInicial = new PanelInicial();
    	RegistroPaciente registroPaciente = new RegistroPaciente();
    	ProcesarDatos procesarDatos = new ProcesarDatos();
    	new ControladorTabs(registroPaciente);
    	new ControladorTabs(procesarDatos);
    	//new ControladorTabs(registroPaciente, procesarDatos);
    	
    	panelInicial.getContentPane().add(registroPaciente);
    	panelInicial.getContentPane().add(procesarDatos);
        panelInicial.getContentPane().add(panelInicial.tabs);
        panelInicial.setSize(400, 400);
        //pInicial.setOpaque(true);
        panelInicial.setDefaultCloseOperation(PanelInicial.EXIT_ON_CLOSE);
        panelInicial.setVisible(true);
    }
}
