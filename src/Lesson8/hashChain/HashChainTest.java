package Lesson8.hashChain;

import java.util.Scanner;

public class HashChainTest {
    public static void main(String[] args) {
        int aKey ;
        Link aDataItem;
        int size, n, keysPerCell = 100;

        System.out.print("Введите размер хеш-таблицы: ");
        size = getInt();
        System.out.print("Введите начальное кол-во элементов: ");
        n = getInt();

        HashTable hashTable = new HashTable(size);

        for (int i = 0; i < n; i++) {
            aKey = (int) (Math.random() * keysPerCell * size);
            aDataItem = new Link(aKey);
            hashTable.insert(aDataItem);
        }

        while (true) {
            System.out.print("Введите первую букву слова " +
                    "(s)how - показать, (i)nsert - вставить, (d)elete - удалить or (f)ind - найти: ");
            char choice = getChar();
            switch (choice) {
                case 's': {
                    hashTable.displayTable();
                    break;
                }
                case 'i': {
                    System.out.print("Введите ключ для вставки: ");
                    aKey = getInt();
                    aDataItem = new Link(aKey);
                    hashTable.insert(aDataItem);
                    break;
                }
                case 'd': {
                    System.out.print("Введите ключ для удаления: ");
                    aKey = getInt();
                    hashTable.delete(aKey);
                    break;
                }
                case 'f': {
                    System.out.print("Введите ключ для поиска: ");
                    aKey = getInt();
                    aDataItem = hashTable.find(aKey);
                    if (aDataItem != null) {
                        System.out.println("Найдено " + aKey);
                    } else {
                        System.out.println("Невозможно найти " + aKey);
                    }
                    break;
                }
                default: {
                    System.out.print("Неверный управляющий символ" + System.lineSeparator());
                }
            }
        }
    }

    private static String getString() {
        return new Scanner(System.in).nextLine();
    }

    private static char getChar() {
        return getString().charAt(0);
    }

    private static int getInt() {
        return Integer.parseInt(getString());
    }

}