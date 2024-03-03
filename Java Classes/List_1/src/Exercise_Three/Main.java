package Exercise_Three;

public class Main {
    public static void main(String[] args) {
        DiskCollection collection = new DiskCollection();
        DataCollector collect = new DataCollector();
        boolean runProgram = true;

        while (runProgram) {
            System.out.println("******** MENU ********");
            System.out.println("1 - Wyświetl kolekcje - 1");
            System.out.println("2 - Dodaj album do kolekcji - 2");
            System.out.println("3 - Wyjscie z programu - 3");

            int decision = collect.getIntValue();

            switch (decision) {
                case 1:
                    collection.printCollection();
                    break;
                case 2:
                    collection.addAlbumToCollection();
                    break;
                case 3:
                    runProgram = false;
                    collect.closeScanner();
                    break;
                default:
                    System.out.println("That is not an valid option");
                    break;
            }


        }
    }
}
