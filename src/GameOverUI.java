import javax.swing.*;
import java.awt.*;

public class GameOverUI extends JPanel {

    public GameOverUI(GameWindow gameWindow) {
        JLabel gameOverText = new JLabel("Game Over");
        add(gameOverText);
    }

}
