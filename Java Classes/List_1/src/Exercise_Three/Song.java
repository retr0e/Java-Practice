package Exercise_Three;

class Song {
    private String songAuthor;
    private String authors;
    private double duration;

    public Song(String songAuthor, String authors, double duration) {
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

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public void editSong() {

    }
}
