package course2.lesson2.poly;

public class Bus extends Transport {
    String route;

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    @Override
    void load() {
        System.out.println("Люди ломятся в автобус");
    }
}
