import java.util.ArrayList;

public class Game {
    static final int ROWS = 20;
    static final int COLUMNS = 20;
    static final int CELL_SIZE = 32;

    ArrayList<Cell> snake;
    Cell apple;
    Direction direction;
    
    private Cell head;

    Game() {
        apple = new Cell(0, 0);
        moveApple();

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
        if (!head.equals(apple)) {
            return;
        }

        moveApple();
        Cell tail = snake.get(snake.size() - 1);
        snake.add(new Cell(tail.row, tail.column));
    }

    private void moveApple() {
        int x = (int)(Math.random() * COLUMNS-1);
        int y = (int)(Math.random() * ROWS-1);

        apple.column = x;
        apple.row = y;
        apple.updateCoordinates();
    }

    void update() {
        eat();
        moveSnake();
    }
}