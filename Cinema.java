package cinema;

import java.util.Scanner;

public class Cinema {

    public static void main(String[] args) {
        // Write your code here
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of rows:");
        int numberOfRows = scanner.nextInt();
        System.out.println("Enter the number of seats in each row:");
        int numberOfSeatsInRow = scanner.nextInt();
        char[][] cinema = new char[numberOfRows + 1][numberOfSeatsInRow + 1];
        System.out.println();

        createTheCinema(cinema, numberOfRows, numberOfSeatsInRow);
        mainChatBox(cinema, numberOfRows, numberOfSeatsInRow);

    }

    public static void mainChatBox(char[][] cinema, int numberOfRows, int numberOfSeatsInRow) {
        int choice = 1;
        int income = 0;
        int amountOfPeopleInCinema = 0;
        do {
            System.out.println("1. Show the seats");
            System.out.println("2. Buy a ticket");
            System.out.println("3. Statistics");
            System.out.println("0. Exit");
            Scanner scanner = new Scanner(System.in);
            choice = scanner.nextInt();

            switch (choice) {
                case 1 -> showCinema(cinema, numberOfRows, numberOfSeatsInRow);
                case 2 -> {
                    int ticketBuyOperation = buyTicket(cinema, numberOfRows, numberOfSeatsInRow);
                    if (ticketBuyOperation != 0) {
                        income += ticketBuyOperation;
                        amountOfPeopleInCinema++;
                    }
                }
                case 3 -> showStatistic(income, amountOfPeopleInCinema, numberOfRows, numberOfSeatsInRow);
                default -> choice = 0;
            }

        } while (choice != 0);
    }

    public static void createTheCinema(char[][] cinema, int numberOfRows, int numberOfSeatsInRow) {
        int numbers = 49;
        for (int i = 0; i < numberOfRows + 1; i++) {
            if (i == 0) {
                cinema[0][0] = ' ';
            }
            cinema[0][i] = (char) numbers;
            numbers++;
        }

        numbers = 49;

        for (int i = 1; i < numberOfRows + 1; i++) {
            cinema[i][0] = (char) numbers;
            numbers++;
            for (int j = 1; j < numberOfSeatsInRow + 1; j++) {
                cinema[i][j] = 'S';
            }
        }
    }

    public static int buyTicket(char[][] cinema, int numberOfRows, int numberOfSeatsInRow) {
        Scanner scanner = new Scanner(System.in);
        int tickedPicked = 0;
        int price = 0;
        int test = 0;
        do {
            int busySeatRow = 0;
            int busySeatNumber = 0;
            do {
                if (test != 0) {
                    System.out.println("Wrong input!");
                }
                System.out.println("Enter a row number:");
                busySeatRow = scanner.nextInt();
                System.out.println("Enter a seat number in that row:");
                busySeatNumber = scanner.nextInt();
                test++;
            } while (busySeatRow > numberOfRows || busySeatRow <= 0 || busySeatNumber > numberOfSeatsInRow || busySeatNumber <= 0);

            System.out.println();
            if (cinema[busySeatRow][busySeatNumber] == 'B') {
                System.out.println("That ticket has already been purchased!");
            } else {
                if (numberOfRows * numberOfSeatsInRow <= 60) {
                    System.out.println("Ticket price: $10");
                    cinema[busySeatRow][busySeatNumber] = 'B';
                    System.out.println();
                    price = 10;
                } else {
                    int half = numberOfRows / 2;
                    if (half >= busySeatRow) {
                        System.out.println("Ticket price: $10");
                        cinema[busySeatRow][busySeatNumber] = 'B';
                        System.out.println();
                        price = 10;
                    } else {
                        System.out.println("Ticket price: $8");
                        cinema[busySeatRow][busySeatNumber] = 'B';
                        System.out.println();
                        price = 8;
                    }
                }
                tickedPicked = 1;
            }

        } while (tickedPicked == 0);

        return price;
    }

    public static void showCinema(char[][] cinema, int numberOfRows, int numberOfSeatsInRow) {
        System.out.println("Cinema:");
        for (int i = 0; i < numberOfRows + 1; i++) {
            if (i == 0) {
                System.out.print("  ");
            }
            for (int j = 0; j < numberOfSeatsInRow + 1; j++) {
                System.out.print(cinema[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void showStatistic(int income, int amountOfPeopleInCinema, int numberOfRows, int numberOfSeatsInRow) {
        System.out.println();
        System.out.printf("Number of purchased tickets: %d%n", amountOfPeopleInCinema);
        System.out.printf("Percentage %.2f%%%n", (float)amountOfPeopleInCinema * 100.00 / (float)(numberOfRows * numberOfSeatsInRow));
        System.out.printf("Current income: $%d%n", income);
        int totalIncome = 0;
        if (numberOfRows * numberOfSeatsInRow <= 60) {
            totalIncome = numberOfRows * numberOfSeatsInRow * 10;
            System.out.printf("Total income: $%d", totalIncome);
        } else {
            int half = numberOfRows / 2;
            totalIncome = (numberOfSeatsInRow * half * 10) + (numberOfSeatsInRow * (numberOfRows - half) * 8);
            System.out.printf("Total income: $%d%n", totalIncome);
        }
        System.out.println();
    }
}