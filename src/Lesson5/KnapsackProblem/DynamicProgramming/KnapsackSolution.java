package Lesson5.KnapsackProblem.DynamicProgramming;

public class KnapsackSolution {
    public static void main(String[] args) {

        Item[] items = {
                new Item("Меч", 10, 8),
                new Item("Ожерелье", 2, 1),
                new Item("Щит", 2, 2),
                new Item("Перчатки", 1, 1),
                new Item("Сапоги", 4, 4)
        };

        Knapsack knapsack = new Knapsack(items, 10);
        knapsack.display();
        Solution solution = knapsack.solve();
        solution.display();
    }
}
