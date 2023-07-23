package Service;

import Entidad.Usuario;
import Persistencia.UsuarioDAO;

public class UsuarioService {
    
    private UsuarioDAO dao;

    public UsuarioService() {
        this.dao = new UsuarioDAO();
    }

    public void crearUsuario(String correoElectronico, String clave) throws Exception {

        try {
            if (correoElectronico == null || correoElectronico.trim().isEmpty()) {
                throw new Exception("Debe indicar el correo electronico");
            }
            if (correoElectronico.contains("@") == false) {
                throw new Exception("El correo electronico es incorrecto");
            }
            if(clave == null || clave.trim().isEmpty()) {
                throw new Exception("Debe indicar la clave");
            }
            if (clave.length() < 8) {
                throw new Exception("La clave no puede tener menos de 8 caracteres");
            }
            if (dao.buscarUsuarioPorCorreoElectronico(correoElectronico) != null) {
                throw new Exception("Ya existe un usuario con el correo electronico indicado" + correoElectronico);
            }

            // CREACION DE USUARIO
            Usuario usuario = new Usuario();
            usuario.setEmail(correoElectronico);
            usuario.setClave(clave);
            dao.guardarUsuario(usuario);
        } catch (Exception e) {
            throw e;
        }
    }
}
