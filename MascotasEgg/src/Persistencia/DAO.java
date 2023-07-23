package Persistencia;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.Statement;

//import com.mysql.cj.xdevapi.Statement;

public abstract class DAO {
    
    protected Connection conexion = null;
    protected ResultSet resultado = null;
    protected Statement sentencia = null;

    private final String USER = "root";
    private final String PASSWORD = "";
    private final String DATABASE = "mascota";
    private final String DRIVER = "com.mysql.jdbc.Driver";

    protected void conectarBase() throws ClassNotFoundException, SQLException {
 
        try{
            Class.forName(DRIVER);
            String urlBaseDeDatos = "jdbc:mysql://localhost:3306/" + DATABASE;
            //String urlBaseDeDatos = "jdbc:mysql://localhost:3306/" + DATABASE + "?useSSL=false";
            conexion = DriverManager.getConnection(urlBaseDeDatos, USER, PASSWORD);
        }catch (ClassNotFoundException | SQLException ex) {
            throw ex;
        }
    }

    protected void desconectarBase() throws Exception {
        try{
            if (resultado != null) {
                resultado.close();
            }
            if (sentencia != null) {
                sentencia.close();
            }
            if (conexion != null) {
                conexion.close();
            }
        }catch (Exception ex) {
            throw ex;
        }
    }

    protected void insertarModificarEliminar(String sql) throws Exception {
        try {
            conectarBase();
            sentencia = conexion.createStatement();
            sentencia.executeUpdate(sql);
        } catch (SQLException | ClassNotFoundException ex) {
            // TODO: handle exception
            //conexion.rollback();
            throw ex;
        }finally {
            desconectarBase();
        }
    }

    protected void consultarBase(String sql) throws Exception {
        try {
            conectarBase();
            sentencia = conexion.createStatement();
            resultado = sentencia.executeQuery(sql);
        } catch (Exception ex) {
            throw ex;
        }

    }


}
