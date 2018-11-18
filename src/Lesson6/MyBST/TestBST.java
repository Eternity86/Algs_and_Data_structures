package Lesson6.MyBST;

import java.util.ArrayList;
import java.util.Random;

public class TestBST {
    public static void main(String[] args) {
        ArrayList<BST<Integer, Integer>> treeList = new ArrayList<>();
        for (int i = 1; i <= 20; i++) {
            treeList.add(new BST<>());
            System.out.println("Добавили " + i + " дерево в список");
        }
        for (BST<Integer, Integer> aTreeList : treeList) {
            while (/*aTreeList.size() < Math.pow(2, 6) && */(int)(Math.log(aTreeList.size() + 1) / Math.log(2.0)) <= 6) {
                aTreeList.put(new Random().nextInt(101) - new Random().nextInt(101), new Random().nextInt(101) - new Random().nextInt(101));
            }
        }
        for (BST<Integer, Integer> aTreeList : treeList) {
            System.out.println(aTreeList.size());
        }
    }

}