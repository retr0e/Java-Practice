package Exercise_Three;

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
        DataCollector collect = new DataCollector();
        View viewManager = new View();

        System.out.println("Wybrana piosenka:");
        System.out.println(viewManager.createSongDescription(this));

        System.out.println("************* Menu Edycji *************");
        System.out.println("1 - Autor");
        System.out.println("2 - Wykonawca");
        System.out.println("3 - Czas trwania");

        System.out.println("\n Any - WYJŚCIE - Any");

        int editionDecision = collect.getIntValue();

        switch (editionDecision) {
            case 1:
                System.out.println("Podaj nowego autora piosenki");
                this.setSongAuthor(collect.getStringValue());
                break;
            case 2:
                System.out.println("Podaj nowego wykonawce piosenki");
                this.setAuthors(collect.getStringValue());
                break;
            case 3:
                System.out.println("Podaj nowy czas trwania utworu");
                this.setDuration(collect.getStringValue());
                break;

        }
    }
}
