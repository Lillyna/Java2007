package course3.lesson1;

public class Cat implements Comparable<Cat>{
    private double weight;

    public Cat(double weight) {
        this.weight = weight;
    }

    @Override
    public int compareTo(Cat o) {
        return (int)(weight - o.weight);
    }

    @Override
    public String toString() {
        return "cat " + weight;
    }
}
