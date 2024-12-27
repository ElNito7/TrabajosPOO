public class Extranjero extends Estudiante{
    private String pais;
    private int pasaporte;
    private String embajada;
    private int yearOfEntry;

    public Extranjero(String name, int id, int year, String carrera, String pais, double residencia, double edificio, double auxiliar, int pasaporte, String embajada, int yearOfEntry){
        super(name, id, year, carrera, residencia, edificio, auxiliar);
        this.pais = pais;
        this.pasaporte = pasaporte;
        this.embajada = embajada;
        this.yearOfEntry = yearOfEntry;
    }

    public String getPais() {
        return pais;
    }


    @Override
    public double evaluacion() {
        double promedio;
        promedio = (residencia + edificio + auxiliar)/3;
        if (residencia < 1 || residencia > 10 || edificio < 1 || edificio > 10 || auxiliar < 1 || auxiliar > 10) {
            System.out.println("Las evaluaciones deben estar entre 1 y 10");
            return -1;
        } else if ((residencia < 6 && edificio < 6) || (residencia < 6 && auxiliar < 6) || (edificio < 6 && auxiliar < 6)) {
            System.out.println("Su evaluación es de MAL. Con un promedio de: "+promedio);
            return promedio;
        } else if (promedio >= 6 && promedio <= 8) {
            System.out.println("Su evaluación es de CUMPLIDOR. Con un promedio de: "+promedio);
            return promedio;
        } else {
            System.out.println("Su evaluación es de DESTACADO. Con un promedio de: "+promedio);
            return promedio;
        }
    }
}
