package Lesson4.LinkedList;

public class Link {
    public int iData;           // Данные (ключ)
    public double dData;        // Данные
    public Link next;           // Следующий элемент в списке

    public Link(int id, double dd) {
        iData = id;
        dData = dd;
    }

    public void displayLink() {
        System.out.print("{" + iData + ", " + dData + "} ");
    }
}
