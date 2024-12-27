public abstract class Estudiante {
    protected String name;
    protected int id;
    protected int year;
    protected String carrera;
    protected double residencia;
    protected double edificio;
    protected double auxiliar;

    public Estudiante(String name, int id, int year, String carrera, double residencia, double edificio, double auxiliar){
        this.name = name;
        this.id = id;
        this.year = year;
        this.carrera = carrera;
        this.residencia = residencia;
        this.edificio = edificio;
        this.auxiliar = auxiliar;
    }

    public int getYear() {
        return year;
    }

    public abstract double evaluacion();
}
