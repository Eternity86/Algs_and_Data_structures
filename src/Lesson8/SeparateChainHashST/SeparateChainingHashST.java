package Lesson8.SeparateChainHashST;

public class SeparateChainingHashST<Key, Value> {
    private static final int INIT_CAPACITY = 4;

    private int n;                                // кол-во пар ключ-значение
    private int m;                                // размер хеш-таблицы
    private SequentialSearchST<Key, Value>[] st;  // массив таблиц символов связанных списков


    /**
     * Инициализация пустой таблицы символов
     */
    public SeparateChainingHashST() {
        this(INIT_CAPACITY);
    }

    /**
     * Инициализация пустой таблицы символов с m цепочками.
     */
    public SeparateChainingHashST(int m) {
        this.m = m;
        st = (SequentialSearchST<Key, Value>[]) new SequentialSearchST[m];
        for (int i = 0; i < m; i++)
            st[i] = new SequentialSearchST<>();
    }

    // изменяет размер хеш-таблицы на заданное кол-во цепочек,
    // перехешируя все ключи
    private void resize(int chains) {
        SeparateChainingHashST<Key, Value> temp = new SeparateChainingHashST<>(chains);
        for (int i = 0; i < m; i++) {
            for (Key key : st[i].keys()) {
                temp.put(key, st[i].get(key));
            }
        }
        this.m  = temp.m;
        this.n  = temp.n;
        this.st = temp.st;
    }

    // хеш-значение в диапазоне [0..m-1]
    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % m;
    }

    /**
     * Возвращает кол-во пар ключ-значение в таблице символов.
     */
    public int size() {
        return n;
    }

    /**
     * Возвращает true, если таблица символов пуста.
     */
    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * Возвращает true, если таблица символов содержаит указанный ключ key.
     */
    public boolean contains(Key key) {
        if (key == null) throw new IllegalArgumentException("аргумент метода равен null");
        return get(key) != null;
    }

    /**
     * Возвращает значение, ассоциированное с указанным ключом в таблице символов.
     */
    Value get(Key key) {
        if (key == null) throw new IllegalArgumentException("аргумент метода равен null");
        int i = hash(key);
        return st[i].get(key);
    }

    /**
     * Inserts the specified key-value pair into the symbol table, overwriting the old
     * value with the new value if the symbol table already contains the specified key.
     * Deletes the specified key (and its associated value) from this symbol table
     * if the specified value is null.
     */
    void put(Key key, Value val) {
        if (key == null) throw new IllegalArgumentException("аргумент метода равен null");
        if (val == null) {
            delete(key);
            return;
        }

        // удваивает размер таблицы, если средняя длина списка >= 10
        if (n >= 10*m) resize(2*m);

        int i = hash(key);
        if (!st[i].contains(key)) n++;
        st[i].put(key, val);
    }

    /**
     * Удаляет указнный ключ и ассоциированное значение из таблицы символов
     * (если ключ содержится в таблице).
     */
    public void delete(Key key) {
        if (key == null) throw new IllegalArgumentException("аргумент метода равен null");

        int i = hash(key);
        if (st[i].contains(key)) n--;
        st[i].delete(key);

        // уменьшает таблицу в два раза, если средняя длина списка <= 2
        if (m > INIT_CAPACITY && n <= 2*m) resize(m/2);
    }
    // возвращает ключи в таблице символов в качестве Iterable объекта
    Iterable<Key> keys() {
        Queue<Key> queue = new Queue<Key>();
        for (int i = 0; i < m; i++) {
            for (Key key : st[i].keys())
                queue.enqueue(key);
        }
        return queue;
    }

}