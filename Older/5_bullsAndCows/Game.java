package bullscows;

import java.util.Random;
import java.util.Scanner;

public class Game {

    public static int playGame() {

        boolean playTheGame = true;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input the length of the secret code:");
        String sLen = scanner.next();

        switch (sLen.length()) {
            case 1:
                if ((int)sLen.charAt(0) < 48 || (int)sLen.charAt(0) > 57) {
                    System.out.println("Error: \" "+ sLen + " \" isn't a valid number.\n");
                    return 0;
                }
                break;
            case 2:
                if ((int)sLen.charAt(0) < 48 || (int)sLen.charAt(0) > 57 || (int)sLen.charAt(1) < 48 ||
                        (int)sLen.charAt(1) > 57) {
                    System.out.println("Error: \" "+ sLen + " \" isn't a valid number.\n");
                    return 0;
                }
                break;
            default:
                if (sLen.length() > 2) {
                    System.out.println("Error: \" "+ sLen + " \" isn't a valid number.\n");
                    return 0;
                }
                break;
        }

        int len = Integer.parseInt(sLen);
        String code;
        char[] symbolsForCode;
        int symbolsLen;

        if (len > 36) {
            System.out.println("Error: maximum number of possible symbols in the code is 36 (0-9, a-z).");
            return 0;
        } else if (len == 0) {
            System.out.println("Error: length can not be 0!");
            return 0;
        } else {
            System.out.println("Input the number of possible symbols in the code:");
            symbolsLen = scanner.nextInt();
            if (len > symbolsLen) {
                System.out.println("Error: it's not possible to generate a code with a length of " + len + " with " + symbolsLen + " unique symbols.");
                return 0;
            } else if (symbolsLen > 36) {
                System.out.println("Error: there can be only 36 unique digits!");
                return 0;
            }
            symbolsForCode = Creation.createArrOfAvailableSymbols(symbolsLen);
            code = Creation.createCode(len, symbolsForCode);
        }

        System.out.println("Okay, let's start a game!");
        System.out.println(GameModel.createRangeOfSymbols(len, symbolsForCode));


        int turnsCount = 1;

        do {
            System.out.println("Turn " + turnsCount);
            String userGuess = scanner.next();
            int numberOfBulls = GameControler.checkBulls(code, userGuess);
            int numberOfCows = GameControler.checkCows(code, userGuess);

            String resultLine = GameModel.createResult(code, userGuess, numberOfBulls, numberOfCows);
            System.out.println(resultLine);

            turnsCount++;

            if (numberOfBulls == len)
                playTheGame = false;

        } while (playTheGame);

        System.out.println("Congratulations! You guessed the secret code.");

        return 1;
    }

}
