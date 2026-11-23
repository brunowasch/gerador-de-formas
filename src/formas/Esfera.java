import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RadialGradientPaint;

public class Esfera extends FormaTridimensional {
    private double raio;

    public Esfera(int x, int y, double raio, Color cor) {
        super(x, y, cor);
        this.raio = raio;
    }

    @Override
    public double obterVolume() {
        return (4.0 / 3.0) * Math.PI * Math.pow(raio, 3);
    }

    @Override
    public double obterArea() {
        return 4 * Math.PI * Math.pow(raio, 2);
    }

    @Override
    public void desenhar(Graphics2D g2d) {
        int diametro = (int) Math.round(raio * 2);

        float centroX = getX() + diametro * 0.35f;
        float centroY = getY() + diametro * 0.3f;

        RadialGradientPaint degradê = new RadialGradientPaint(
            centroX,
            centroY,
            diametro * 0.8f,
            new float[]{0f, 0.7f, 1f},
            new Color[]{
                getCor().brighter(),
                getCor(),
                getCor().darker()
            }
        );

        g2d.setPaint(degradê);
        g2d.fillOval(getX(), getY(), diametro, diametro);

        g2d.setColor(getCor().darker().darker());
        g2d.drawOval(getX(), getY(), diametro, diametro);
    }
}
