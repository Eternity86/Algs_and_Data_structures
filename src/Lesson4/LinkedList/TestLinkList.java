package Lesson4.LinkedList;

public class TestLinkList {
    public static void main(String[] args) {
        LinkList list = new LinkList();

        list.insertFirst(22, 2.99);
        list.insertFirst(48, 4.99);
        list.insertFirst(25, 6.99);
        list.insertFirst(39, 7.99);
        list.insertFirst(18, 8.99);

        list.displayList();

        Link f = list.find(44);
        if (f != null) {
            System.out.println("Found link with key " + f.iData);
        } else {
            System.out.println("Can't find link");
        }

        Link d = list.delete(39);
        if (d != null) {
            System.out.println("Deleted link with key " + d.iData);
        } else {
            System.out.println("Can't delete link");
        }

        list.displayList();
    }

}