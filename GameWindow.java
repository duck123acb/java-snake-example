import javax.swing.*;
import java.awt.event.*;

public class GameWindow extends JFrame {
    private Game game;
    private GamePanel panel;

    public GameWindow() {
        setTitle("Snake");
        setSize(Game.CELL_SIZE * Game.COLUMNS, Game.CELL_SIZE * Game.ROWS);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        game = new Game();
        panel = new GamePanel(game);
        add(panel);
        
        panel.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                getDirection(e.getKeyCode());
            }
        });
        
        // label = new JLabel("Press any key...", SwingConstants.CENTER);
        // add(label);
        panel.setFocusable(true);
        panel.requestFocusInWindow();

        Timer timer = new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.update();
                panel.repaint(); // redraw the panel
            }
        });
        timer.start();

        requestFocusInWindow();
    }

    public void getDirection(int keyCode) {
        // technically i should check for if they are also already going that way but eh
        if ((keyCode == KeyEvent.VK_W || keyCode == KeyEvent.VK_UP) && game.direction != Direction.DOWN) {
            game.direction = Direction.UP;
        } else if ((keyCode == KeyEvent.VK_S || keyCode == KeyEvent.VK_DOWN) && game.direction != Direction.UP) {
            game.direction = Direction.DOWN;
        } else if ((keyCode == KeyEvent.VK_R || keyCode == KeyEvent.VK_RIGHT) && game.direction != Direction.LEFT) {
            game.direction = Direction.RIGHT;
        } else if ((keyCode == KeyEvent.VK_A || keyCode == KeyEvent.VK_LEFT) && game.direction != Direction.RIGHT) {
            game.direction = Direction.LEFT;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new GameWindow().setVisible(true));
    }
}