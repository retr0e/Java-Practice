package numbers;

class Number {

    private final long number;
    private int len = 0;
    private String[] seekingParameter = new String[0];
    private String[] unwantedParameter = new String[0];
    private boolean isEven;
    private boolean isOdd;
    private boolean isBuzz;
    private boolean isDuck;
    private boolean isPalindromic;
    private boolean isGapful;
    private boolean isSpy;
    private boolean isSunny;
    private boolean isSquare;
    private boolean isJumping;
    private boolean isSad;
    private boolean isHappy;

    protected Number(long number) {
        this.number = number;
    }

    protected Number(long number, int len) {
        this.number = number;
        this.len = len;
    }

    protected Number(long number, int len, String[] seekingParameter) {
        this.number = number;
        this.len = len;
        this.seekingParameter = seekingParameter;
    }

    protected Number(long number, int len, String[] seekingParameter, String[] unwantedParameter) {
        this.number = number;
        this.len = len;
        this.seekingParameter = seekingParameter;
        this.unwantedParameter = unwantedParameter;
    }

    public long getNumber() {
        return number;
    }

    public boolean isEven() {
        return isEven;
    }

    public boolean isOdd() {
        return isOdd;
    }

    public boolean isBuzz() {
        return isBuzz;
    }

    public boolean isDuck() {
        return isDuck;
    }

    public boolean isPalindromic() {
        return isPalindromic;
    }

    public boolean isGapful() {
        return isGapful;
    }

    public boolean isSpy() {
        return isSpy;
    }

    public boolean isSquare() {
        return isSquare;
    }

    public boolean isSunny() {
        return isSunny;
    }

    public boolean isJumping() {
        return isJumping;
    }

    public boolean isSad() {
        return isSad;
    }

    public boolean isHappy() {
        return isHappy;
    }

    protected void getProperties() {

        assignProperties();

        if (len == 0) {
            Model.printPropertiesBlock(this);
        } else {
            showOneLineProperties();
        }

    }

    private void assignProperties() {
        isBuzz = NumberLogic.buzzTest(number);
        isDuck = NumberLogic.duckTest(number);
        isPalindromic = NumberLogic.palindromTest(number);
        isGapful = NumberLogic.gapfulTest(number);
        isSpy = NumberLogic.spyTest(number);
        isSquare = NumberLogic.squareTest(number);
        isSunny = NumberLogic.sunnyTest(number);
        isJumping = NumberLogic.jumpingTest(number);
        isEven = NumberLogic.evenTest(number);
        isHappy = NumberLogic.happyTest(number);
        isSad = !isHappy;
        isOdd = !isEven;
    }

    private void showOneLineProperties() {
        long startNumber = number;
        int amountOfSeekingNumbers = 0;

        if (seekingParameter.length == 0 && unwantedParameter.length == 0) {
            for (int i = 0; i < len; i++) {
                if (i == 0) {
                    System.out.println(createPropertiesString());
                } else {
                    Number nextNumber = new Number(startNumber + 1, 1);
                    nextNumber.getProperties();
                    startNumber++;
                }
            }
        } else {
            int iteration = 1;
            boolean check = true;

            for (String property : seekingParameter)
                if (!this.createPropertiesString().contains(property))
                    check = false;

            for (String property : unwantedParameter)
                if (this.createPropertiesString().contains(property))
                    check = false;

            if (check) {
                System.out.println(this.createPropertiesString());
                amountOfSeekingNumbers++;
            }
            while (amountOfSeekingNumbers != len) {
                Number nextNumber = new Number(startNumber + iteration, 1, seekingParameter, unwantedParameter);
                nextNumber.assignProperties();
                check = true;
                for (String property : seekingParameter)
                    if (!nextNumber.createPropertiesString().contains(property))
                        check = false;

                for (String property : unwantedParameter)
                    if (nextNumber.createPropertiesString().contains(property))
                        check = false;

                if (check) {
                    System.out.println(nextNumber.createPropertiesString());
                    amountOfSeekingNumbers++;
                }
                iteration++;
            }

        }

    }

    private String createPropertiesString() {
        return Model.printPropertiesLine(this);
    }


}
