package modul_4;

public class Task_2_4 {

    private static boolean isPrime(int number) {
        if (number == 2) return true;
        if (number % 2 == 0) {
            return false;
        } else {
            for (int i = 3; i <= number / i; i += 2) {
                System.out.println(i + "   " + number);
                if (number % i == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
    }
}
