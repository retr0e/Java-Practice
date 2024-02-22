package bullscows;

public class Main {
    public static void main(String[] args) {

        int wayDetermination = Game.playGame();

        switch (wayDetermination) {
            case 0 -> System.out.println("Sorry for the problems! Good Bye!");
            case 1 -> System.out.println("Thanks for playing!");
            default -> {
            }
        }

    }
}

