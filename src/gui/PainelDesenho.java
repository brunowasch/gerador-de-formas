package gui;

import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JPanel;

import java.awt.Graphics;
import java.awt.Graphics2D;

import formas.*;

public class PainelDesenho extends JPanel {
    private ArrayList<Forma> formas = new ArrayList<>();

   public void addForma(Forma forma) {
        formas.add(forma);
        Collections.sort(formas);
        repaint();
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create();
        try {
            for (Forma forma : formas)
                forma.desenhar(g2d);
            
        } finally {
            g2d.dispose();
        }
    }

    public void limparFormas() {
        formas.clear();
        repaint();
    }

}
