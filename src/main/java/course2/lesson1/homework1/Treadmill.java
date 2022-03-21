package course2.lesson1.homework1;

public class Treadmill extends Surmountable {
    final private int length;

    public Treadmill(int length) {
        this.length = length;
    }

    public boolean action(Actionable actionable) {
        if (actionable.run(length)) {
            System.out.println("Успешно пробежал");
            return true;
        } else {
            System.out.println("Не пробежал");
            return false;
        }
    }
}
