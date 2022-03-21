package course2.lesson1.homework1;

public class Robot implements Actionable {

    final private int maxRunDistance;
    final private float maxJumpHeight;

    public Robot(int maxRunDistance, float maxJumpHeight) {
        this.maxRunDistance = maxRunDistance;
        this.maxJumpHeight = maxJumpHeight;
    }

    @Override
    public boolean jump(float height) {
        if (height <= maxJumpHeight) {
            System.out.println("Робот прыгает");
            return true;
        } else {
            System.out.println("Слишком высоко для робота");
            return false;
        }
    }

    @Override
    public boolean run(float distance) {
        if (distance <= maxRunDistance) {
            System.out.println("Робот бежит");
            return true;
        } else {
            System.out.println("Дистанция слишком длинная для робота");
            return false;
        }
    }
}
