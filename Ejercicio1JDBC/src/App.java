import java.util.InputMismatchException;
import java.util.Scanner;

import Entidades.Producto;
import Service.ProductoService;

public class App {
    public static void main(String[] args) throws InputMismatchException, Exception {

        final Scanner sc = new Scanner(System.in);

        ProductoService ps = new ProductoService();

        boolean exit = false;
        while (!exit) {
            System.out.println("1. Ver lista de productos");
            System.out.println("2. Ingresar nuevo producto");
            System.out.println("3. Lista nombres y precios");
            System.out.println("4. Listar nombre de productos");
            System.out.println("5. Filtrar por precio");
            System.out.println("6. Filtrar por nombre");
            System.out.println("7. Producto precio minimo");
            System.out.println("8. Ingresar nuevo fabricante");

            System.out.println("9. Salir");
            int option = 0;

            option = sc.nextInt();

            switch (option) {
                case 1:
                    for (Producto producto : ps.verProductos()) {
                        System.out.println(producto.toString());

                    }
                    // System.out.println(ps.verProductos().toString());
                    // ps.verProductos().toString();
                    break;

                case 2:
                    try {
                        System.out.println("Ingrese nombre del nuevo producto");
                        String nombre = sc.nextLine();
                        nombre = sc.nextLine();
                        System.out.println("Ingrese precio del producto");
                        Double precio = sc.nextDouble();
                        System.out.println("Ingrese codigo fabricante");
                        int codFab = sc.nextInt();
                        ps.crearProducto(nombre, precio, codFab);
                    } catch (Exception e) {
                        throw e;
                    }
                    break;

                case 3:
                    for (Producto producto : ps.ListaNombresPrecios()) {
                        System.out.println(producto);
                    }
                    break;

                case 4:
                    for (Producto producto : ps.ListaNombres()) {
                        System.out.println(producto);
                    }
                    break;
                case 5:
                    try {
                        System.out.println("Ingrese precio minimo");
                        int min = sc.nextInt();
                        System.out.println("Ingrese precio maximo");
                        int max = sc.nextInt();
                        if (ps.listaFiltradaPorPrecio(min, max).size() == 0) {
                            System.out.println("No hay resultados para esta busqueda");
                        } else {
                            for (Producto producto : ps.listaFiltradaPorPrecio(min, max)) {
                                System.out.println(producto.toString());
                            }
                        }
                    } catch (Exception e) {
                        throw e;
                    }
                    break;
                case 6:
                    try {
                        System.out.println("Ingrese producto que desea buscar");

                        String nProducto = sc.nextLine();
                        nProducto = sc.nextLine();
                        for (Producto producto : ps.listaFiltrarNombre(nProducto)) {
                            System.out.println(producto.toString());
                        }
                    } catch (Exception e) {
                        throw e;
                    }
                    break;

                case 7:
                    try {
                        for (Producto producto : ps.listaPrecioMinimo()) {
                            System.out.println(producto.toString());
                        }
                    } catch (Exception e) {
                        throw e;
                    }
                    break;

                case 8:
                    try {
                        System.out.println("Ingrese nombre del fabricante");
                        String fabricante = sc.nextLine();
                        fabricante = sc.nextLine();
                        ps.agregarFabricante(fabricante);
                    } catch (Exception e) {
                        throw e;
                    }
                    break;

                case 9:
                   ;
                            String nuevoNombre;
                            double nuevoPrecio;

                    System.out.println("1. Cambiar nombre");
                    System.out.println("2. Cambiar precio");
                    System.out.println("3. Cambiar nombre y precio");
                    System.out.println("Ingrese una opcion");
                    int optionUpdate = sc.nextInt();
                    System.out.println("Ingrese codigo del producto que desea modificar");
                    int codigo = sc.nextInt();
                    switch (optionUpdate) {
                        case 1:
                            System.out.println("Ingrese nuevo nombre");
                            nuevoNombre = sc.nextLine();
                            ps.cambiarNombre(nuevoNombre, codigo);
                            break;

                        case 2:
                            System.out.println("Ingrese nuevo precio");
                            nuevoPrecio = sc.nextDouble();
                            ps.cambiarPrecio(nuevoPrecio, codigo);
                            break;

                        case 3:
                            System.out.println("Ingrese nuevo nombre");
                            nuevoNombre = sc.nextLine();
                            nuevoNombre = sc.nextLine();
                            ps.cambiarNombre(nuevoNombre, codigo);
                            System.out.println("Ingrese nuevo precio");
                            nuevoPrecio = sc.nextDouble();
                            ps.cambiarPrecio(nuevoPrecio, codigo);

                            break;
                    }
                case 10:
                    exit = true;
                    break;
            }

        }
    }
}
