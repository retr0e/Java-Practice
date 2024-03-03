package Exercise_Two;

import Exercise_Three.DataCollector;

class Recursion {

    public static void main(String[] args) {
        DataCollector collect = new DataCollector();

        System.out.println("Podaj liczbe n: ");
        int n = collect.getIntValue();

        System.out.println(factorial(n));
        System.out.println(factorialDivision(n));

        collect.closeScanner();
    }

    private static double factorialDivision(int number) {
        double result = 0;
        boolean mark = true;
        for (double i = 1.0; i <= number; i++) {
            if (mark) {
                result += 1 / (i + (double)number);
            } else {
                result -= 1 / (i + (double)number);
            }

            mark = !mark;
        }
        return result;
    }

    private static long factorial(int number) {
        int startNumber = 1;
        long result = 1L;

        while (startNumber <= number) {
            result *= startNumber;
            startNumber++;
        }

        return result;
    }

}
