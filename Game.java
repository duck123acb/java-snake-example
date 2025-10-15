import java.util.ArrayList;

public class Game {
    static final int ROWS = 20;
    static final int COLUMNS = 20;
    static final int CELL_SIZE = 32;

    ArrayList<Cell> snake;
    Direction direction;
    
    private Cell head;

    Game() {
        snake = new ArrayList<>();
        snake.add(new Cell(ROWS / 2, COLUMNS / 2));
        head = snake.get(0);
    }

    void update() {
        // tail
        for (int i = 1; i < snake.size(); i++) {
            Cell current = snake.get(i);
            Cell previous = snake.get(i-1); 

            current.row = previous.row;
            current.column = previous.column;

            current.updateCoordinates();
        }

        // head
        if (direction == null) {
            direction = Direction.RIGHT;
        }
        switch (direction) {
            case Direction.UP:
                head.row--;
                break;

            case Direction.DOWN:
                head.row++;
                break;

            case Direction.LEFT:
                head.column--;
                break;
        
            default:
                head.column++;
                break;
        }
        head.updateCoordinates();
    }
}
