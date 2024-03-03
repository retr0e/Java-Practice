package Exercise_Three;

import java.util.Scanner;

public class DataCollector {
    private Scanner scanner;

    public DataCollector() {
        this.scanner = new Scanner(System.in);
    }

    public int getIntValue() {
        int value = 0;
        boolean validInput = false;

        do {
            try {
//                System.out.println("Podaj liczbe calkowitoliczbowa");
                value = scanner.nextInt();
                validInput = true;
            } catch (Exception e) {
                System.out.println("Podaj prawidłową liczbę całkowitoliczbową");
                scanner.nextLine();
            }
        } while (!validInput);

        return value;
    }

    public String getStringValue() {
        return scanner.nextLine();
    }

    public double getDoubleValue() {
        double value = 0.0;
        boolean validInput = false;

        do {
            try {
//                System.out.println("Podaj liczbę zmiennoprzecinkową");
                value = scanner.nextDouble();
                validInput = true;
            } catch (Exception e) {
                System.out.println("Podaj prawidłową liczbę zmiennoprzecinkową");
                scanner.nextLine();
            }
        } while (!validInput);

        return value;
    }

    public void closeScanner() {
        scanner.close();
    }
}
