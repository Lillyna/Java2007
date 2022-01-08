package course2.homework1;

public class Human implements Runable, Jumpable{
    String name;
    String sex;
    int jumpHeight;
    int runDistance;

    int age;
    public Human(){
        this.age = 25;
        this.name = "Paul";
        this.sex = "male";
        this.jumpHeight = 1;
        this.runDistance = 100;
    }
    public Human(int age, String name, String sex, int jumpHeight, int runDistance){
        this.age = age;
        this.name = name;
        this.sex = sex;
        this.jumpHeight = jumpHeight;
        this.runDistance = runDistance;
    }
    @Override
    public void doJump() {
        System.out.println("Man "+ this.name + " is jumping");
    }

    @Override
    public void doRun() {
        System.out.println("Man "+ this.name + " is running");
    }
    public int getJumpHeight() {
        return jumpHeight;
    }

    public int getRunDistance() {
        return runDistance;
    }
    public String toString(){
        return "Human " + this.name;
    }
}
