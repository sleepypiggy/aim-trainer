import javax.swing.*;
import java.awt.*;

public class GameWindow extends JFrame {
    private CardLayout cardLayout;
    private JPanel mainPanel;
    private MenuUI menu = new MenuUI(this);
    private GameUI game = new GameUI();

    public GameWindow() {
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 800);
        setLocationRelativeTo(null);
        setResizable(false);

        mainPanel.add(menu, "Menu");
        mainPanel.add(game, "Game");

        add(mainPanel);

        setVisible(true);
    }

    public void switchToGameUI() {
        cardLayout.show(mainPanel, "Game");
    }
}
