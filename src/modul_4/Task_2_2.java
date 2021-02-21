package modul_4;


import java.util.Scanner;

public class Task_2_2 {
    // draws a solid line
    // *************
    private static void solidSide(int length) {
        for (int j = 0; j < length; j++) {
            System.out.print('*');
        }
    }

    // draws a blank line
    // *           *
    private static void blankSide(int length) {
        System.out.print('*');
        for (int j = 1; j < length - 1; j++) {
            System.out.print(' ');
        }
        System.out.print('*');
    }

    public static void main(String args[]) {

        System.out.println("Enter the length of foursquare");
        Scanner input = new Scanner(System.in);
        int length = input.nextInt();

        solidSide(length);
        System.out.println();
        for (int i = 1; i < length - 1; i++) {
            blankSide(length);
            System.out.println();
        }
        solidSide(length);
    }
}
