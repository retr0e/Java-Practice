package Exercise_Three;

import java.sql.SQLOutput;
import java.util.Scanner;

public class DiskCD {
    private String albumTitle;
    private String authorSurname;
    private String publisherName;
    private String releaseDate;
    private Song[] songs = new Song[10];
    private double price;

    public DiskCD() {

    }

    public DiskCD(String albumTitle, String authorSurname, String publisherName, String releaseDate, double price) {
        this.albumTitle = albumTitle;
        this.authorSurname = authorSurname;
        this.publisherName = publisherName;
        this.releaseDate = releaseDate;
        this.price = price;
    }

    /* Getters and Setters */

    public String getAlbumTitle() {
        return albumTitle;
    }

    public void setAlbumTitle(String albumTitle) {
        this.albumTitle = albumTitle;
    }

    public String getAuthorSurname() {
        return authorSurname;
    }

    public void setAuthorSurname(String authorSurname) {
        this.authorSurname = authorSurname;
    }

    public String getPublisherName() {
        return publisherName;
    }

    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Song[] getSongs() {
        return songs;
    }

    public void setSongs(Song[] songs) {
        this.songs = songs;
    }

    public void editAlbum() {
        Scanner scanner = new Scanner(System.in);
        View viewManager = new View();

        System.out.println("Wybrany album:");
        System.out.println(viewManager.createAlbumDescription(this));

        System.out.println("************* Menu Edycji *************");
        System.out.println("1 - Tytuł albumu - 1");
        System.out.println("2 - Nazwisko autora - 2");
        System.out.println("3 - Wydawce - 3");
        System.out.println("4 - Date wydania - 4");
        System.out.println("5 - Cene - 5");

        System.out.println("************* Utwory *************");
        System.out.println("6 - Wyświetl piosenki albumu - 6");

        System.out.println("Any - WYJŚCIE - Any");

        int dialogDecision = scanner.nextInt();
        scanner.nextLine();

        switch (dialogDecision) {
            case 1:
                System.out.println("Podaj nową nazwe albumu");
                this.setAlbumTitle(scanner.nextLine());
                break;
            case 2:
                System.out.println("Podaj nowe nazwisko autora");
                this.setAuthorSurname(scanner.nextLine());
                break;
            case 3:
                System.out.println("Podaj nowego wydawce");
                this.setPublisherName(scanner.nextLine());
                break;
            case 4:
                System.out.println("Podaj nową date wydania");
                this.setReleaseDate(scanner.nextLine());
                break;
            case 5:
                System.out.println("Podaj nową cene");
                this.setPrice(scanner.nextDouble());
                break;
            case 6:
                // Show songs menu
                break;
            default:
                break;
        }
    }
}
