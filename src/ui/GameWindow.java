package ui;

import javax.swing.*;
import java.awt.*;

public class GameWindow extends JFrame {
    private CardLayout cardLayout;
    private JPanel mainPanel;
    private GameUI game = new GameUI(this);
    private MenuUI menu = new MenuUI(this, game);
    private GameOverUI gameOver = new GameOverUI(this);

    public GameWindow() {
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 800);
        setLocationRelativeTo(null);
        setResizable(false);

        mainPanel.add(menu, "Menu");
        mainPanel.add(game, "Game");
        mainPanel.add(gameOver, "Game Over");

        add(mainPanel);

        setVisible(true);
    }

    public void switchToGameUI() {
        cardLayout.show(mainPanel, "Game");
    }

    public void switchToGameOverUI(GameUI game) {
        gameOver.setFinalScore(game.returnScore());
        cardLayout.show(mainPanel, "Game Over");
    }
}
