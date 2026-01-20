import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuUI extends JPanel {
    public MenuUI(GameWindow gameWindow) {
        // create buttons
        JButton startButton = new JButton("Start");
        JButton exitButton = new JButton("Exit");

        // create game title
        JLabel gameTitle = new JLabel("Clicker Game");

        // set Layout for this
        setLayout(new BorderLayout());

        // orient and add the buttons
        JPanel buttons = new JPanel(new GridLayout(2, 1, 10, 10));
        buttons.setOpaque(false);
        buttons.add(startButton);
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


        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameWindow.switchToGameUI();
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
