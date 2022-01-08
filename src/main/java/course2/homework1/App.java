package course2.homework1;

public class App {
    public static void main(String[] args) {
        //no-args constructor objects
        Wall wall = new Wall();
        Treadmill treadmill = new Treadmill();
        Human human = new Human();
        Cat cat = new Cat();
        Robot robot = new Robot();
        //parameterized constructor objects
        Wall wall1 = new Wall("Wooden", 10);
        Treadmill treadmill1 = new Treadmill("Xiaomi", 200);
        Human human1 = new Human(30, "Sam", "female", 2, 200);
        Cat cat1 = new Cat("Charlie", 7, 1);
        Robot robot1 = new Robot("Spot", 20, 1500);
        Barrier[] barriers = new Barrier[]{wall, treadmill, wall1, treadmill1};
        Object[] objects = new Object[]{human, cat, robot, human1, cat1, robot1};

        //make all party take every barrier
        System.out.println("Task 3");
        for (Object object : objects) {
            System.out.println("\nParticipant: " + object.toString());
            for (Barrier barrier : barriers) {
                System.out.println("Barrier: " + barrier.toString());
                barrier.takeBarrier(object);
            }
        }

        //make all party take every barrier if they can
        System.out.println("\nTask 4");
        for (Object object : objects) {
            System.out.println("\nParticipant: " + object.toString());
            for (Barrier barrier : barriers) {
                System.out.println("Barrier: " + barrier.toString());
                if (!barrier.canManage(object)) {
                    System.out.println("The barrier " + barrier.toString() + " was too hard to overcome for " + object.toString() + ". Got out of the race.");
                    break;
                }
                barrier.takeBarrier(object);
            }
        }
    }
}
