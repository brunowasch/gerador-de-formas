import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Polygon;

public class Cubo extends FormaTridimensional {
    private double lado;

    public Cubo(int x, int y, double lado, Color cor) {
        super(x, y, cor);
        this.lado = lado;
    }

    @Override
    public double obterVolume() {
        return Math.pow(lado, 3);
    }

    @Override
    public double obterArea() {
        return 6 * Math.pow(lado, 2);
    }

    @Override
    public void desenhar(Graphics2D g2d) {
        int tamanho = (int) Math.round(lado);
        int profundidade = tamanho / 3;

        int x = getX();
        int y = getY();

        // Face frontal
        Polygon frente = new Polygon(
            new int[]{x, x + tamanho, x + tamanho, x},
            new int[]{y + profundidade, y + profundidade, y + tamanho + profundidade, y + tamanho + profundidade},
            4
        );

        // Face superior
        Polygon topo = new Polygon(
            new int[]{x, x + profundidade, x + tamanho + profundidade, x + tamanho},
            new int[]{y + profundidade, y, y, y + profundidade},
            4
        );

        // Face lateral direita
        Polygon lateral = new Polygon(
            new int[]{x + tamanho, x + tamanho + profundidade, x + tamanho + profundidade, x + tamanho},
            new int[]{y + profundidade, y, y + tamanho, y + tamanho + profundidade},
            4
        );

        g2d.setColor(getCor().brighter());
        g2d.fillPolygon(topo);

        g2d.setColor(getCor());
        g2d.fillPolygon(frente);

        g2d.setColor(getCor().darker());
        g2d.fillPolygon(lateral);

        g2d.setColor(Color.BLACK);
        g2d.drawPolygon(topo);
        g2d.drawPolygon(frente);
        g2d.drawPolygon(lateral);
    }
}
