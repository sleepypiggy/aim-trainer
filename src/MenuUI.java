import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuUI extends JPanel {
    public MenuUI(GameWindow gameWindow) {
        JButton startButton = new JButton("Start");
        JButton exitButton = new JButton("Exit");
        add(startButton);
        add(exitButton);

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
