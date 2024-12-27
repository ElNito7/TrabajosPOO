public abstract class Album {
    protected String autor;
    protected String nombre;
    protected double precio;
    protected String disquera;
    protected Temas[] temas;

    //Constructor
    public Album(String autor, String nombre, double precio, String disquera, Temas[] temas){
        this.autor = autor;
        this.nombre = nombre;
        this.precio = precio;
        this.disquera = disquera;
        this.temas = temas;
    }

    //Getters
    public String getAutor() {
        return autor;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public String getDisquera() {
        return disquera;
    }

    public Temas[] getTemas() {
        return temas;
    }

    //Setters

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setDisquera(String disquera) {
        this.disquera = disquera;
    }

    public void setTemas(Temas[] temas) {
        this.temas = temas;
    }

    //Evaluación de calidad
    public abstract double calidad();
}
