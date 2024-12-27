public class Juridico extends Cliente {
    private String empresa;

    public Juridico(String nombre, String apellidos, String empresa){
        super(nombre, apellidos);
        this.empresa = empresa;
    }
}
