package course3.lesson1;

public class Snake extends Animal {
    public Snake(String name, int age) {
        super(name, age);
    }

    @Override
    public void feed() {
        System.out.println("I eat eggs");
    }
}
