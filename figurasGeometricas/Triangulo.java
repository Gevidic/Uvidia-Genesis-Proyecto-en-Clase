package figurasGeometricas;

public class Triangulo extends Figura {
    private double altura;

    public Triangulo(double base, double altura) {
        super(base);
        this.altura = altura;
    }

    @Override
    public double getArea() {
        return (valor1 * altura) / 2;
    }

    @Override
    public double getPerimetro() {

        return valor1 * 3;
    }
}
