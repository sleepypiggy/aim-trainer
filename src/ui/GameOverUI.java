package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameOverUI extends JPanel {
    private JLabel finalScoreLabel;
    private JLabel gameOverLabel;
    private JButton playAgainButton;
    private JButton exitButton;

    public GameOverUI(GameWindow gameWindow) {
        // sets the layout of this
        setLayout(new BorderLayout());

        gameOverLabel = new JLabel("Game Over");
        finalScoreLabel = new JLabel();

        JPanel finalInfo = new JPanel(new GridLayout(2, 1, 10, 10));
        finalInfo.setOpaque(false);
        finalInfo.add(gameOverLabel);
        finalInfo.add(finalScoreLabel);

        JPanel finalInfoContainer = new JPanel(new GridBagLayout());
        finalInfoContainer.add(finalInfo);

        add(finalInfoContainer, BorderLayout.NORTH);

        playAgainButton = new JButton("Play Again");
        exitButton = new JButton("Exit");

        JPanel buttonGrid = new JPanel(new GridLayout(1, 2, 10, 10));
        buttonGrid.add(playAgainButton);
        buttonGrid.add(exitButton);

        JPanel buttonContainer = new JPanel(new GridBagLayout());
        buttonContainer.add(buttonGrid);
        add(buttonContainer);


        playAgainButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameWindow.switchToGameUI();
                //timer.start();
            }
        });

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        }

    public void setFinalScore(int score) {
        finalScoreLabel.setText("Final Score: " + score);
    }

}
