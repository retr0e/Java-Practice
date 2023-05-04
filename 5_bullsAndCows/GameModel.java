package bullscows;

public class GameModel {

    protected static String createResult(String secretCode, String userCode, int bulls, int cows) {
        StringBuilder viewLine = new StringBuilder();

        if (bulls != 0 && cows != 0) {
            viewLine.append("Grade: ").append(bulls).append(" bulls(s) and ").append(cows).append(" cows(s).");
        } else if (bulls == 0 && cows == 0) {
            viewLine.append("None.");
        } else if (bulls == 0) {
            viewLine.append("Grade: ").append(cows).append(" cows(s).");
        } else {
            viewLine.append("Grade: ").append(bulls).append(" bull(s).");
        }

//        return viewLine.append(" The secret code is ").append(secretCode).toString();
        return viewLine.toString();

    }

    public static String createRangeOfSymbols(int len, char[] symbols) {
        StringBuilder viewLine = new StringBuilder();
        viewLine.append("The secret is prepared: ");
        viewLine.append("*".repeat(Math.max(0, len))).append(" (");

        if (symbols.length <= 10) {
            viewLine.append("0-").append(symbols[symbols.length - 1]).append(")");
        } else {
            viewLine.append("0-").append(symbols[9]).append(", ");
            viewLine.append(symbols[10]).append("-").append(symbols[symbols.length - 1]).append(").");
        }

// **** (0-9, a-f).

        return viewLine.toString();
    }
}
