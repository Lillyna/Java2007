package course3.homework1.task3;

import java.util.ArrayList;

public class Box<T extends Fruit> implements Comparable<Box> {
    private float weight;
    final private ArrayList<T> fruitsInside;

    public Box() {
        this.weight = 0f;
        this.fruitsInside = new ArrayList<>();
    }

    public float getWeight() {
        return weight;
    }

    private void setWeight(float weight) {
        this.weight = weight;
    }

    /**
     * Puts one fruit into the box
     *
     * @param fruit - fruit of defined sort
     */
    public void put(T fruit) {
        fruitsInside.add(fruit);
        weight += fruit.getWeight();
    }

    /**
     * Compares weights of this box and other box
     *
     * @param o - other box
     * @return true if weights are equal, false - otherwise
     */
    public boolean compareBoxes(Box o) {
        return Math.abs(this.getWeight() - o.getWeight()) < 0.001f;
    }

    /**
     * Empties the box
     */
    private void emptyBox() {
        fruitsInside.clear();
        setWeight(0f);
    }

    /**
     * Takes all fruits from this box and puts them into the other box
     *
     * @param box - the other box
     */
    public void shiftFromBoxToBox(Box<T> box) {
        for (T fruit : this.fruitsInside) {
            box.put(fruit);
        }
        emptyBox();
    }

    @Override
    public int compareTo(Box o) {
        return (int) Math.abs(this.getWeight() - o.getWeight());
    }
}
