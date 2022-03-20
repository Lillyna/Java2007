package course2.lesson1.homework1;

public class App {
    public static void main(String[] args) {
        Man man = new Man(100, 1f);
        Cat cat = new Cat(50, 0.5f);
        Robot robot = new Robot(500, 3f);
        Wall wall = new Wall(1.1f);
        Treadmill treadmill = new Treadmill(45);

        Actionable[] actionables = new Actionable[]{man, cat, robot};
        Surmountable[] barriers = new Surmountable[]{wall, treadmill};

        for (Actionable actionable : actionables) {
            for (Surmountable barrier : barriers) {
                boolean isSuccess = barrier.action(actionable);
                if (!isSuccess) break;
            }
        }
    }
}
