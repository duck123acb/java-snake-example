import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
    private Game game;

    public GamePanel(Game game) {
        this.game = game;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.GREEN);

        for (Cell cell : game.snake) {
            g.fillRect(cell.x, cell.y, Game.CELL_SIZE, Game.CELL_SIZE);
        }
    }
}
