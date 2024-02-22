package tictactoe;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        char[][] grid = new char[][]{ {' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '} };
        char playerSymbol = 'X';
        int endGame = 0;
        printGrid(grid);
        do {
            boolean isSpace = true;
            inputCoordinate(grid, playerSymbol);
            printGrid(grid);

            switch (getResult(grid)) {
                case 0 -> {
                    System.out.println("Impossible");
                    endGame = 1;
                }
                case 1 -> {
                    System.out.println("X wins");
                    endGame = 1;
                }
                case 2 -> {
                    System.out.println("O wins");
                    endGame = 1;
                }
                case 4 -> {
                    System.out.println("Draw");
                    endGame = 1;
                }
                default -> {
                }
            }

            if (playerSymbol == 'X') {
                playerSymbol = 'O';
            } else {
                playerSymbol = 'X';
            }
        } while (endGame == 0);
    }

    static void printGrid(char[][] grid) {
        System.out.println("---------");
        for (int i = 0; i < grid.length; i++) {
            System.out.print("| ");
            for (int j = 0; j < grid[i].length; j++) {
                if (j == grid[i].length - 1) {
                    System.out.print(grid[i][j]);
                } else {
                    System.out.print(grid[i][j] + " ");
                }
            }
            System.out.println(" |");
        }
        System.out.println("---------");
    }

    static void inputCoordinate(char[][] grid, char playerSymbol) {
        Scanner scanner = new Scanner(System.in);
        int SymbolX;
        int SymbolY;
        int control;
        do {
            control = 0;
            String coordinates = scanner.nextLine();

            while ((int)coordinates.charAt(0) < 48 || (int)coordinates.charAt(2) > 57) {
                System.out.println("You should enter numbers!");
                coordinates = scanner.nextLine();
                control = 1;
            }

            SymbolX = (int)coordinates.charAt(0) - 49;
            SymbolY = (int)coordinates.charAt(2) - 49;

            if (SymbolX > 2 || SymbolY > 2 || SymbolX < 0 || SymbolY < 0) {
                System.out.println("Coordinates should be from 1 to 3!");
                control = 1;
                continue;
            }

            if (grid[SymbolX][SymbolY] != ' ') {
                System.out.println("This cell is occupied! Choose another one!");
                control = 1;
            }
        } while (control == 1);

        grid[SymbolX][SymbolY] = playerSymbol;

    }

    static int getResult(char[][] grid) {
        int amountOfX = 0;
        int amountOfO = 0;
        for (char[] chars : grid) {
            for (char aChar : chars) {
                if (aChar == 'X')
                    amountOfX++;
                else if (aChar == 'O')
                    amountOfO++;
            }
        }

        if (amountOfX - amountOfO >= 2 || amountOfO - amountOfX >= 2) {
            return 0;
        } else {
            int XWins = winningCombination(grid, 'X');
            int OWins = winningCombination(grid, 'O');

            if (XWins > 0 && OWins > 0) {
                return 0;
            } else if (XWins > 0) {
                return 1;
            } else if (OWins > 0){
                return 2;
            } else {
                for (char[] chars : grid) {
                    for (char aChar : chars) {
                        if (aChar == ' ' || aChar == '_') {
                            return 3;
                        }
                    }
                }
                return 4;
            }

        }

    }

    static int winningCombination(char[][] grid, char symbol) {
        int winningLines = 0;
        // Horizontal lines
        for (int i = 0; i < grid.length; i++) {
            int amountOfSameSymbols = 0;
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == symbol) {
                    amountOfSameSymbols++;
                }
            }

            if (amountOfSameSymbols == grid.length) {
                winningLines++;
            }
        }

        // Vertical lines
        for (int i = 0; i < grid.length; i++) {
            int amountOfSameSymbols = 0;
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[j][i] == symbol) {
                    amountOfSameSymbols++;
                }
            }

            if (amountOfSameSymbols == grid.length) {
                winningLines++;
            }
        }

        // First diagonal
        int amountOfSameSymbols = 0;
        for (int i = 0; i < grid.length; i++) {
            if (grid[i][i] == symbol) {
                amountOfSameSymbols++;
            }

            if (amountOfSameSymbols == grid.length) {
                winningLines++;
            }
        }

        // Second diagonal
        amountOfSameSymbols = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (j + i == grid.length - 1) {
                    if (grid[i][j] == symbol) {
                        amountOfSameSymbols++;
                    }
                }
            }

            if (amountOfSameSymbols == grid.length) {
                winningLines++;
            }
        }

        return winningLines;
    }

}


