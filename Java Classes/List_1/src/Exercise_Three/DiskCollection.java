package Exercise_Three;

import java.util.Scanner;

public class DiskCollection {
    private int albumsAmount;
    private DiskCD[] collection;

    public DiskCollection() {
        this.albumsAmount = 0;
        this.collection = new DiskCD[10];
    }

    public void addAlbumToCollection() {
        Scanner scanner = new Scanner(System.in);

        // Title segment
        String title;
        System.out.println("Podaj tytuł albumu");
        title = scanner.nextLine();

        // Author segment
        String author;
        System.out.println("Podaj nazwisko autora");
        author = scanner.nextLine();

        // Publisher segment
        String publisher;
        System.out.println("Podaj nazwe producenta");
        publisher = scanner.nextLine();

        // Release segment
        String release;
        System.out.println("Podaj date wydania");
        release = scanner.nextLine();

        // Price segment
        double price;
        System.out.println("Podaj cene albumu");
        price = scanner.nextDouble();

        // Songs segment
//        boolean songRead;
//        System.out.println("Czy chcesz dodać utwory? (Można dodać je później)");
        this.collection[this.albumsAmount] = new DiskCD(title, author, publisher, release, price);
        this.albumsAmount++;
    }

    public void printCollection() {
        for (DiskCD album : collection) {
            if (album != null) {
                StringBuilder resultString = new StringBuilder();
                resultString.append("Nazwa albumu: ");
                resultString.append(album.getAlbumTitle());

                System.out.println(resultString);
            }
        }
    }
}
