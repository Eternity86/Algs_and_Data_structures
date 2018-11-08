package Lesson5.KnapsackProblem.DynamicProgramming;

import java.util.List;

public class Solution {

    // список предметов с максимальной ценностью для помещения в рюкзак
    private List<Item> items;
    // максимально возможная ценность
    private int value;

    Solution(List<Item> items, int value) {
        this.items = items;
        this.value = value;
    }

    void display() {
        if (items != null  &&  !items.isEmpty()){
            System.out.println("\nРешение задачи");
            System.out.println("Максимально возможная ценность предметов = " + value);
            System.out.println("Берём следующие предметы :");

            for (Item item : items) {
                System.out.println("- " + item.toString());
            }
        }
    }

}
