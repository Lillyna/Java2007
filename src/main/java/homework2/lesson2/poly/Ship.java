package homework2.lesson2.poly;

public class Ship extends WaterTransport {
    int waterLine;

    public int getWaterLine() {
        return waterLine;
    }

    public void setWaterLine(int waterLine) {
        this.waterLine = waterLine;
    }

    @Override
    void load() {
        System.out.println("Загрузка корабля");
    }

    @Override
    public void swim() {
        System.out.println("Корабль плывет очень медленно");
    }
}
