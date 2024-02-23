import java.util.Scanner;

class Recursion {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj liczbe n: ");
        int n = scanner.nextInt();
        System.out.println(factorial(n));
        System.out.println(factorialDivision(n));
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
