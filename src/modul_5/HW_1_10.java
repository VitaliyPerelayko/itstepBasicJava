package modul_5;

import java.util.Scanner;

/*
Задание 10
Напишите программу, которая будет печатать
ромбовидный рисунок на основе строки, введенной с
клавиатуры (максимальная длина – 50 символов).
Пример вывода для строки testing:
      t
     te
    tes
   test
  testi
 testin
testing
esting
sting
ting
ing
ng
g
 */
public class HW_1_10 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String text = input.nextLine();

        char[] tempText = text.toCharArray();
        for (int i = 0; i < tempText.length; i++) {
            for (int j = 0; j < tempText.length - i - 1; j++) {
                System.out.print(' ');
            }
            for (int k = 0; k < i + 1; k++) {
                System.out.print(tempText[k]);
            }
            System.out.println();
        }

        for (int i = 0; i < tempText.length - 1; i++) {
            for (int j = 0; j < tempText.length - i - 1; j++) {
                System.out.print(tempText[i + j + 1]);
            }
            System.out.println();
        }

    }
}
