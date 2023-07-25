package Service;

import java.util.ArrayList;

import Entidades.Fabricante;
import Entidades.Producto;
import Persistencia.ProductoDAO;

public class ProductoService {

    private ProductoDAO productoDao;

    public ProductoService() {
        this.productoDao = new ProductoDAO();
    }

    public ArrayList<Producto> verProductos() throws Exception {

        try {
            return productoDao.listaProductos();
        } catch (Exception e) {
            throw e;
        }
    }

    public void crearProducto(String nombre, double precio, int codFab) throws Exception {
        try {
            Producto producto = new Producto(nombre, precio, codFab);
            productoDao.guardarProducto(producto);
        } catch (Exception e) {
            throw e;
        }
    }

    public ArrayList<Producto> ListaNombresPrecios() throws Exception {
        try {
            return productoDao.listaNombresYPrecios();
        } catch (Exception e) {
            throw e;
        }
    }

    public ArrayList<Producto> ListaNombres() throws Exception {

        try {
            return productoDao.ListaNombre();
        } catch (Exception e) {
            throw e;
        }
    }

    public ArrayList<Producto> listaFiltradaPorPrecio(double min, double max) throws Exception{

        try {
            return productoDao.listaFiltradaPorPresio(min, max);
        } catch (Exception e) {
            throw e;
        }
    }

    public ArrayList<Producto> listaFiltrarNombre(String nombre) throws Exception {

        try {
            return productoDao.listaFiltrarNombre(nombre);
        } catch (Exception e) {
            throw e;
        }
    }

    public ArrayList<Producto> listaPrecioMinimo() throws Exception {
        try {
            return productoDao.listaPrecioMinimo();
        } catch (Exception e) {
            throw e;
        }
    }

    public void agregarFabricante(String nombre) throws Exception {

        try {
            Fabricante fabricante = new Fabricante();
            fabricante.setNombre(nombre);
            productoDao.IngresarFabricante(fabricante);
        } catch (Exception e) {
            throw e;
        }
    }

    public void cambiarNombre(String nombre, int codigo) throws Exception {

        try {
            productoDao.cambiarNombre(nombre, codigo);
        } catch (Exception e) {
            throw e;
        }
    }

    public void cambiarPrecio(double precio, int codigo) throws Exception {

        try {
            productoDao.cambiarPrecio(precio, codigo);
        } catch (Exception e) {
            throw e;
        }
    }
}
