package battleship;

public class Field {

    char value;
    int verticalPosition;
    int horizontalPosition;
    private boolean occupied;


    private boolean special;
    boolean partOfTheShip;

    public Field(char value, int verticalPosition, int horizontalPosition, boolean occupied, boolean special) {
        this.value = value;
        this.verticalPosition = verticalPosition;
        this.horizontalPosition = horizontalPosition;
        this.occupied = occupied;
        this.special = special;
        this.partOfTheShip = false;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public boolean isSpecial() {
        return special;
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
