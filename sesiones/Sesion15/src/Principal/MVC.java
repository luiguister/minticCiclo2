package Principal;

import Controlador.ControladorFormulario;
import Controlador.ControladorLogin;

import Controlador.ControladorRegistrosVC;
import Modelo.Usuario;
import Modelo.Venta;
import Modelo.Cliente;
import Modelo.Producto;
import Persistencia.Connect;
import Vista.Formulario;
import Vista.Login;
import Vista.RegistrosVC;


public class MVC {
    
    public static void main(String ...args) {

        Usuario usuario = new Usuario();
        Producto producto = new Producto();
        Venta venta = new Venta();
        Cliente cliente = new Cliente();
        //Login login = new Login(usuario);
        Login login = new Login();
        Formulario formulario = new Formulario(producto);
        RegistrosVC registrosVC = new RegistrosVC(venta, cliente);
        Connect c = new Connect();
        new ControladorLogin(login, formulario);
        new ControladorFormulario(producto, formulario, registrosVC, c);
        //new ControladorRegistrosVC(registrosVC, cliente, registrosVC);
        login.setVisible(true);
    }
}