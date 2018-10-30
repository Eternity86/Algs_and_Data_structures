package Lesson2;

public class MyArrayList<Item extends Comparable<Item>>{
    private Object[] list;
    private int size = 0;

    MyArrayList() {
        list = new Object[1];
    }

    private void resize(int capacity) {
        Object[] temp = new Object[capacity];
        if (size >= 0) System.arraycopy(list, 0, temp, 0, size);
        list = temp;
    }

    int size() {
        return size;
    }

    public void insert(Item item) {
        if (size == list.length) {
            resize(list.length * 2);
        }
        list[size++] = item;
    }

    public boolean delete(Item item) {
        int i = 0;
        while (i < size && !list[i].equals(item)) {
            i++;
        }
        if (i == size) {
            return false;
        }
        if (size - 1 - i >= 0) System.arraycopy(list, i + 1, list, i, size - 1 - i);
        size--;
        if (size == (list.length / 4) && size > 0) {
            resize(list.length / 2);
        }
        return true;
    }

    void set(int index, Item item) {
        if (index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException();
        }
        list[index] = item;
    }

    Item get(int index) {
        if (index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException();
        }
        return (Item) list[index];
    }

    public boolean find(Item item) {
        for (int i = 0; i < size; i++) {
            if (list[i].equals(item)) {
                return true;
            }
        }
        return false;
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < size; i++) {
            s.append(list[i]).append(" ");
        }
        return s.toString();
    }

    private boolean less(Item item1, Item item2) {
        return item1.compareTo(item2) < 0;
    }

    private void swap(int i, int j) {
        Item temp = (Item) list[i];
        list[i] = list[j];
        list[j] = temp;
    }

    void selectionSort() {
        for (int i = 0; i < size - 1; i++) {
            int min = i;
            for (int j = i + 1; j < size; j++) {
                if (less((Item) list[j], (Item) list[min])) {
                    min = j;
                }
            }
            swap(i, min);
        }
    }

    void insertionSort() {
        for (int i = 0; i < size; i++) {
            for (int j = i; j > 0; j--) {
                if (less((Item) list[j], (Item) list[j - 1])) {
                    swap(j, j - 1);
                } else {
                    break;
                }
            }
        }
    }

    public void bubbleSort() {
        for (int i = size - 1; i > 0 ; i--) {
            for (int j = 0; j < i; j++) {
                if (less((Item) list[j + 1], (Item) list[j])) {
                    swap(j, j + 1);
                }
            }
        }
    }

 }