package Exercise_Three;

import java.sql.SQLOutput;
import java.util.Scanner;

public class DiskCD {
    private String albumTitle;
    private String authorSurname;
    private String publisherName;
    private String releaseDate;
    private Song[] songs;
    private int songsAmount;
    private double price;

    public DiskCD() {

    }

    public DiskCD(String albumTitle, String authorSurname, String publisherName, String releaseDate, double price) {
        this.albumTitle = albumTitle;
        this.authorSurname = authorSurname;
        this.publisherName = publisherName;
        this.releaseDate = releaseDate;
        this.price = price;
        this.songs = new Song[10];
        this.songsAmount = 0;
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
                scanner.nextLine();
                break;
            case 6:
                // Show songs menu
                this.albumSongsDialog();
                break;
            default:
                break;
        }
    }

    private void albumSongsDialog() {
        Scanner scanner = new Scanner(System.in);
        View viewManager = new View();

        int i = 1;
        for (Song song : this.songs) {
            if (song != null) {
                viewManager.createSongDescription(i, song);
                i++;
            }
        }

        System.out.println("******* Menu Piosenek *******");
        System.out.println("1 - Edytuj piosenke - 1");
        System.out.println("2 - Dodaj piosenke - 2");
        System.out.println("3 - Wyjscie - 3");

        int decision = scanner.nextInt();
        scanner.nextLine();

        switch (decision) {
            case 1:
                // Edit Song
                break;
            case 2:
                // Add Song
                this.addSong();
                break;
            case 3:
                return;
            default:
                break;
        }
    }

    private void addSong() {

        if (this.songsAmount == 10) {
            System.out.println("Osiągnięto limit piosenek");
            return;
        }

        Scanner scanner = new Scanner(System.in);

        // Song author
        System.out.println("Podaj autora utworu");
        String author = scanner.nextLine();

        // Executor of the song
        System.out.println("Podaj wykonawce utworu");
        String executor = scanner.nextLine();

        // Duration
        System.out.println("Podaj czas trwania utworu");
        double duration = scanner.nextDouble();
        scanner.nextLine();

        this.songs[this.songsAmount] = new Song(author, executor, duration);
        this.songsAmount++;
    }
}
