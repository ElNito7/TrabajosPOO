public class Nacional extends Estudiante{
    private String direccion;
    public Nacional(String name, int id, int year, String carrera, double residencia, double edificio, double auxiliar, String direccion){
        super(name, id, year, carrera, residencia, edificio, auxiliar);
        this.direccion = direccion;
    }

    @Override
    public double evaluacion() {
        double promedio;
        promedio = (residencia + edificio + auxiliar)/3;
        if (residencia < 1 || residencia > 10 || edificio < 1 || edificio > 10 || auxiliar < 1 || auxiliar > 10) {
            System.out.println("Las evaluaciones deben estar entre 1 y 10");
            return -1;
        } else if (residencia < 6 || edificio < 6 || auxiliar < 6) {
            System.out.println("Su evaluación es de MAL. Con un promedio de: " + promedio);
            return promedio;
        } else if (promedio >= 6 && promedio < 9) {
            System.out.println("Su evaluación es de REGULAR. Con un promedio de " + promedio);
            return promedio;
        } else {
            System.out.println("Su evaluación es de BIEN "+ promedio);
            return promedio;
        }
    }
}
