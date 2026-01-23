package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuUI extends JPanel {
    private Timer timer;
    private int timerCounter = 5;
    private ImageIcon playButtonImage;
    private Image playButtonImageScaled;
    private ImageIcon exitButtonImage;
    private Image exitButtonImageScaled;
    private ImageIcon playButtonClickedImage;
    private Image playButtonClickedImageScaled;
    private ImageIcon exitButtonClickedImage;
    private Image exitButtonClickedImageScaled;

    public MenuUI(GameWindow gameWindow, GameUI game) {
        // create button images
        playButtonImage = new ImageIcon(getClass().getResource("/assets/ClickIcon.png"));
        playButtonImageScaled = playButtonImage.getImage().getScaledInstance(90, 65, Image.SCALE_SMOOTH);
        playButtonImage = new ImageIcon(playButtonImageScaled);

        exitButtonImage = new ImageIcon(getClass().getResource("/assets/ExitIcon.png"));
        exitButtonImageScaled = exitButtonImage.getImage().getScaledInstance(90,65, Image.SCALE_SMOOTH);
        exitButtonImage = new ImageIcon(exitButtonImageScaled);

        // button clicked images
        playButtonClickedImage = new ImageIcon(getClass().getResource("/assets/PlayIconClick.png"));
        playButtonClickedImageScaled = playButtonClickedImage.getImage().getScaledInstance(90, 65, Image.SCALE_SMOOTH);
        playButtonClickedImage = new ImageIcon(playButtonClickedImageScaled);

        exitButtonClickedImage = new ImageIcon(getClass().getResource("/assets/ExitIconClick.png"));
        exitButtonClickedImageScaled = exitButtonClickedImage.getImage().getScaledInstance(90, 65, Image.SCALE_SMOOTH);
        exitButtonClickedImage = new ImageIcon(exitButtonClickedImageScaled);

        // create buttons
        JButton playButton = new JButton(playButtonImage);
        playButton.setContentAreaFilled(false);
        playButton.setBorderPainted(false);
        playButton.setOpaque(false);
        playButton.setFocusPainted(false);

        JButton exitButton = new JButton(exitButtonImage);
        exitButton.setContentAreaFilled(false);
        exitButton.setBorderPainted(false);
        exitButton.setOpaque(false);
        exitButton.setFocusPainted(false);

        // assign button clicked image
        playButton.setPressedIcon(playButtonClickedImage);
        exitButton.setPressedIcon(exitButtonClickedImage);

        // create game title
        JLabel gameTitle = new JLabel("Clicker Game");

        // create timer
        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(timerCounter);
                timerCounter--;
                if (timerCounter == -1) {
                    gameWindow.switchToGameOverUI(game);
                    timer.stop();
                }
            }
        });

        // set Layout for this
        setLayout(new BorderLayout());

        // orient and add the buttons
        JPanel buttons = new JPanel(new GridLayout(1, 2, 10, 10));
        buttons.setOpaque(false);
        buttons.add(playButton);
        buttons.add(exitButton);

        // container for the buttons for easy movement
        JPanel buttonContainer = new JPanel(new GridBagLayout());

        buttonContainer.add(buttons);

        //container for game title for easy movement
        JPanel titleContainer = new JPanel(new GridBagLayout());
        titleContainer.setPreferredSize(new Dimension(400, 400));
        titleContainer.add(gameTitle);

        // add buttons to this, add constraint to place at bottom half
        add(buttonContainer, BorderLayout.CENTER);

        // add game title to this
        add(titleContainer, BorderLayout.NORTH);


        playButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameWindow.switchToGameUI();
                timer.start();
            }
        });

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
}
