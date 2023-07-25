package Persistencia;

import java.util.ArrayList;

import Entidades.Fabricante;
import Entidades.Producto;

public final class ProductoDAO extends DAO {

    public ArrayList<Producto> listaProductos() throws Exception {

        try {
            String sql = "SELECT * FROM Producto";
            counsultarBase(sql);

            Producto producto = null;
            ArrayList<Producto> productos = new ArrayList<Producto>();
            while (resultado.next()) {
                producto = new Producto();
                producto.setCodigo(resultado.getInt(1));
                producto.setNombre(resultado.getString(2));
                producto.setPrecio(resultado.getDouble(3));
                producto.setCodigo_fabricante(resultado.getInt(4));
                productos.add(producto);
            }
            desconectarBase();
            return productos;
        } catch (Exception e) {
            e.printStackTrace();
            desconectarBase();
            throw new Exception("Error en el sistema");
        }

    }

    public void guardarProducto(Producto producto) throws Exception {
        try {
            if (producto == null) {
                throw new Exception("Debe indicar un producto");
            }

            String sql = "INSERT INTO Producto (nombre, precio, codigo_fabricante)"
                    + "VALUES ( '"
                    + producto.getNombre() + "' , '"
                    + producto.getPrecio() + "' , '"
                    + producto.getCodigo_fabricante() + "');";
            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        }
    }

    public ArrayList<Producto> listaNombresYPrecios() throws Exception {

        try {
            String sql = "SELECT nombre, precio FROM producto";
            counsultarBase(sql);

            Producto producto = null;
            ArrayList<Producto> listaNombrePrecios = new ArrayList<Producto>();

            while (resultado.next()) {
                producto = new Producto();
                producto.setNombre(resultado.getString("nombre"));
                producto.setPrecio(resultado.getDouble("precio"));
                listaNombrePrecios.add(producto);
            }
            desconectarBase();
            return listaNombrePrecios;

        } catch (Exception e) {
            e.printStackTrace();
            desconectarBase();
            throw new Exception("Error en el sistema");
        }
    }

    public ArrayList<Producto> ListaNombre() throws Exception {

        try {
            String sql = "SELECT nombre FROM producto";
            counsultarBase(sql);

            Producto producto = null;
            ArrayList<Producto> listaNombres = new ArrayList<Producto>();

            while (resultado.next()) {
                producto = new Producto();
                producto.setNombre(resultado.getString("nombre"));
                listaNombres.add(producto);
            }
            desconectarBase();
            return listaNombres;
        } catch (Exception e) {
            e.printStackTrace();
            desconectarBase();
            throw new Exception("Error sistema");
        }
    }

    public ArrayList<Producto> listaFiltradaPorPresio(double min, double max) throws Exception{

        try {
            String sql = "SELECT * FROM producto WHERE precio > " + min + " AND precio < " + max + ";";
            //PreparedStatement stmt = conexion.prepareStatement(sql);

            counsultarBase(sql);

            Producto producto = null;
            ArrayList<Producto> listaFiltradaPorPrecio = new ArrayList<Producto>();

            while (resultado.next()) {
                producto = new Producto();
                producto.setCodigo(resultado.getInt("codigo"));
                producto.setNombre(resultado.getString("nombre"));
                producto.setPrecio(resultado.getDouble("precio"));
                producto.setCodigo_fabricante(resultado.getInt("codigo_fabricante"));
                listaFiltradaPorPrecio.add(producto);
            }
           
            return listaFiltradaPorPrecio;
       
        } catch (Exception e) {
            e.printStackTrace();

            throw new Exception("error en el sistema");
        }finally {
            desconectarBase();
        }

    }

    public ArrayList<Producto> listaFiltrarNombre(String nombre) throws Exception {

        try {
            String sql = "SELECT * FROM producto WHERE nombre LIKE '%" + nombre + "%';";
            counsultarBase(sql);

            Producto producto = null;
            ArrayList<Producto> listaFiltrarNombre = new ArrayList<Producto>();

            while (resultado.next()) {
                producto = new Producto();
                
                producto.setCodigo(resultado.getInt("codigo"));
                producto.setNombre(resultado.getString("nombre"));
                producto.setPrecio(resultado.getDouble("precio"));
                producto.setCodigo_fabricante(resultado.getInt("codigo_fabricante"));
                listaFiltrarNombre.add(producto);
            }
            return listaFiltrarNombre;
        } catch (Exception e) {
            throw e;
        } finally {
            desconectarBase();
        }
    }

    public ArrayList<Producto> listaPrecioMinimo() throws Exception {

        try {
            String sql = "SELECT * FROM producto WHERE precio = (SELECT MIN(precio) FROM producto);";
            counsultarBase(sql);

            Producto producto = null;
            ArrayList<Producto> listaPrecioMinimo = new ArrayList<Producto>();

            while (resultado.next()) {
                producto = new Producto();

                producto.setCodigo(resultado.getInt("codigo"));
                producto.setNombre(resultado.getString("nombre"));
                producto.setPrecio(resultado.getDouble("precio"));
                producto.setCodigo_fabricante(resultado.getInt("codigo_fabricante"));

                listaPrecioMinimo.add(producto);
            }
            return listaPrecioMinimo;
        } catch (Exception e) {
            throw e;
        }finally {
            desconectarBase();
        }
    }

    public void IngresarFabricante(Fabricante fabricante) throws Exception {

        try {
            if (fabricante == null) {
                throw new Exception("Debe indicar un fabricante");
            }
            String sql = "INSERT INTO fabricante (nombre) VALUES('" + fabricante.getNombre() + "');";
            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        }
    }

    public void cambiarNombre(String nombre, int codigo) throws Exception {

        try {
            String sql = "UPDATE producto SET nombre = '" + nombre + "' WHERE codigo = '" + codigo + "';";
            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        }
    }

    public void cambiarPrecio(double precio, int codigo) throws Exception {

        try {
            String sql = "UPDATE producto SET precio = '" + precio + "' WHERE codigo = '" + codigo + "';";
            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        }
    }


}
