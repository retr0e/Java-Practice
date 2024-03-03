package Exercise_Three;

import java.util.Scanner;

class Song {
    private String songAuthor;
    private String authors;
    private String duration;

    public Song(String songAuthor, String authors, String duration) {
        this.songAuthor = songAuthor;
        this.authors = authors;
        this.duration = duration;
    }

    /* Getters and Setters */

    public String getSongAuthor() {
        return songAuthor;
    }

    public void setSongAuthor(String songAuthor) {
        this.songAuthor = songAuthor;
    }

    public String getAuthors() {
        return authors;
    }

    public void setAuthors(String authors) {
        this.authors = authors;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public void editSong() {
        Scanner scanner = new Scanner(System.in);
        View viewManager = new View();

        System.out.println("Wybrana piosenka:");
        System.out.println(viewManager.createSongDescription(this));

        System.out.println("************* Menu Edycji *************");
        System.out.println("1 - Autor");
        System.out.println("2 - Wykonawca");
        System.out.println("3 - Czas trwania");

        System.out.println("\n Any - WYJŚCIE - Any");

        int editionDecision = scanner.nextInt();
        scanner.nextLine();

        switch (editionDecision) {
            case 1:
                System.out.println("Podaj nowego autora piosenki");
                this.setSongAuthor(scanner.nextLine());
                break;
            case 2:
                System.out.println("Podaj nowego wykonawce piosenki");
                this.setAuthors(scanner.nextLine());
                break;
            case 3:
                System.out.println("Podaj nowy czas trwania utworu");
                this.setDuration(scanner.nextLine());
                break;

        }
    }
}
