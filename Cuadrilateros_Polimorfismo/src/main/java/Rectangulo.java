public class Rectangulo extends Figura{
    private int x2;
    private int y2;
    public Rectangulo(int x, int y, int x2, int y2) {
        super(x, y);
        this.x2 = x2;
        this.y2 = y2;
    }

    @Override
    public double calcularArea() {
        double a = distancia(x,y,x,y2);
        double b = distancia(x,y,x2,y);
        return a*b;
    }

    @Override
    public double calcularPerimetro() {
        double a = distancia(x,y,x,y2);
        double b = distancia(x,y,x2,y);
        return 2*(a+b);
    }
}
