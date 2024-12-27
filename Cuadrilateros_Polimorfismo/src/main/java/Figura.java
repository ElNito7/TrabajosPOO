public abstract class Figura {
    //Variables
    protected int x;
    protected int y;
    //Constructor
    public Figura(int x, int y){
        this.x = x;
        this.y = y;
    }



    //Metodos abstractos
    public abstract double calcularArea();
    public abstract double calcularPerimetro();

    public double distancia(int x1, int y1, int x2, int y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }
}
