import java.util.Scanner;

class Grade {
    public static void main(String[] args) {
        int gradesNumber = 0;
        int gradesCounter = 0;
        double gradesAverage = 0.0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj ile przedmiotów chcesz podać: ");

        try {
            gradesNumber = scanner.nextInt();
        } catch (Exception e) {
            System.err.println("Error occured during reading data");
            scanner.next();
        }

        while (gradesCounter != gradesNumber) {
            System.out.print("Podaj ocene: ");
            try {
                gradesAverage += scanner.nextDouble();
            } catch (Exception e) {
                System.err.println("Error occured during reading data");
                scanner.next();
            }
            gradesCounter++;
        }

        scanner.close();
        gradesAverage /= gradesNumber;
        System.out.println("Średnia ocen: " + gradesAverage);

        if (gradesAverage > 4.1) {
            System.out.println("Uczniowi przysługuje stypednium");
        }
    }
}
