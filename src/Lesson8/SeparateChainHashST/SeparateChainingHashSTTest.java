package Lesson8.SeparateChainHashST;

import java.util.Random;

public class SeparateChainingHashSTTest {
    public static void main(String[] args) {
        SeparateChainingHashST<String, Integer> st = new SeparateChainingHashST<>();
        for (int i = 1; i <= 20; i++) {
            st.put(String.valueOf(new Random().nextInt(5)), i);
        }

        // вывести ключи на печать
        for (String s : st.keys())
            StdOut.println(s + " " + st.get(s));

    }
}
