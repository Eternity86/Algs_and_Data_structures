package Lesson8.hashChain;

public class Link {
    private int iData;
    public Link next;

    public Link(int it) {
        iData = it;
    }

    int getKey() {
        return iData;
    }

    public void displayLink() {
        System.out.print(iData + " ");
    }

}