import java.util.Comparator;

public class Pieza implements Comparable {

    private String nombre;
    private int codigo;
    private String pais;
    private int cantidad;
    private double precio;

    public Pieza(String nombre, int codigo, String pais, int cantidad, double precio){
        this.nombre = nombre;
        this.codigo = codigo;
        this.pais = pais;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public int compareTo(Object o) {
        int compararCodigo = ((Pieza) o).getCodigo();
        return this.codigo-compararCodigo;
    }

    @Override
    public String toString() {
        return "[ nombre = "+nombre+", codigo = "+codigo+", pais = "+pais+", cantidad = "+cantidad+", precio unitario = "+precio+" ]";
    }
}
