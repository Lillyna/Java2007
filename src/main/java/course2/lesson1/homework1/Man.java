package course2.lesson1.homework1;

public class Man implements Actionable {
    final private int maxRunDistance;
    final private float maxJumpHeight;

    public Man(int maxRunDistance, float maxJumpHeight) {
        this.maxRunDistance = maxRunDistance;
        this.maxJumpHeight = maxJumpHeight;
    }

    @Override
    public boolean jump(float height) {
        if (height <= maxJumpHeight) {
            System.out.println("Человек прыгает");
            return true;
        } else {
            System.out.println("Слишком высоко для человека");
            return false;
        }
    }

    @Override
    public boolean run(float distance) {
        if (distance <= maxRunDistance) {
            System.out.println("Человек бежит");
            return true;
        } else {
            System.out.println("Дистанция слишком длинная для человека");
            return false;
        }

    }
}
