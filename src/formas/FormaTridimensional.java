package formas;

import java.awt.Color;

public abstract class FormaTridimensional extends Forma {

    public FormaTridimensional(int x, int y, Color cor) {
        super(x, y, cor);
    }

    public abstract double obterVolume();
}
