package homework2.lesson2.poly;

public class Yacht extends Transport implements Swimmable{
    private int speed;

    @Override
    void load() {
        System.out.println("Диско-шар и алкоголь");
    }
}
