public class Cell {
    int x, y;
    int row, column;

    Cell(int row, int column) { 
        this.row = row;
        this.column = column;
        updateCoordinates();
    }

    void updateCoordinates() {
        x = column * Game.CELL_SIZE;
        y = row * Game.CELL_SIZE;
    }

    public boolean equals(Cell obj) {
        return (this.x == obj.x && this.y == obj.y);
    }
}
