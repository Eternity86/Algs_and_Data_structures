package Lesson3.Stack;

import java.util.NoSuchElementException;

public class MyArrayStack<Item> {
    private Object[] stack;
    private int size = 0;

    public MyArrayStack() {
        stack = new Object[1];
    }

    // метод возвращает текущий размер стека
    public int getSize() {
        return size;
    }

    // метод проверяет, пуст ли стек
    private boolean isEmpty() {
        return size == 0;
    }

    // метод помещает элемент на вершину стека
    public void push(Item item) {
        if (size == stack.length) {
            resize(2 * stack.length);
        }
        stack[size++] = item;
    }

    // метод удаляет элемент с вершины стека
    public Item pop() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        Item item = (Item) stack[size - 1];
        stack[size - 1] = null;
        size--;
        if (size > 0 && size == stack.length / 4) {
            resize(stack.length / 2);
        }
        return item;
    }

    // метод получает (показывает) элемент стека, находящийся на его вершине
    public Item peek() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return (Item) stack[size - 1];
    }

    // метод изменяет размер стека до значения capacity
    private void resize(int capacity) {
        Object[] temp = new Object[capacity];
        if (size >= 0) System.arraycopy(stack, 0, temp, 0, size);
        stack = temp;
    }

    // переопределённый метод, выводящий стек на печать
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < size; i++) {
            s.append(stack[i]).append(", ");
        }
        return s.toString();
    }
}