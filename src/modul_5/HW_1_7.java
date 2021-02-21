package modul_5;


import java.util.Scanner;

public class HW_1_7 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String text = input.nextLine();

        char[] tempText = text.toCharArray();
        for (int i = 0; i < tempText.length; i++) {
            char c = tempText[i];
            if ((c >= 65) && (c <= 90)) {
                tempText[i] += 32;
            }
            if ((c >= 97) && (c <= 122)) {
                tempText[i] -= 32;
            }
        }
        System.out.println(String.copyValueOf(tempText).replaceAll("\\d","_"));
        int a = 'a';
        int ba = 'A';
        int z = 'z';
        int bz = 'Z';
        int f = '0';
        int l = '9';
        System.out.println("a -> " + a);
        System.out.println("A -> " + ba);
        System.out.println("z -> " + z);
        System.out.println("Z -> " + bz);
    }
}
