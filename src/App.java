import javax.swing.SwingUtilities;

import gui.JanelaPrincipal;

public class App {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JanelaPrincipal janela = new JanelaPrincipal();
            janela.setVisible(true);
        });
    }
}
