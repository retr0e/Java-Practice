package Exercise_Three;

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
        DataCollector collect = new DataCollector();
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

        System.out.println("\nAny - WYJŚCIE - Any");

        int dialogDecision = collect.getIntValue();

        switch (dialogDecision) {
            case 1:
                System.out.println("Podaj nową nazwe albumu");
                this.setAlbumTitle(collect.getStringValue());
                break;
            case 2:
                System.out.println("Podaj nowe nazwisko autora");
                this.setAuthorSurname(collect.getStringValue());
                break;
            case 3:
                System.out.println("Podaj nowego wydawce");
                this.setPublisherName(collect.getStringValue());
                break;
            case 4:
                System.out.println("Podaj nową date wydania");
                this.setReleaseDate(collect.getStringValue());
                break;
            case 5:
                System.out.println("Podaj nową cene");
                this.setPrice(collect.getDoubleValue());
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
        DataCollector collect = new DataCollector();
        View viewManager = new View();

        if (this.songsAmount != 0) {
            System.out.println(" Id | Nazwa | Czas trwania | Wykonawca");
            int i = 1;
            for (Song song : this.songs) {
                if (song != null) {
                    System.out.println(viewManager.createSongDescription(i, song));
                    i++;
                }
            }
        } else {
            System.out.println("Album nie posiada żadnych piosenek!");
        }

        System.out.println("\n******* Menu Piosenek *******");
        if (this.songsAmount != 0) {
            System.out.println("Podaj Id piosenki aby ją edytować!");
        }
        System.out.println("11 - Dodaj piosenke - 11");
        System.out.println("Any - Wyjscie - Any");

        int chosenSong = collect.getIntValue() - 1;

        if (!(chosenSong < 0 || chosenSong > this.songsAmount - 1)) {
            this.songs[chosenSong].editSong();
        } else if (chosenSong == 10) {
            addSong();
        }

    }

    private void addSong() {

        if (this.songsAmount == 10) {
            System.out.println("Osiągnięto limit piosenek");
            return;
        }

        DataCollector collect = new DataCollector();

        // Song author
        System.out.println("Podaj autora utworu");
        String author = collect.getStringValue();

        // Executor of the song
        System.out.println("Podaj wykonawce utworu");
        String executor = collect.getStringValue();

        // Duration
        System.out.println("Podaj czas trwania utworu");
        String duration = collect.getStringValue();

        this.songs[this.songsAmount] = new Song(author, executor, duration);
        this.songsAmount++;
    }
}
