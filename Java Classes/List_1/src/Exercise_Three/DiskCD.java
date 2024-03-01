package Exercise_Three;

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

    public DiskCD editDisk() {
        return null;
    }

}
