package Exercise_One;

import Exercise_Three.DataCollector;


class Grade {
    public static void main(String[] args) {
        int gradesNumber = 0;
        int gradesCounter = 0;
        double gradesAverage = 0.0;
        DataCollector collect = new DataCollector();
        System.out.println("Podaj ile przedmiotów chcesz podać: ");

        gradesNumber = collect.getIntValue();


        while (gradesCounter != gradesNumber) {
            System.out.print("Podaj ocene: ");
            gradesAverage += collect.getDoubleValue();
            gradesCounter++;
        }

        gradesAverage /= gradesNumber;
        System.out.println("Średnia ocen: " + gradesAverage);

        if (gradesAverage > 4.1) {
            System.out.println("Uczniowi przysługuje stypednium");
        }

        collect.closeScanner();
    }
}
