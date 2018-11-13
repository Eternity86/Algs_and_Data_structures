package Lesson6.BST_Lafore;

public class Node {
    int iData;
    double dData;
    Node leftChild, rightChild;

    public void displayNode() {
        System.out.print(" {");
        System.out.print(iData);
        System.out.print(". ");
        System.out.print(dData);
        System.out.print("} ");
    }
}
