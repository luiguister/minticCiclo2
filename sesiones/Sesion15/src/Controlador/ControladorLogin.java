package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

import Modelo.Usuario;
import Vista.Formulario;
import Vista.Login;

public class ControladorLogin {
	private Usuario m_usuario;
    private Login  v_login;
    private Formulario  v_formulario;
    

    //========================================================== constructor
    /** Constructor */
    public ControladorLogin(Login login, Formulario formulario) {
        //m_usuario = usuario;
        v_login  = login;
        v_formulario = formulario;
        
        //... Add listeners to the view.
        login.addLoginListener(new LoginListener());
    }
    
    class LoginListener implements ActionListener {
    	@Override
        public void actionPerformed(ActionEvent e) {
        	if (v_login.getUsuario().equals("prueba")) 
        		JOptionPane.showMessageDialog(null, "Usuario"+m_usuario.getUsuario()+" no valido", "validacion", JOptionPane.ERROR_MESSAGE);
			else if (v_login.getContrasena().length() < 6) 
        		JOptionPane.showMessageDialog(null, "pswd debe tener mas de 6", "validacion", JOptionPane.ERROR_MESSAGE);
			else if (v_login.getUsuario().equals(v_login.getContrasena())) 
				JOptionPane.showMessageDialog(null, "Contraseña no debe ser igual a usuario", "validacion", JOptionPane.ERROR_MESSAGE);
			else {
				v_login.setVisible(false);
				v_formulario.setVisible(true);
			}
		}
    }
}
