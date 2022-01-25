package homework7;

public class Cat {

    private final String name;
    private final int appetite;
    private boolean bellyful;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        this.bellyful = false;
    }

    public void eat(Plate plate) {
        bellyful = plate.decreaseFood(appetite);
    }

    public void catInfo() {
        if (bellyful) {
            System.out.println("Cat " + name + " is full.");
        } else System.out.println("Cat " + name + " is hungry.");
    }
}
