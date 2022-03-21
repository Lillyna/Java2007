package course2.lesson1.homework1;

public class Cat implements Actionable {
    final private int maxRunDistance;
    final private float maxJumpHeight;

    public Cat(int maxRunDistance, float maxJumpHeight) {
        this.maxRunDistance = maxRunDistance;
        this.maxJumpHeight = maxJumpHeight;
    }

    @Override
    public boolean jump(float height) {
        if (height <= maxJumpHeight) {
            System.out.println("Кот прыгает");
            return true;
        } else {
            System.out.println("Слишком высоко для кота");
            return false;
        }
    }

    @Override
    public boolean run(float distance) {
        if (distance <= maxRunDistance) {
            System.out.println("Кот бежит");
            return true;
        } else {
            System.out.println("Дистанция слишком длинная для кота");
            return false;
        }
    }
}
