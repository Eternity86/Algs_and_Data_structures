package Lesson4.DoubleSidedList;

public class Link {
    public long dData;          // Данные
    public Link next;           // Следующий элемент в списке

    public Link(long d) {
        dData = d;
    }

    public void displayLink() {
        System.out.print(dData + " ");
    }
}
