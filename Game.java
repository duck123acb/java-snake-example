import java.util.ArrayList;

public class Game {
    static final int ROWS = 20;
    static final int COLUMNS = 20;
    static final int CELL_SIZE = 32;

    ArrayList<Cell> snake;
    Direction direction;
    
    private Cell head;
    private Cell apple;

    Game() {
        snake = new ArrayList<>();
        snake.add(new Cell(ROWS / 2, 7));
        snake.add(new Cell(ROWS / 2, 6));
        snake.add(new Cell(ROWS / 2, 5));
        snake.add(new Cell(ROWS / 2,4));
        head = snake.get(0);
    }

    private void moveSnake() {
        // tail
        for (int i = snake.size() - 1; i > 0; i--) {
            Cell current = snake.get(i);
            Cell previous = snake.get(i - 1);

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

    private void eat() {
        if (head != apple) {
            return;
        }

        snake.add(snake.get(snake.size() - 1));
    }

    void update() {
        eat();
        moveSnake();

    }
}
