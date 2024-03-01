package Exercise_Three;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        DiskCollection collection = new DiskCollection();
        boolean runProgram = true;
        Scanner scanner = new Scanner(System.in);

        while (runProgram) {
            System.out.println("******** MENU ********");
            System.out.println("1 - Wyświetl kolekcje - 1");
            System.out.println("2 - Dodaj album do kolekcji - 2");
            System.out.println("3 - Wyjscie z programu - 3");

            int decision = scanner.nextInt();

            switch (decision) {
                case 1:
                    collection.printCollection();
                    break;
                case 2:
                    collection.addAlbumToCollection();
                    break;
                case 3:
                    runProgram = false;
                    break;
                default:
                    System.out.println("That is not an valid option");
                    break;
            }

        }
    }
}
