package Exercise_Three;

public class DiskCollection {
    private int albumsAmount;
    private DiskCD[] collection;

    public DiskCollection() {
        this.albumsAmount = 0;
        this.collection = new DiskCD[10];
    }

    public void addAlbumToCollection() {

        if (this.albumsAmount == 10) {
            System.out.println("Osiągnięto maksymalną ilość albumów");
            return;
        }

        DataCollector collect = new DataCollector();

        // Title segment
        String title;
        System.out.println("Podaj tytuł albumu");
        title = collect.getStringValue();

        // Author segment
        String author;
        System.out.println("Podaj nazwisko autora");
        author = collect.getStringValue();

        // Publisher segment
        String publisher;
        System.out.println("Podaj nazwe producenta");
        publisher = collect.getStringValue();

        // Release segment
        String release;
        System.out.println("Podaj date wydania");
        release = collect.getStringValue();

        // Price segment
        double price;
        System.out.println("Podaj cene albumu");
        price = collect.getDoubleValue();

        this.collection[this.albumsAmount] = new DiskCD(title, author, publisher, release, price);
        this.albumsAmount++;
    }

    public void printCollection() {
        if (this.albumsAmount == 0) {
            System.out.println("Brak albumów w kolekcji");
            return;
        }

        DataCollector collect = new DataCollector();
        View viewManager = new View();

        // Printing information about albums in collection
        System.out.println(" Id | Nazwa | Autor | Wydawca | Data wydania | Cena (zł)");
        int albumInRow = 1;
        for (DiskCD album : collection) {
            if (album != null) {
                System.out.println(viewManager.createAlbumDescription(albumInRow, album));
                albumInRow++;
            }
        }

        // Operation on albums
        System.out.println("\n-----------------------------------------------");
        System.out.println("Wprowadź numer albumu do szczegółowej inspekcji");
        System.out.print("bądź niewystępujący numer id, aby przejść do menu początkowego: ");

        int chosenAlbum = collect.getIntValue() - 1;

        if (!(chosenAlbum < 0 || chosenAlbum > this.albumsAmount - 1)) {
            this.collection[chosenAlbum].editAlbum();
        }

    }
}
