package Lesson6.FullBST;

import java.util.ArrayList;
import java.util.Random;

public class TestBST {

    public static void main(String[] args) {

        ArrayList<BST<Integer, Integer>> treeList = new ArrayList<>();
        int treeCount = 100_000;
        int notBalanced = 0;
        for (int i = 1; i <= treeCount; i++) {
            treeList.add(new BST<>());
            //System.out.println("Добавили " + i + " дерево в список");
        }

        for (BST<Integer, Integer> aTreeList : treeList) {
            while (aTreeList.height() < 6) {
                aTreeList.put(new Random().nextInt(101) - new Random().nextInt(101), new Random().nextInt(101) - new Random().nextInt(101));
            }
            if (!aTreeList.isBalanced()) {
                notBalanced++;
            }
        }

        for (BST<Integer, Integer> aTreeList : treeList) {
            //System.out.println("сбалансированное " + aTreeList.isBalanced() + ", высота " + aTreeList.height() + ", размер " + aTreeList.size());
        }
        System.out.println(notBalanced);
        System.out.println("Процент несбалансированных " + (((notBalanced * 1.0) / treeCount) * 100.0));

    }

}