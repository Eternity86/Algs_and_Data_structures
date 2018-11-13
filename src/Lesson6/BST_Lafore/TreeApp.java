package Lesson6.BST_Lafore;

import java.util.Random;
import java.util.Scanner;

public class TreeApp {
    public static void main(String[] args) {
        int value;
        Tree theTree = new Tree();
        for (int i = 0; i < 20; i++) {
            theTree.insert(new Random().nextInt(100), new Random().nextDouble());
        }
        /*theTree.insert(50, 1.5);
        theTree.insert(25, 1.2);
        theTree.insert(75, 1.7);
        theTree.insert(12, 1.5);
        theTree.insert(37, 1.2);
        theTree.insert(43, 1.7);
        theTree.insert(30, 1.5);
        theTree.insert(33, 1.2);
        theTree.insert(87, 1.7);
        theTree.insert(93, 1.5);
        theTree.insert(97, 1.5);*/
        while (true) {
            System.out.print("Enter first letter of " +
                    "(s)how, (i)nsert, (f)ind, (d)elete or (t)raverse: \n");
            int choice = getChar();
            switch (choice) {
                case 's': {
                    theTree.displayTree();
                    break;
                }
                case 'i': {
                    System.out.print("Enter value to insert: ");
                    value = getInt();
                    theTree.insert(value, value + 0.9);
                    break;
                }
                case 'f': {
                    System.out.print("Enter value to find: ");
                    value = getInt();
                    Node found = theTree.find(value);
                    if (found != null) {
                        System.out.print("Found: ");
                        found.displayNode();
                        System.out.println("");
                    } else {
                        System.out.println("Not found " + value);
                    }

                }
            }
        }
    }

    public static String getString() {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        return s;
    }

    public static char getChar() {
        String s = getString();
        return s.charAt(0);
    }

    public static int getInt() {
        String s = getString();
        return Integer.parseInt(s);
    }

}