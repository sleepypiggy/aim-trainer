package ui;

import javax.swing.*;

public class GameOverUI extends JPanel {
    private JLabel finalScoreLabel;
    private JLabel gameOverLabel;

    public GameOverUI(GameWindow gameWindow) {
        gameOverLabel = new JLabel("Game Over");
        finalScoreLabel = new JLabel();
        add(gameOverLabel);
        add(finalScoreLabel);
    }

    public void setFinalScore(int score) {
        finalScoreLabel.setText("Final Score: " + score);
    }

}
