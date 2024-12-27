public class Triangulo extends Figura{
    private int x2;
    private int y2;
    private int x3;
    private int y3;
    public Triangulo(int x, int y, int x2, int y2, int x3, int y3) {
        super(x, y);
        this.x2 = x2;
        this.y2 = y2;
        this.x3 = x3;
        this.y3 = y3;
    }

    @Override
    public double calcularArea() {
        double h = Math.sqrt(Math.pow(distancia(x, y, x2, y2), 2) - (Math.pow(distancia(x,y,x3,y3), 2)/4));
        return (double) distancia(x,y,x2,y2)*h/2;
    }

    @Override
    public double calcularPerimetro() {
        return distancia(x,y,x2,y2) + distancia(x2,y2,x3,y3) + distancia(x,y,x3,y3);
    }

}
