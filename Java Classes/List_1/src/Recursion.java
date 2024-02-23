import java.util.Scanner;

class Recursion {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj liczbe n: ");
        int n = scanner.nextInt();
        System.out.println(factorial(n));
    }

    public static long factorial(int number) {
        int startNumber = 1;
        long result = 1L;

        while (startNumber <= number) {
            result *= startNumber;
            startNumber++;
        }

        return result;
    }

}
