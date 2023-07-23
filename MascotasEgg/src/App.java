import java.util.logging.Level;
import java.util.logging.Logger;

import Service.UsuarioService;

public class App {
    public static void main(String[] args) throws Exception {
        
        UsuarioService usuarioService = new UsuarioService();

        try {
            usuarioService.crearUsuario("ant@gmail.com", "feadfesadf");
        } catch (Exception e) {
            throw e;
        }
    }
}
