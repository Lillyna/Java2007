package course2.lesson1.homework1;

public class Wall extends Surmountable {
    final private float height;

    public Wall(float height) {
        this.height = height;
    }

    public boolean action(Actionable actionable) {
        if (actionable.jump(height)) {
            System.out.println("Успешно перепрыгнул");
            return true;
        } else {
            System.out.println("Не перепрыгнул");
            return false;
        }
    }
}
