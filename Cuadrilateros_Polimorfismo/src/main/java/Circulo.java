public class Circulo extends Figura {
    private int r;

    public Circulo(int x, int y, int r){
        super(x, y);
        this.r = r;
    }

    @Override
    public double calcularArea() {
        return Math.PI*Math.pow(r, 2);
    }

    @Override
    public double calcularPerimetro() {
        return Math.PI*2*r;
    }
}
