package formas;

import java.awt.Color;
import java.awt.Graphics2D;

public class Circulo extends FormaBidimensional {
    private double raio;

    public Circulo(int x, int y, double raio, Color cor) {
        super(x, y, cor);
        this.raio = raio;
    }

    public double getRaio() {
        return raio;
    }

    public void setRaio(double raio) {
        this.raio = raio;
    }

    @Override
    public double obterArea() {
        return Math.PI * raio * raio;
    }

    @Override
    public void desenhar(Graphics2D g2d) {
        int diametro = (int) Math.round(raio * 2);

        g2d.setColor(getCor());
        g2d.fillOval(getX(), getY(), diametro, diametro);

        g2d.setColor(getCor().darker());
        g2d.drawOval(getX(), getY(), diametro, diametro);
    }
}