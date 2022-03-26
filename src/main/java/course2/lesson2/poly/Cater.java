package course2.lesson2.poly;

public class Cater extends Transport implements Swimable{

    private int speed;

    @Override
    void load() {
        System.out.println("Диско-шар и алкоголь");
    }

    @Override
    public void swim() {
        System.out.println("Плывет катер");
    }
}
