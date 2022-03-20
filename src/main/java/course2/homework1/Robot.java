package course2.homework1;

public class Robot implements Runable, Jumpable {

    String name;
    int jumpHeight;
    int runDistance;

    public Robot() {
        this.name = "R2D2";
        this.jumpHeight = 0;
        this.runDistance = 1000;
    }

    public Robot(String name, int jumpHeight, int runDistance) {
        this.jumpHeight = jumpHeight;
        this.name = name;
        this.runDistance = runDistance;
    }

    @Override
    public void doJump() {
        System.out.println("Robot " + this.name + " is jumping");
    }

    @Override
    public void doRun() {
        System.out.println("Robot " + this.name + " is running");
    }

    public int getJumpHeight() {
        return jumpHeight;
    }

    public int getRunDistance() {
        return runDistance;
    }

    public String toString() {
        return "Robot " + this.name;
    }
}
