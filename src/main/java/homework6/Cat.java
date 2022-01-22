package homework6;

public class Cat extends Animal {
    final int MAX_RUN_DISTANCE = 200;

    public Cat(String name, int runDistance) {
        super(name, runDistance);
        if (runDistance <= MAX_RUN_DISTANCE) {
            this.runability = runDistance;
        } else {
            this.runability = MAX_RUN_DISTANCE;
            System.out.println("Задано недопустимое значение для выносливости кота, создан кот с дефолтной выносливостью.");
        }
    }

    @Override
    void swim(int distance) {
        System.out.println(this.name + " утонул, потому что не умеет плавать.");
    }

}
