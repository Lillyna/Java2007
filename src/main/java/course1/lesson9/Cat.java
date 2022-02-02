package course1.lesson9;

public class Cat extends Animal{

    private int maxRunDistance;
    private int maxSwimDistance;

    public Cat(int maxRunDistance, int maxSwimDistance) {
        this.maxRunDistance = maxRunDistance;
        this.maxSwimDistance = maxSwimDistance;
    }

    @Override
    public void swim(int distance) {
        System.out.println("Cats can't swim");
    }

    @Override
    int getMaxRunDistance() {
        return maxRunDistance;
    }

    @Override
    int getMaxSwimDistance() {
        return maxSwimDistance;
    }

    @Override
    public void run(int distance) {
        if(distance>maxRunDistance){
            return;
        }
        super.run(distance);
    }

}
