package Lesson3;

import java.util.Scanner;

public class RightToLeftReading {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = null;

        System.out.println("Введите строку: ");
        if (in.hasNextLine()) {
            str = in.nextLine();
        }


        reverseWordsInString(str);
        System.out.println();
        reverseString(str);
    }

    private static void reverseString(String str) {
        char[] temp = str != null ? str.toCharArray() : new char[0];
        for (int i = temp.length - 1; i >= 0; i--) {
            System.out.print(temp[i]);
        }
    }

    private static void reverseWordsInString(String str) {
        String[] temp = str.split(" ");
        for (int i = temp.length - 1; i >= 0 ; i--) {
            System.out.print(temp[i] + " ");
        }
    }

}