package homework6;

public class Dog extends Animal {

    int swimDistance;
    final int MAX_SWIM_DISTANCE = 10;
    final int MAX_RUN_DISTANCE = 500;

    public Dog(String name, int runDistance, int swimDistance) {
        super(name, runDistance);
        if (runDistance <= MAX_RUN_DISTANCE) {
            this.runability = runDistance;
        } else {
            this.runability = MAX_RUN_DISTANCE;
            System.out.println("Задано недопустимое значение для выносливости в беге для собаки, создана собака " +
                    "с дефолтной выносливостью.");
        }

        if (swimDistance <= MAX_SWIM_DISTANCE) {
            this.swimDistance = swimDistance;
        } else {
            this.swimDistance = MAX_SWIM_DISTANCE;
            System.out.println("Задано недопустимое значение для выносливости в плавании для собаки, создана собака " +
                    "с дефолтной выносливостью.");
        }

    }

    @Override
    void swim(int distance) {
        if (distance <= swimDistance && distance > 0) {
            System.out.println(this.name + " проплыл " + distance + " м.");
        } else if (distance > swimDistance) {
            System.out.println(this.name + " проплыл " + swimDistance + " м и утонул.");
        } else {
            System.out.println(this.name + " никуда не плывет, на улице зима.");
        }
    }
}
