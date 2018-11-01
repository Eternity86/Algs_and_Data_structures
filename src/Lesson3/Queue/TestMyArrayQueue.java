package Lesson3.Queue;

import java.util.Random;

public class TestMyArrayQueue {
    public static void main(String[] args) {
        MyArrayQueue<Integer> myArrQueue = new MyArrayQueue<>();

        for (int i = 0; i < 10; i++) {
            myArrQueue.enqueue(new Random().nextInt(50));
        }
        System.out.println("Изначально элементов в очереди " + myArrQueue.getSize());
        System.out.println("Элементы очереди: " + myArrQueue);
        System.out.println("Первый в очереди: " + myArrQueue.peek());

        myArrQueue.dequeue();
        myArrQueue.dequeue();
        myArrQueue.dequeue();
        myArrQueue.dequeue();
        System.out.println("Стало элементов в очереди " + myArrQueue.getSize());
        System.out.println("Элементы очереди: " + myArrQueue);
        System.out.println("Первый в очереди: " + myArrQueue.peek());

        myArrQueue.enqueue(new Random().nextInt(50));
        myArrQueue.enqueue(new Random().nextInt(50));
        myArrQueue.enqueue(new Random().nextInt(50));
        myArrQueue.enqueue(new Random().nextInt(50));
        myArrQueue.enqueue(new Random().nextInt(50));
        myArrQueue.enqueue(new Random().nextInt(50));
        myArrQueue.enqueue(new Random().nextInt(50));
        myArrQueue.enqueue(new Random().nextInt(50));
        myArrQueue.enqueue(new Random().nextInt(50));
        myArrQueue.enqueue(new Random().nextInt(50));
        System.out.println("Стало элементов в очереди " + myArrQueue.getSize());
        System.out.println("Элементы очереди: " + myArrQueue);
        System.out.println("Первый в очереди: " + myArrQueue.peek());
    }
    
}
