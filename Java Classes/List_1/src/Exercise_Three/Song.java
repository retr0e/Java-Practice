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


}
