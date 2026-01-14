import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class GameUI extends JPanel {
    private int scoreCounter = 0;
    private int timerCounter = 0;
    private Random random = new Random();
    private JLabel scoreDisplay = new JLabel(String.valueOf(scoreCounter));

    public GameUI() {
        setLayout(null);
        addNewButton();
        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(timerCounter);
                timerCounter++;
                if (timerCounter == 5) {
                   try {
                       Thread.sleep(5000);
                   } catch (InterruptedException ex) {
                       System.out.println("Something went wrong... ");
                   }
                }
            }
        });
        timer.start();
    }

    private void addNewButton() {
        JButton button = new JButton("Click!");
        add(button);
        add(scoreDisplay);
        int xpos = random.nextInt(0, 600);
        int ypos = random.nextInt(0 , 600);
        scoreDisplay.setBounds(25, 25, 50, 50);
        button.setBounds(xpos, ypos, 50, 50);
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
}

