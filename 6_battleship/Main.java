package battleship;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Grid grid = new Grid();
        grid.show();

        final Ships[] availableShips = Ships.values();
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < availableShips.length; i++) {
            System.out.println("Enter the coordinates of the " + availableShips[i].name +
                    " (" + availableShips[i].size + " cells):");
            String[] coordinates = new String[2];
            coordinates[0] = scanner.next();
            coordinates[1] = scanner.next();

            if (!grid.insert(coordinates, availableShips[i].size)) {
                i--;
            } else {
                grid.show();
            }
        }
    }
}
