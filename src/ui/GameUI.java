package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class GameUI extends JPanel {
    int scoreCounter = 0;
    private Random random = new Random();
    private JLabel scoreDisplay = new JLabel(String.valueOf(scoreCounter));
    private JButton button;
    private ImageIcon buttonImage;
    private ImageIcon buttonClickedImage;

    public GameUI(GameWindow gameWindow) {

        //set layout of this
        setLayout(null);

        // start game loop
        addNewButton();
    }

    private void addNewButton() {
        decorateButton();
        button = new JButton(buttonImage);
        invisibleStockButton();
        decorateClickedButton();
        add(button);
        add(scoreDisplay);
        int xpos = random.nextInt(0, 600);
        int ypos = random.nextInt(0 , 600);
        scoreDisplay.setBounds(25, 25, 50, 50);
        button.setBounds(xpos, ypos, 72, 52);
        revalidate();
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                remove(button);
                scoreCounter++;
                addNewButton();
                scoreDisplay.setText(String.valueOf(scoreCounter));
                revalidate();
                repaint();
            }
        });
    }

    public int returnScore() {
        return scoreCounter;
    }

    private void decorateButton() {
        buttonImage = new ImageIcon(getClass().getResource("/assets/layer1.png"));
        Image buttonImageScaled = buttonImage.getImage().getScaledInstance(72, 52, Image.SCALE_SMOOTH);
        buttonImage = new ImageIcon(buttonImageScaled);
    }

    private void decorateClickedButton() {
        buttonClickedImage = new ImageIcon(getClass().getResource("/assets/layer2.png"));
        Image buttonClickedImageScaled = buttonClickedImage.getImage().getScaledInstance(72, 52, Image.SCALE_SMOOTH);
        buttonClickedImage = new ImageIcon(buttonClickedImageScaled);
        button.setPressedIcon(buttonClickedImage);
    }

    private void invisibleStockButton() {
        button.setBorderPainted(false);
        button.setOpaque(false);
        button.setContentAreaFilled(false);
        button.setFocusPainted(false);
    }
}

