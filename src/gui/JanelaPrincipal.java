
package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Color;
import java.util.Random;

import formas.*;

public class JanelaPrincipal extends JFrame {

    private PainelDesenho painelDesenho;
    private JPanel painelBotoes;

    private JButton btnCirculo;
    private JButton btnQuadrado;
    private JButton btnTriangulo;
    private JButton btnEsfera;
    private JButton btnCubo;
    private JButton btnTetraedro;
    private JButton btnLimpar;

    private final Random random = new Random();

    public JanelaPrincipal() {
        setTitle("Gerador de Formas");
        setSize(900, 650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(new BorderLayout());

        // Painel responsável por desenhar as formas.
        painelDesenho = new PainelDesenho();
        add(painelDesenho, BorderLayout.CENTER);

        // Painel inferior dos botões.
        painelBotoes = new JPanel(new FlowLayout());

        // Criação dos botões.
        btnCirculo = new JButton("Círculo");
        btnQuadrado = new JButton("Quadrado");
        btnTriangulo = new JButton("Triângulo");
        btnEsfera = new JButton("Esfera");
        btnCubo = new JButton("Cubo");
        btnTetraedro = new JButton("Tetraedro");
        btnLimpar = new JButton("Limpar");

        // Adição dos botões ao painel.
        painelBotoes.add(btnCirculo);
        painelBotoes.add(btnQuadrado);
        painelBotoes.add(btnTriangulo);
        painelBotoes.add(btnEsfera);
        painelBotoes.add(btnCubo);
        painelBotoes.add(btnTetraedro);
        painelBotoes.add(btnLimpar);

        add(painelBotoes, BorderLayout.SOUTH);

        // Registro dos eventos dos botões.
        btnCirculo.addActionListener(e -> adicionarCirculo());
        btnQuadrado.addActionListener(e -> adicionarQuadrado());
        btnTriangulo.addActionListener(e -> adicionarTriangulo());
        btnEsfera.addActionListener(e -> adicionarEsfera());
        btnCubo.addActionListener(e -> adicionarCubo());
        btnTetraedro.addActionListener(e -> adicionarTetraedro());
        btnLimpar.addActionListener(e -> painelDesenho.limparFormas());
    }

    private void adicionarCirculo() {
        double raio = gerarTamanho();
        int diametro = (int) (raio * 2);

        int x = gerarPosicao(painelDesenho.getWidth(), diametro);
        int y = gerarPosicao(painelDesenho.getHeight(), diametro);

        Circulo circulo = new Circulo(x, y, raio, gerarCor());

        painelDesenho.addForma(circulo);
    }

    private void adicionarQuadrado() {
        double lado = gerarTamanho();

        int x = gerarPosicao(painelDesenho.getWidth(), (int) lado);
        int y = gerarPosicao(painelDesenho.getHeight(), (int) lado);

        Quadrado quadrado = new Quadrado(x, y, lado, gerarCor());

        painelDesenho.addForma(quadrado);
    }

    private void adicionarTriangulo() {
        double base = gerarTamanho();
        double altura = gerarTamanho();

        int x = gerarPosicao(painelDesenho.getWidth(), (int) base);
        int y = gerarPosicao(painelDesenho.getHeight(), (int) altura);

        Triangulo triangulo = new Triangulo(x, y, base, altura, gerarCor());

        painelDesenho.addForma(triangulo);
    }

    private void adicionarEsfera() {
        double raio = gerarTamanho();
        int diametro = (int) (raio * 2);

        int x = gerarPosicao(painelDesenho.getWidth(), diametro);
        int y = gerarPosicao(painelDesenho.getHeight(), diametro);

        Esfera esfera = new Esfera(x, y, raio, gerarCor());

        painelDesenho.addForma(esfera);
    }

    private void adicionarCubo() {
        double lado = gerarTamanho();
        int dimensao = (int) (lado * 1.5);

        int x = gerarPosicao(painelDesenho.getWidth(), dimensao);
        int y = gerarPosicao(painelDesenho.getHeight(), dimensao);

        Cubo cubo = new Cubo(x, y, lado, gerarCor());

        painelDesenho.addForma(cubo);
    }

    private void adicionarTetraedro() {
        double lado = gerarTamanho();

        int x = gerarPosicao(painelDesenho.getWidth(), (int) lado);
        int y = gerarPosicao(painelDesenho.getHeight(), (int) lado);

        Tetraedro tetraedro = new Tetraedro(x, y, lado, gerarCor());

        painelDesenho.addForma(tetraedro);
    }

    // Gera tamanhos aleatórios entre 20 e 50.
    private double gerarTamanho() {
        return 20 + random.nextDouble() * 30;
    }

    // Gera uma posição respeitando o tamanho da forma.
    private int gerarPosicao(int limite, int tamanho) {
        int espacoDisponivel = Math.max(1, limite - tamanho);

        return random.nextInt(espacoDisponivel);
    }

    // Gera uma cor aleatória utilizando o padrão RGB.
    private Color gerarCor() {
        return new Color(
            random.nextInt(256),
            random.nextInt(256),
            random.nextInt(256)
        );
    }
}
