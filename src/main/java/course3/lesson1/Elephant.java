package course3.lesson1;

public class Elephant extends Animal {
    public Elephant(String name, int age) {
        super(name, age);
    }

    @Override
    public void feed() {
        System.out.println("I eat grass");
    }
}
