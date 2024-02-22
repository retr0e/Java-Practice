package bullscows;

class GameControler {

    protected static int checkBulls(String secretCode, String userCode) {
        int bullsCount = 0;
        for (int i = 0, j = 0; i < userCode.length(); i++) {
            if (j >= secretCode.length())
                break;
            if (secretCode.charAt(j++) == userCode.charAt(i))
                bullsCount++;
        }

        return bullsCount;
    }

    protected static int checkCows(String secretCode, String userCode) {

        int cowsCount = 0;
        for (int i = 0; i < userCode.length(); i++) {
            for (int j = 0; j < secretCode.length(); j++) {
                if (!(j == i)) {
                    if (secretCode.charAt(j) == userCode.charAt(i))
                        cowsCount++;
                }
            }
        }

        return cowsCount;
    }
}
