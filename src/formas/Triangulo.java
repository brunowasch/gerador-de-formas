package formas;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Polygon;

public class Triangulo extends FormaBidimensional {
    private double base;
    private double altura;

    public Triangulo(int x, int y, double base, double altura, Color cor) {
        super(x, y, cor);
        this.base = base;
        this.altura = altura;
    }

    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        this.base = base;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    @Override
    public double obterArea() {
        return (base * altura) / 2;
    }

    @Override
    public void desenhar(Graphics2D g2d) {
        int largura = (int) Math.round(base);
        int alturaTriangulo = (int) Math.round(altura);

        int[] xPontos = {
            getX() + largura / 2,
            getX(),
            getX() + largura
        };

        int[] yPontos = {
            getY(),
            getY() + alturaTriangulo,
            getY() + alturaTriangulo
        };

        Polygon triangulo = new Polygon(xPontos, yPontos, 3);

        g2d.setColor(getCor());
        g2d.fillPolygon(triangulo);

        g2d.setColor(getCor().darker());
        g2d.drawPolygon(triangulo);
    }
}
