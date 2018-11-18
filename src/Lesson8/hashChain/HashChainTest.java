package Lesson8.hashChain;

import java.util.Scanner;

public class HashChainTest {
    public static void main(String[] args) {
        int aKey ;
        Link aDataItem;
        int size, n, keysPerCell = 100;

        System.out.print("Enter size of hash table: ");
        size = getInt();
        System.out.print("Enter initial number of items: ");
        n = getInt();

        HashTable hashTable = new HashTable(size);

        for (int i = 0; i < n; i++) {
            aKey = (int) (Math.random() * keysPerCell * size);
            aDataItem = new Link(aKey);
            hashTable.insert(aDataItem);
        }

        while (true) {
            System.out.print("Enter first letter of " +
                    "(s)how, (i)nsert, (d)elete or (f)ind: ");
            char choice = getChar();
            switch (choice) {
                case 's': {
                    hashTable.displayTable();
                    break;
                }
                case 'i': {
                    System.out.print("Enter key value to insert: ");
                    aKey = getInt();
                    aDataItem = new Link(aKey);
                    hashTable.insert(aDataItem);
                    break;
                }
                case 'd': {
                    System.out.print("Enter key value to delete: ");
                    aKey = getInt();
                    hashTable.delete(aKey);
                    break;
                }
                case 'f': {
                    System.out.print("Enter key value to find: ");
                    aKey = getInt();
                    aDataItem = hashTable.find(aKey);
                    if (aDataItem != null) {
                        System.out.println("Found " + aKey);
                    } else {
                        System.out.println("Could nod find " + aKey);
                    }
                    break;
                }
                default: {
                    System.out.print("Invalid entry" + System.lineSeparator());
                }
            }
        }
    }

    public static String getString() {
        return new Scanner(System.in).nextLine();
    }

    private static char getChar() {
        return getString().charAt(0);
    }

    public static int getInt() {
        return Integer.parseInt(getString());
    }

}