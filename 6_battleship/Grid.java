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
                positions[1] <= 0 || positions[1] > this.SIZE ||
                positions[2] < 0 || positions[2] > this.SIZE ||
                positions[3] <= 0 || positions[3] > this.SIZE) {
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

    private boolean isClearBorders(Field middle) {
        int leftVerticalField = middle.verticalPosition - 1;
        int rightVerticalField = middle.verticalPosition + 1;

        boolean skipOutRow = false;
        boolean skipOutCol = middle.horizontalPosition + 1 < this.SIZE;
        if (skipOutCol) {
            rightVerticalField--;
        }
        for (int i = middle.horizontalPosition - 1; i <= middle.horizontalPosition + 1; i++) {
            if (i == -1) {
                i = 0;
                for (int j = leftVerticalField; j <= rightVerticalField; j++) {
                    if (this.grid[i][j].isOccupied() || this.grid[i][j].isSpecial()) {
                        return false;
                    }
                }
            } else if (i == 8) {
                skipOutRow = true;
                for (int j = leftVerticalField; j <= rightVerticalField; j++) {
                    if (this.grid[i][j].isOccupied() || this.grid[i][j].isSpecial()) {
                        return false;
                    }
                }
            } else {
                for (int j = leftVerticalField; j <= rightVerticalField; j++) {
                    if (this.grid[i][j].isOccupied() || this.grid[i][j].isSpecial()) {
                        return false;
                    }
                }

                if (skipOutRow) {
                    i++;
                }
            }

        }

        return true;
    }
    private boolean checkSurrounding(Field sourcePosition, boolean horizontalPosition) {
        // Check in horizontal orientation
        if (horizontalPosition) {
            // Check if any other ships won't collide with a new one
            if (isClearBorders(sourcePosition)) {
                // Setting the occupation zone by new field
                System.out.println("czysto");
            } else {
                System.out.println("zajete");
                return false;
            }
        // Check in vertical orientation
        } else {

        }

        return true;
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

        int control = 0;
        if (cords[0] == cords[2]) {
            for (int i = 0; i < shipSize; i++) {
                if (checkSurrounding(this.grid[cords[0]][cords[1] + i], true)) {
                    this.grid[cords[0]][cords[1] + i].setOccupied(true);
                    control++;
                } else {
                    // Loading unchanged grid and throwing an error (false)

                    return false;
                }
            }

        } else if (cords[1] == cords[3]) {
            for (int i = 0; i < shipSize; i++) {
                if (checkSurrounding(this.grid[cords[0] + i][cords[1]], false)) {
                    this.grid[cords[0] + i][cords[1]].setOccupied(true);

                } else {

                }
            }

        } else {
            System.out.println("Error! Cannot handle the operation");
            return false;
        }

        return true;
    }

}
