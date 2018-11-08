package Lesson5.KnapsackProblem.Recursive;

/* A Naive recursive implementation of 0-1 Knapsack problem */
class Knapsack
{

    // A utility function that returns maximum of two integers
    private static int max(int a, int b) { return (a > b)? a : b; }

    // Returns the maximum value that can be put in a knapsack of capacity W
    private static int knapSack(int W, int wt[], int val[], int n)
    {
        // Base Case
        if (n == 0 || W == 0)
            return 0;

        // If weight of the n-th item is more than Knapsack capacity W, then
        // this item cannot be included in the optimal solution
        if (wt[n - 1] > W)
            return knapSack(W, wt, val, n - 1);

            // Return the maximum of two cases:
            // (1) n-th item included
            // (2) not included
        else return max(
                val[n - 1] + knapSack(W - wt[n - 1], wt, val, n - 1),
                knapSack(W, wt, val, n - 1)
        );
    }


    // Driver program to test above function
    public static void main(String args[])
    {
        Item[] items = {
                new Item("Меч", 10, 8),
                new Item("Ожерелье", 2, 1),
                new Item("Щит", 2, 2),
                new Item("Перчатки", 1, 1),
                new Item("Сапоги", 4, 4)
        };
        int value[] = new int[]{60, 100, 120};
        int weight[] = new int[]{10, 20, 30};
        int W = 50;
        int n = value.length;
        System.out.println(knapSack(W, weight, value, n));
    }
}