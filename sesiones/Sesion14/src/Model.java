public class Model {
    
    private static final String INITIAL_VALUE = "";

    String usuario;
    String contrasena;

    Model() {
        reset();
    }

    public void reset() {
    	usuario = INITIAL_VALUE;
    	contrasena = INITIAL_VALUE;
    }
    

    public void setUsuario(String value) {
        
    	usuario = value;
    }
    public void setContrasena(String value) {
        
    	contrasena = value;
    }

    public String getUsuario() {
        return usuario.toString();
    }
    public String getContrasena() {
        return contrasena.toString();
    }
}
