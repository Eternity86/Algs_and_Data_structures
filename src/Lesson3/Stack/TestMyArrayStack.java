package Lesson3.Stack;

import java.util.Random;

public class TestMyArrayStack {
    public static void main(String[] args) {
        MyArrayStack<Integer> myArrStack = new MyArrayStack<>();

        for (int i = 0; i < 10; i++) {
            myArrStack.push(new Random().nextInt(50));
        }
        System.out.println("Изначально элементов в стеке " + myArrStack.getSize());
        System.out.println("Элементы стека: " + myArrStack);
        System.out.println("На вершине стека: " + myArrStack.peek());

        for (int i = 0; i < 3; i++) {
            myArrStack.pop();
        }
        System.out.println("Осталось элементов в стеке " + myArrStack.getSize());
        System.out.println("Элементы стека: " + myArrStack);
        System.out.println("На вершине стека: " + myArrStack.peek());

        myArrStack.push(new Random().nextInt(50));
        myArrStack.push(new Random().nextInt(50));
        myArrStack.push(new Random().nextInt(50));
        myArrStack.push(new Random().nextInt(50));
        myArrStack.push(new Random().nextInt(50));
        System.out.println("Стало элементов в стеке " + myArrStack.getSize());
        System.out.println("Элементы стека: " + myArrStack);
        System.out.println("На вершине стека: " + myArrStack.peek());


    }
}
