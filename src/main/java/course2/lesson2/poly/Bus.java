package course2.lesson2.poly;

public class Bus extends Transport {
    int route;

    public int getRoute() {
        return route;
    }

    public void setRoute(int route) {
        this.route = route;
    }

    @Override
    void load() {
        System.out.println("Люди ломятся в автобус");
    }
}
