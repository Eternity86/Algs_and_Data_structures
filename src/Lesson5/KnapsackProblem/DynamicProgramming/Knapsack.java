/*
Задача о рюкзаке
https://medium.com/@ssaurel/solving-the-knapsack-problem-in-java-c985c71a7e64
 */
package Lesson5.KnapsackProblem.DynamicProgramming;

import java.util.ArrayList;
import java.util.List;

public class Knapsack {

    // массив предметов, участвующих в задаче
    private Item[] items;
    // вместимость рюкзака
    private int capacity;

    Knapsack(Item[] items, int capacity) {
        this.items = items;
        this.capacity = capacity;
    }

    void display() {
        if (items != null  &&  items.length > 0) {
            System.out.println("Задача о рюкзаке");
            System.out.println("Максимальная вместимость рюкзака : " + capacity);
            System.out.println("Имеющиеся предметы :");

            for (Item item : items) {
                System.out.println("- " + item.toString());
            }
        }
    }

    // алгоритм решения
    Solution solve() {
        int NB_ITEMS = items.length;
        // используем двумерный массив - матрицу, чтобы хранить максимальную ценность каждого n-ого предмета
        int[][] matrix = new int[NB_ITEMS + 1][capacity + 1];

        // первую строчку инициализируем 0
        for (int i = 0; i <= capacity; i++)
            matrix[0][i] = 0;

        // пробегаемся по всем предметам
        for (int i = 1; i <= NB_ITEMS; i++) {
            // пробегаемся по каждой вместимости
            for (int j = 0; j <= capacity; j++) {
                if (items[i - 1].getWeight() > j)
                    matrix[i][j] = matrix[i-1][j];
                else
                    // максимизируем ценность в этом ранге двумерного массива - матрице
                    matrix[i][j] = Math.max(matrix[i-1][j], matrix[i-1][j - items[i-1].getWeight()]
                            + items[i-1].getValue());
            }
        }

        int res = matrix[NB_ITEMS][capacity];
        int w = capacity;
        List<Item> itemsSolution = new ArrayList<>();

        for (int i = NB_ITEMS; i > 0  &&  res > 0; i--) {
            if (res != matrix[i-1][w]) {
                itemsSolution.add(items[i-1]);
                // удаляем ценность и вес предметов
                res -= items[i-1].getValue();
                w -= items[i-1].getWeight();
            }
        }

        return new Solution(itemsSolution, matrix[NB_ITEMS][capacity]);
    }

}
