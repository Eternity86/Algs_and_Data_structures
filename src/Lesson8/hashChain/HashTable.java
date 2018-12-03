package Lesson8.hashChain;

class HashTable {
    private SortedList[] hashArray;
    private int arraySize;

    HashTable(int size) {
        arraySize = size;
        hashArray = new SortedList[arraySize];
        for (int i = 0; i < arraySize; i++) {
            hashArray[i] = new SortedList();
        }
    }

    void displayTable() {
        for (int i = 0; i < arraySize; i++) {
            System.out.print(i + ". ");
            hashArray[i].displayList();
        }
    }

    private int hashFunc(int key) {
        return key % arraySize;
    }

    void insert(Link theLink) {
        int key = theLink.getKey();
        int hashVal = hashFunc(key);
        hashArray[hashVal].insert(theLink);
    }

    void delete(int key) {
        int hashVal = hashFunc(key);
        hashArray[hashVal].delete(key);
    }

    Link find(int key) {
        int hashVal = hashFunc(key);
        return hashArray[hashVal].find(key);
    }

}