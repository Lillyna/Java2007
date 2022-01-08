package course2.homework1;

public class Cat implements Runable, Jumpable{

    String name;
    int jumpHeight;
    int runDistance;

    public Cat(){
        this.name = "Tom";
        this.jumpHeight = 3;
        this.runDistance = 1;
    }

    public Cat( String name,int jumpHeight,int runDistance){
        this.name = name;
        this.jumpHeight = jumpHeight;
        this.runDistance = runDistance;
    }
    @Override
    public void doJump() {
        System.out.println("Cat "+ this.name + " is jumping");
    }

    @Override
    public void doRun() {
        System.out.println("Cat "+ this.name + " is running");
    }

    public int getJumpHeight() {
        return jumpHeight;
    }

    public int getRunDistance() {
        return runDistance;
    }

    public String toString(){
        return "Cat "+ this.name;
    }
}
