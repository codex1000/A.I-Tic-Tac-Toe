import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.JFrame;

public class Frame extends JPanel {
    private JFrame frame;
    public static final int HEIGHT = 800;
    public static final int WIDTH = 800;
    public static final String TITLE = "Tic-Tac-Toe";

    public Frame(Game game) {
        frame = new JFrame(TITLE);
        frame.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        frame.setMaximumSize(new Dimension(WIDTH, HEIGHT));
        frame.setMinimumSize(new Dimension(WIDTH, HEIGHT));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.add(game);
        frame.setVisible(true);
        game.start();
    }
}