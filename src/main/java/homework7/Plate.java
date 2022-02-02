package homework7;

public class Plate {
    private int food;

    public Plate(int food) {
        this.food = food;
    }

    public void info() {
        System.out.println("Plate: " + food);
    }

    public int getFood() {
        return food;
    }

    public boolean decreaseFood(int n) {
        if (food >= n) {
            food -= n;
            return true;
        } else {
            System.out.println("Кушать нечего! Иди на охоту!");
            return false;
        }
    }

    public void refill(int amount) {
        food += amount;
    }
}
