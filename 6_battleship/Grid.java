package battleship;

public class Grid {

    public Field[][] grid;
    private final int SIZE = 11;


    Grid() {
        this.grid = new Field[SIZE - 1][SIZE];

        // Creation of board layers
        char lettersOrder = 'A';
        for (int i = 0; i < SIZE - 1; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (j == 0) {
                    this.grid[i][j] = new Field(lettersOrder++, 0, i, true, true);
                } else {
                    this.grid[i][j] = new Field('~', j, i, false, false);
                }
            }
        }

    }

    public void show() {
        System.out.print("  ");
        for (int i = 1; i < SIZE; i++) {
            System.out.print(i + " ");
        }
        System.out.println();

        for (Field[] row : this.grid) {
            for (Field field : row) {
                System.out.print(field.value + " ");
            }
            System.out.println();
        }
    }

    private int[] createOperationCoordinates(String[] coordinates) {
        int[] positions = new int[4];
        if (coordinates[0].length() == 2) {
            positions[0] = Character.getNumericValue(coordinates[0].charAt(0)) - 10;
            positions[1] = Character.digit(coordinates[0].charAt(1), 10);
        } else if (coordinates[0].length() == 3) {
            if (coordinates[0].charAt(1) == '1' && coordinates[0].charAt(2) == '0') {
                positions[0] = Character.getNumericValue(coordinates[0].charAt(0)) - 10;
                positions[1] = 10;
            } else {
                // Returning wrong input to exit the insertion
                return new int[]{-1, -1};
            }
        } else {
            // Returning wrong input to exit the insertion
            return new int[]{-1, -1};
        }

        if (coordinates[1].length() == 2) {
            positions[2] = Character.getNumericValue(coordinates[1].charAt(0)) - 10;
            positions[3] = Character.digit(coordinates[1].charAt(1), 10);
        } else if (coordinates[1].length() == 3) {
            if (coordinates[1].charAt(1) == '1' && coordinates[1].charAt(2) == '0') {
                positions[2] = Character.getNumericValue(coordinates[1].charAt(0)) - 10;
                positions[3] = 10;
            } else {
                // Returning wrong input to exit the insertion
                return new int[]{-1, -1};
            }
        } else {
            // Returning wrong input to exit the insertion
            return new int[]{-1, -1};
        }

        // Check if coordinates are correct to operate
        if (positions[0] < 0 || positions[0] > this.SIZE ||
                positions[1] < 0 || positions[1] > this.SIZE ||
                positions[2] < 0 || positions[2] > this.SIZE ||
                positions[3] < 0 || positions[3] > this.SIZE) {
            // Returning wrong input to exit the insertion
            return new int[]{-1, -1};
        }

        if (positions[0] > positions[2]) {
            int hel = positions[0];
            positions[0] = positions[2];
            positions[2] = hel;
        } else if (positions[1] > positions[3]) {
            int hel = positions[1];
            positions[1] = positions[3];
            positions[3] = hel;
        }

        return positions;
    }

    public boolean insert(String[] coordinates, int shipSize) {

        int[] cords = createOperationCoordinates(coordinates);

        /*
        Values of cords in array
        0 - begin of vertical alignment
        1 - begin of horizontal alignment
        2 - end of vertical alignment
        3 - end of horizontal alignment
        */

        if (cords.length == 2) {
            System.out.println("Error! Given Coordinates are impossible to insert on board!");
            return false;
        }

        // Useless?
        int[] insertPosition = new int[shipSize];

        if (cords[0] == cords[2]) {
            for (int i = 0; i < shipSize; i++) {
                this.grid[cords[0]][cords[1] + i].setOccupied(true);
            }

        } else if (cords[1] == cords[3]) {
            for (int i = 0; i < shipSize; i++) {
                this.grid[cords[0] + i][cords[1]].setOccupied(true);
            }

        } else {
            System.out.println("Error! Cannot handle the operation");
            return false;
        }

        return true;
    }

}
