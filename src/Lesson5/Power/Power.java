package Lesson5.Power;

public class Power {

    // линейное возведение в степень за O(n)
    private static long power(long x, int n) {
        // если ввели отрицательную степень, то выводим -1 как индикатор ошибки, т.к. данный метод не работает с отрицательными степенями
        if (n < 0) {
            return -1;
        }
        long res = 1;
        // если степень равна нулю, то цикл не выполнится ни разу и будет возвращена 1 - x^0 = 1
        for (int i = 1; i <= n; i++) {
            // перемножаем число само на себя n раз
            res *= x;
        }
        return res;
    }

    // бинарное нерекурсивное возведение в степень за O(log n)
    private static long binPower (long x, int n) {
        long res = 1;
        while (n != 0) {
            if ((n & 1) != 0) // проверяем, чётная ли степень; аналогично n % 2 != 0
                res *= x;
            x *= x;
            n >>= 1; // делим чётную степень пополам; аналогично n /= 2
        }
        return res;
    }

    // бинарное рекурсивное возведение в степень за O(log n)
    private static long recursivePower(long x, int n) {
        // ==============================================
        // базовые случаи
        // если ввели отрицательную степень, то выводим -1 как индикатор ошибки, т.к. данный метод не работает с отрицательными степенями
        if (n < 0) {
            return -1;
        }
        // если степень равна нулю, то возвращаем 1 - x^0 = 1
        if (n == 0)
            return 1;
        // ==============================================
        // рекурсивные случаи
        // если степень нечётная, то приводим её к чётной -> x^(n-1) = x^n * x, чтобы применить тождество ниже
        if ((n & 1) != 0) {
            return recursivePower(x, n - 1) * x;
        } else {
            // т.к. x^n = x^(n/2)^2 => x^(n/2) * x^(n/2)
            long y = recursivePower(x, n >> 1);
            return y * y;
        }
    }

    public static void main(String[] args){
        new Thread(() -> {
            long start1 = System.nanoTime();
            long pow1 = power(8,15);
            long finish1 = System.nanoTime();
            System.out.println(pow1 + " линейно за " + (finish1 - start1) + " наносек");
            long start2 = System.nanoTime();
            long pow2 = power(10,22);
            long finish2 = System.nanoTime();
            System.out.println(pow2 + " линейно за " + (finish2 - start2) + " наносек");
        }).start();

        new Thread(() -> {
            long start1 = System.nanoTime();
            long pow1 = binPower(8,15);
            long finish1 = System.nanoTime();
            System.out.println(pow1 + " бинарно за " + (finish1 - start1) + " наносек");
            long start2 = System.nanoTime();
            long pow2 = binPower(10,22);
            long finish2 = System.nanoTime();
            System.out.println(pow2 + " бинарно за " + (finish2 - start2) + " наносек");
        }).start();

        new Thread(() -> {
            long start1 = System.nanoTime();
            long pow1 = recursivePower(8,15);
            long finish1 = System.nanoTime();
            System.out.println(pow1 + " рекурсивно за " + (finish1 - start1) + " наносек");
            long start2 = System.nanoTime();
            long pow2= recursivePower(10,22);
            long finish2 = System.nanoTime();
            System.out.println(pow2 + " рекурсивно за " + (finish2 - start2) + " наносек");
        }).start();


    }
}
