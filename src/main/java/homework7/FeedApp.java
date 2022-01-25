package homework7;

public class FeedApp {
    public static void main(String[] args) {

        int needRefillAmount = 5;
        Cat cat1 = new Cat("Tom", 5);
        Cat cat2 = new Cat("Pushok", 15);
        Cat cat3 = new Cat("Billy", 3);
        Cat cat4 = new Cat("Barsik", 6);
        Cat cat5 = new Cat("Vasily", 7);
        Cat cat6 = new Cat("Mashka", 10);
        Cat cat7 = new Cat("Muska", 9);

        Cat[] cats = {cat1, cat2, cat3, cat4, cat5, cat6, cat7};
        Plate plate = new Plate(50);
        plate.info();
        for (Cat cat : cats) {
            cat.eat(plate);
            cat.catInfo();
        }
        plate.info();
        if (plate.getFood() <= needRefillAmount) {
            plate.refill(90);
        }
        plate.info();
    }
}
