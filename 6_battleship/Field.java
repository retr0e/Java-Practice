package battleship;

public class Field {

    char value;
    int verticalPosition;
    int horizontalPosition;
    private boolean occupied;
    boolean special;

    public Field(char value, int verticalPosition, int horizontalPosition, boolean occupied, boolean special) {
        this.value = value;
        this.verticalPosition = verticalPosition;
        this.horizontalPosition = horizontalPosition;
        this.occupied = occupied;
        this.special = special;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public void setOccupied(boolean occupied) {
        if (occupied) {
            this.value = 'O';
        } else {
            this.value = '~';
        }
        this.occupied = occupied;
    }
}
