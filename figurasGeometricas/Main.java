// Main.java
package figurasGeometricas;

import javax.swing.*;
import java.awt.*;
import java.util.InputMismatchException;

public class Main {
    public static void main(String[] args) {
        try {
            double radio = solicitarDato("Ingrese el radio del círculo:");
            double lado = solicitarDato("Ingrese el lado del cuadrado:");
            double base = solicitarDato("Ingrese la base del triángulo:");
            double altura = solicitarDato("Ingrese la altura del triángulo:");

            CirculoDibujable circulo = new CirculoDibujable(radio, 50, 50);
            CuadradoDibujable cuadrado = new CuadradoDibujable(lado, 200, 50);
            TrianguloDibujable triangulo = new TrianguloDibujable(base, altura, 120, 200);

            imprimirInformacion("Círculo", circulo);
            imprimirInformacion("Cuadrado", cuadrado);
            imprimirInformacion("Triángulo", triangulo);

            JFrame frame = new JFrame("Dibujar Figuras");
            JPanel panel = new JPanel() {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    circulo.dibujar2D(g);
                    cuadrado.dibujar2D(g);
                    triangulo.dibujar2D(g);
                }
            };

            panel.setPreferredSize(new Dimension(400, 400));
            frame.add(panel);
            frame.pack();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);

        } catch (InputMismatchException e) {
            System.out.println("Error: Ingrese solo valores numéricos válidos.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static double solicitarDato(String mensaje) {
        String input = JOptionPane.showInputDialog(mensaje);
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("El dato no puede estar vacío.");
        }
        double valor = Double.parseDouble(input);
        if (valor <= 0) {
            throw new IllegalArgumentException("El valor debe ser positivo.");
        }
        return valor;
    }

    public static void imprimirInformacion(String nombre, Figura figura) {
        System.out.println("El perímetro del " + nombre + " es: " + figura.getPerimetro());
        System.out.println("El área del " + nombre + " es: " + figura.getArea());
    }
}
