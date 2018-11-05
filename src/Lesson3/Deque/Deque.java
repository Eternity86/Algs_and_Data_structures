package Lesson3.Deque;

import java.util.NoSuchElementException;

public class Deque<Item> {
    private Item[] items = (Item[]) new Object[0];

    // Количество элементов в очереди.
    private int size;

    // Индекс первого (самого старого) элемента.
    private int head;

    // Индекс последнего (самого нового) элемента.
    private int tail;

    public Deque() {
        size = 0;
        head = 0;
        tail = -1;
    }

    private void resize(int startingIndex)
    {
        int newLength = (size == 0) ? 4 : size * 2;

        Item[] newArray = (Item[]) new Object[newLength];

        if (size > 0)
        {
            int targetIndex = startingIndex;

            // Копируем содержимое...
            // Если массив не закольцован, просто копируем элементы.
            // В противном случае, копирует от head до конца, а затем от начала массива до tail.

            // Если tail меньше, чем head, переходим в начало.
            if (tail < head)
            {
                // Копируем _items[head].._items[end] в newArray[0]..newArray[N].
                for (int index = head; index < items.length; index++)
                {
                    newArray[targetIndex] = items[index];
                    targetIndex++;
                }

                // Копируем _items[0].._items[tail] в newArray[N+1]..
                for (int index = 0; index <= tail; index++)
                {
                    newArray[targetIndex] = items[index];
                    targetIndex++;
                }
            }
            else
            {
                // Копируем _items[head].._items[tail] в newArray[0]..newArray[N]
                for (int index = head; index <= tail; index++)
                {
                    newArray[targetIndex] = items[index];
                    targetIndex++;
                }
            }

            head = startingIndex;
            tail = targetIndex - 1;
        }
        else
        {
            // Массив пуст.
            head = 0;
            tail = -1;
        }

        items = newArray;
    }

    public void enqueueFirst(Item item)
    {
        // Проверим, необходимо ли увеличение массива:
        if (items.length == size)
        {
            resize(1);
        }

        // Так как массив не заполнен и _head больше 0,
        // мы знаем, что есть место в начале массива.
        if (head > 0)
        {
            head--;
        }
        else
        {
            // В противном случае мы должны закольцеваться.
            head = items.length - 1;
        }

        items[head] = item;

        size++;

        if (size == 1)
        {
            // Если мы добавили первый элемент в пустую
            // очередь, он же будет и последним, поэтому
            // нужно обновить и _tail.
            tail = head;
        }
    }

    public void enqueueLast(Item item)
    {
        // Проверим, необходимо ли увеличение массива:
        if (items.length == size)
        {
            resize(0);
        }

        // Теперь, когда у нас есть подходящий массив,
        // если _tail в конце массива, нам надо перейти в начало.
        if (tail == items.length - 1)
        {
            tail = 0;
        }
        else
        {
            tail++;
        }

        items[tail] = item;
        size++;

        if (size == 1)
        {
            // Если мы добавили последний элемент в пустую
            // очередь, он же будет и первым, поэтому
            // нужно обновить и _head.
            head = tail;
        }
    }

    public Item dequeueFirst()
    {
        if (size == 0)
        {
            throw new NoSuchElementException("The deque is empty");
        }

        Item value = items[head];

        if (head == items.length - 1)
        {
            // Если head установлен на последнем индексе, переходим к началу массива.
            head = 0;
        }
        else
        {
            // Переходим к следующему элементу.
            head++;
        }

        size--;

        return value;
    }

    public Item dequeueLast()
    {
        if (size == 0)
        {
            throw new NoSuchElementException("The deque is empty");
        }

        Item value = items[tail];

        if (tail == 0)
        {
            // Если tail установлен на начало массива, переходим к концу.
            tail = items.length - 1;
        }
        else
        {
            // Переходим к предыдущему элементу.
            tail--;
        }

        size--;

        return value;
    }

    public Item peekFirst()
    {
        if (size == 0)
        {
            throw new NoSuchElementException("The deque is empty");
        }

        return items[head];
    }

    public Item peekLast()
    {
        if (size == 0)
        {
            throw new NoSuchElementException("The deque is empty");
        }

        return items[tail];
    }

    public int getSize() {
        return size;
    }

}
