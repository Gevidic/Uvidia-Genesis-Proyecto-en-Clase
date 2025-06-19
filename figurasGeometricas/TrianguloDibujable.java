package figurasGeometricas;

import java.awt.*;

public class TrianguloDibujable extends Triangulo implements figuraDibujable {
    private int x;
    private int y;

    public TrianguloDibujable(double base, double altura, int x, int y) {
        super(base, altura);
        this.x = x;
        this.y = y;
    }

    @Override
    public void setCoordenadas(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void dibujar2D(Graphics g) {
        int baseInt = (int) valor1;
        int alturaInt = (int) (super.getArea() * 2 / valor1); // Aproximación
        int[] xPoints = {x, x + baseInt / 2, x - baseInt / 2};
        int[] yPoints = {y, y - alturaInt, y - alturaInt};
        g.drawPolygon(xPoints, yPoints, 3);
    }
}
