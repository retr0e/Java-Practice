package Exercise_Three;

public class DiskCollection {
    DiskCD[] collection = new DiskCD[10];

    public void addAlbumToCollection() {
        System.out.println();
    }

    public void printCollection() {
        for (DiskCD album : collection) {
            StringBuilder resultString = new StringBuilder();
            resultString.append("Nazwa albumu: ");
            resultString.append(album.getAlbumTitle());

            System.out.println(resultString.toString());
        }
    }
}
