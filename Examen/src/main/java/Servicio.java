public class Servicio {
    protected int idOrden;
    protected int horas;
    protected String desc;
    protected boolean concluido;
    protected Trabajador[] trabajadores;

    public Servicio(int idOrden, int horas, String desc, boolean concluido, Trabajador[] trabajadores){
        this.idOrden = idOrden;
        this.horas = horas;
        this.desc = desc;
        this.concluido = concluido;
        this.trabajadores = trabajadores;
    }

    public boolean isConcluido() {
        return concluido;
    }
    public Trabajador[] getTrabajadores() {
        return trabajadores;
    }
    public String mostrar(){
        return "[Numero de Orden: "+idOrden+", horas requeridas: "+horas+", descripción: "+desc+", concluido: "+concluido+", trabajadores involucrados: "+trabajadores.toString()+"]";
    }
}
