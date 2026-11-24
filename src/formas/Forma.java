package formas;

import java.awt.Color;
import java.awt.Graphics2D;

public abstract class Forma implements Comparable<Forma> {
    private int x;
    private int y;
    private Color cor;

    public Forma(int x, int y, Color cor) {
        this.x = x;
        this.y = y;
        this.cor = cor;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Color getCor() {
        return cor;
    }

    public void setCor(Color cor) {
        this.cor = cor;
    }

    public abstract double obterArea();

    public abstract void desenhar(Graphics2D g2d);

    @Override
    public int compareTo(Forma outraForma) {
        return Double.compare(this.obterArea(), outraForma.obterArea());
    }
}
