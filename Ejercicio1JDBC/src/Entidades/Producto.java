package Entidades;

public class Producto {
    private int codigo;
    private String nombre;
    private double precio;
    private int codigo_fabricante;

    public Producto() {
    }

    public Producto(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }
    

    public Producto(String nombre, double precio, int codigo_fabricante) {
        this.nombre = nombre;
        this.precio = precio;
        this.codigo_fabricante = codigo_fabricante;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public int getCodigo_fabricante() {
        return codigo_fabricante;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setCodigo_fabricante(int codigo_fabricante) {
        this.codigo_fabricante = codigo_fabricante;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Producto [nombre=").append(nombre);
          //.append(", precio=").append(precio);
        if (precio != 0) {
            sb.append(", precio=").append(precio);
        }
    
        if (codigo != 0) {
            sb.append(", codigo=").append(codigo);
        }
    
        if (codigo_fabricante != 0) {
            sb.append(", codigo_fabricante=").append(codigo_fabricante);
        }
    
        sb.append("]");
        return sb.toString();
    }
    
    
    
    
    
}
