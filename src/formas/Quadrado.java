package formas;

import java.awt.Color;
import java.awt.Graphics2D;

public class Quadrado extends FormaBidimensional {
    private double lado;

    public Quadrado(int x, int y, double lado, Color cor) {
        super(x, y, cor);
        this.lado = lado;
    }

    public double getLado() {
        return lado;
    }

    public void setLado(double lado) {
        this.lado = lado;
    }

    @Override
    public double obterArea() {
        return lado * lado;
    }

    @Override
    public void desenhar(Graphics2D g2d) {
        int tamanho = (int) Math.round(lado);

        g2d.setColor(getCor());
        g2d.fillRect(getX(), getY(), tamanho, tamanho);

        g2d.setColor(getCor().darker());
        g2d.drawRect(getX(), getY(), tamanho, tamanho);
    }
}
