package Lesson4.LinkIterator;

import java.io.IOException;
import java.util.Scanner;

public class TestListIterator {
    public static void main(String[] args) throws IOException {
        LinkList list = new LinkList();
        ListIterator iter1 = list.getIterator();
        long value;

        iter1.insertAfter(20);
        iter1.insertAfter(40);
        iter1.insertAfter(60);
        iter1.insertAfter(80);

        while (true) {
            System.out.print("Enter first letter of show, reset," +
                    " next, get, before, after, delete: ");
            System.out.flush();
            int choice = getChar();
            switch (choice) {
                case 's': {
                    if (!list.isEmpty()) {
                        list.displayList();
                    } else {
                        System.out.println("List is empty");
                    }
                    break;
                }
                case 'r': {
                    iter1.reset();
                    break;
                }
                case 'n': {
                    if (!list.isEmpty() && !iter1.atEnd()) {
                        iter1.nextLink();
                    } else {
                        System.out.println("Can't go to next list");
                    }
                    break;
                }
                case 'g': {
                    if (!list.isEmpty()) {
                        value = iter1.getCurrent().dData;
                        System.out.println("Returned " + value);
                    } else {
                        System.out.println("List is empty");
                    }
                    break;
                }
                case 'b': {
                    System.out.print("Enter value to insert: ");
                    System.out.flush();
                    value = getInt();
                    iter1.insertBefore(value);
                    break;
                }
                case 'a': {
                    System.out.print("Enter value to insert: ");
                    System.out.flush();
                    value = getInt();
                    iter1.insertAfter(value);
                    break;
                }
                case 'd': {
                    if (!list.isEmpty()) {
                        value = iter1.deleteCurrent();
                        System.out.println("Deleted " + value);
                    } else {
                        System.out.println("Can't delete");
                    }
                    break;
                }
                default: {
                    System.out.println("Invalid entry");
                }
            }
        }
    }

    public static String getString() {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    private static char getChar() {
        String s = getString();
        return s.charAt(0);
    }

    public static int getInt() {
        String s = getString();
        return Integer.parseInt(s);
    }

}