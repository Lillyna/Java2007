package course2.lesson2.poly;

public class WaterTransport extends Transport implements Swimable{
    @Override
    public void swim() {
        Swimable.super.swim();
    }

    @Override
    void load() {

    }
}
