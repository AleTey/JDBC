package Persistencia;

import com.mysql.cj.x.protobuf.MysqlxCrud.Collection;

import java.util.ArrayList;


import Entidad.Usuario;

public final class UsuarioDAO extends DAO{
    
    public void guardarUsuario(Usuario usuario) throws Exception {
        try {
            if (usuario == null) {
                throw new Exception("Debe indicar un usuario");
            }

            String sql = "INSERT INTO Usuario (correoElectronico, clave)"
            + "VALUES ( '" + usuario.getEmail() + "' , '" + usuario.getClave() + "');"; 
            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        }
    }

    public void modificarUsuario(Usuario usuario) throws Exception {
        try {
            if (usuario == null) {
                throw new Exception("Debe indicar el usuario");
            }
            String sql = "UPDATE Usuario Set "
            + "clave = '" + usuario.getClave() + "' WHERE correoElectronico = '" + usuario.getEmail() + "')";
            insertarModificarEliminar(sql);
        }catch(Exception ex) {
            throw ex;
        }
    }

    public void eliminarUsuario(String correoElectronico) throws Exception {
        try {
            if(correoElectronico == null) {
                throw new Exception("Debe indicar el correoElectronico");
            }
            String sql = "DELETE FROM Usuario WHERE correElectronico = '" + correoElectronico + "'";
            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        }
    }

    public Usuario buscarUsuarioPorCorreoElectronico(String correoElectronico) throws Exception {
        try{
        String sql = "SELECT * FROM Usuario "
                + "WHERE correoElectronico = '" + correoElectronico + "'";
                consultarBase(sql);
                Usuario usuario = null;
                while (resultado.next()) {
                    usuario = new Usuario();
                    usuario.setId(resultado.getInt(1));
                    usuario.setEmail(resultado.getString(2));
                    usuario.setClave(resultado.getString(3));
                }
                desconectarBase();
                return usuario;
        }catch(Exception e) {
            desconectarBase();
            throw e;
        }
    }

  
    public ArrayList<Usuario> listarUsuarion() throws Exception {
        try {
            String sql = "SELECT correoElectronico, clave FROM Usuario ";
            consultarBase(sql);

            Usuario usuario = null;
            ArrayList<Usuario> usuarios = new ArrayList();
            while (resultado.next()) {
                usuario = new Usuario();
                usuario.setEmail(resultado.getString(1));
                usuario.setClave(resultado.getString(2));
                usuarios.add(usuario);
            }
            desconectarBase();
            return usuarios;
        }catch(Exception e) {
            e.printStackTrace();
            desconectarBase();
            throw new Exception("Error de sistema");
        }
    }
}
