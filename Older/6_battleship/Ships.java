package battleship;

public enum Ships {

    AIRCRAFT_CARRIER("Aircraft Carrier", 5),
    BATTLESHIP("Battleship", 4),
    SUBMARINE("Submarine", 3),
    CRUISER("Cruiser", 3),
    DESTROYER("Destroyer", 2);

    final String name;
    final int size;

    private Ships(String name, int size) {
        this.name = name;
        this.size = size;
    }

}
