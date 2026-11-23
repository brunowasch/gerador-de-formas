import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Polygon;

public class Tetraedro extends FormaTridimensional {
    private double lado;

    public Tetraedro(int x, int y, double lado, Color cor) {
        super(x, y, cor);
        this.lado = lado;
    }

    @Override
    public double obterVolume() {
        return Math.pow(lado, 3) / (6 * Math.sqrt(2));
    }

    @Override
    public double obterArea() {
        return Math.sqrt(3) * Math.pow(lado, 2);
    }

    @Override
    public void desenhar(Graphics2D g2d) {
        int tamanho = (int) Math.round(lado);
        int altura = (int) Math.round(lado * Math.sqrt(3) / 2);

        int x = getX();
        int y = getY();

        // Vértices da representação do tetraedro.
        int topoX = x + tamanho / 2;
        int topoY = y;

        int esquerdoX = x;
        int esquerdoY = y + altura;

        int direitoX = x + tamanho;
        int direitoY = y + altura;

        int centroX = x + tamanho / 2;
        int centroY = y + altura / 3;

        // Face inferior.
        Polygon base = new Polygon(
            new int[]{esquerdoX, centroX, direitoX},
            new int[]{esquerdoY, centroY, direitoY},
            3
        );

        // Face esquerda.
        Polygon faceEsquerda = new Polygon(
            new int[]{topoX, esquerdoX, centroX},
            new int[]{topoY, esquerdoY, centroY},
            3
        );

        // Face direita.
        Polygon faceDireita = new Polygon(
            new int[]{topoX, centroX, direitoX},
            new int[]{topoY, centroY, direitoY},
            3
        );

        g2d.setColor(getCor().darker().darker());
        g2d.fillPolygon(base);

        g2d.setColor(getCor());
        g2d.fillPolygon(faceEsquerda);

        g2d.setColor(getCor().brighter());
        g2d.fillPolygon(faceDireita);

        // Desenha os contornos das faces.
        g2d.setColor(Color.BLACK);
        g2d.drawPolygon(base);
        g2d.drawPolygon(faceEsquerda);
        g2d.drawPolygon(faceDireita);
    }
}
