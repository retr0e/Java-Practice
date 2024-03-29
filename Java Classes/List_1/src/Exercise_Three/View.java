package Exercise_Three;

public class View {

    public String createSongDescription(Song song) {
        StringBuilder resultString = new StringBuilder();
        resultString.append(song.getAuthors()).append(" | ");
        resultString.append(song.getDuration()).append(" | ");
        resultString.append(song.getSongAuthor());

        return resultString.toString();
    }

    public String createSongDescription(int count, Song song) {
        StringBuilder resultString = new StringBuilder();
        resultString.append(" ").append(count).append(" | ");
        resultString.append(song.getAuthors()).append(" | ");
        resultString.append(song.getDuration()).append(" | ");
        resultString.append(song.getSongAuthor());

        return resultString.toString();
    }

    public String createAlbumDescription(DiskCD album) {
        StringBuilder resultString = new StringBuilder();
        resultString.append(album.getAlbumTitle()).append(" | ");
        resultString.append(album.getAuthorSurname()).append(" | ");
        resultString.append(album.getPublisherName()).append(" | ");
        resultString.append(album.getReleaseDate()).append(" | ");
        resultString.append(album.getPrice());

        return resultString.toString();
    }
    public String createAlbumDescription(int count, DiskCD album) {
        StringBuilder resultString = new StringBuilder();
        resultString.append(" ").append(count).append(" | ");
        resultString.append(album.getAlbumTitle()).append(" | ");
        resultString.append(album.getAuthorSurname()).append(" | ");
        resultString.append(album.getPublisherName()).append(" | ");
        resultString.append(album.getReleaseDate()).append(" | ");
        resultString.append(album.getPrice());

        return resultString.toString();
    }
}
