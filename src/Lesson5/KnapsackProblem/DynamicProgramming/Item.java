package Lesson5.KnapsackProblem.DynamicProgramming;

public class Item {

    private String name;
    private int value;
    private int weight;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Item(String name, int value, int weight) {
        this.name = name;
        this.value = value;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return name + " [ценность = " + value + ", вес = " + weight + "]";
    }

}