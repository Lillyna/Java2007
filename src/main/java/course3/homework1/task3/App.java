package course3.homework1.task3;

public class App {
    public static void main(String[] args) {

        Box<Orange> oranges1 = new Box<>();
        Box<Apple> apples1 = new Box<>();
        Box<Orange> oranges2 = new Box<>();
        Box<Apple> apples2 = new Box<>();

        //Fill the boxes
        for (int i = 0; i < 15; i++) {
            oranges1.put(new Orange());
            oranges2.put(new Orange());
            oranges2.put(new Orange());
            apples1.put(new Apple());
            apples2.put(new Apple());
        }
        System.out.println(String.format("Коробка oranges1 весит %f", oranges1.getWeight()));
        System.out.println(String.format("Коробка oranges2 весит %f", oranges2.getWeight()));
        System.out.println(String.format("Коробка apples1 весит %f", apples1.getWeight()));
        System.out.println(String.format("Коробка apples2 весит %f", apples2.getWeight()));

        //Compare some boxes
        boolean isEqualWeight = oranges1.compareBoxes(oranges2);
        System.out.println(String.format("Вес коробок oranges1 и oranges2 %s", isEqualWeight ? "одинаковый." : "различен."));
        isEqualWeight = oranges1.compareBoxes(apples2);
        System.out.println(String.format("Вес коробок oranges1 и apples2 %s", isEqualWeight ? "одинаковый." : "различен."));
        isEqualWeight = apples1.compareBoxes(apples2);
        System.out.println(String.format("Вес коробок apples1 и apples2 %s", isEqualWeight ? "одинаковый." : "различен."));

        //Shift fruits from one box to another
        oranges2.shiftFromBoxToBox(oranges1);
        System.out.println(String.format("Коробка oranges1 весит %f", oranges1.getWeight()));
        System.out.println(String.format("Коробка oranges2 весит %f", oranges2.getWeight()));
        apples2.shiftFromBoxToBox(apples1);
        System.out.println(String.format("Коробка apples1 весит %f", apples1.getWeight()));
        System.out.println(String.format("Коробка apples2 весит %f", apples2.getWeight()));
    }
}
