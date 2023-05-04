package bullscows;

import java.util.Arrays;
import java.util.Random;
public class Creation {

    public static char[] createArrOfAvailableSymbols(int len) {

        // Generation of symbols available in game
        char[] symbols = new char[0];
        int numberOfSymbols = 0;
        int idOfChar = 48;
        boolean convertion = false;

        while (numberOfSymbols < len) {
            symbols = Arrays.copyOf(symbols, symbols.length + 1);
            if (numberOfSymbols == 10) {
                if (!convertion) {
                    idOfChar += 39;
                    convertion = true;
                }
            }
            symbols[numberOfSymbols] = (char)idOfChar;
            idOfChar++;
            numberOfSymbols++;
        }

        return symbols;

    }

    public static String createCode(int len, char[] availablePartsForCode) {
        StringBuilder code = new StringBuilder();
        Random rand = new Random();

        while (code.length() < len) {
            int elementForCode = rand.nextInt(availablePartsForCode.length);
            code.append(availablePartsForCode[elementForCode]);
            availablePartsForCode = deleteElement(availablePartsForCode, elementForCode);
        }

        return code.toString();

    }

    private static char[] deleteElement(char[] symbols, int position) {
        char[] temporaryHolder = new char[symbols.length - 1];

        // Creating new array without element on position
        for (int i = 0, j = 0; i < symbols.length; i++) {
            if (i != position) {
                temporaryHolder[j++] = symbols[i];
            }
        }

        return temporaryHolder;
    }

}
