package course1.lesson5;

public class DemoApp {
    public static void main(String[] args) {
        Car car = new Car();
        car.model = "Dodge";
        car.year = 2020;
        car.wheelsNumber = 4;

        System.out.println("model = "+ car.model + ", year = "+ car.year + ", wasCrashed = "+ car.wasCrashed + ", wheelsNumber = "+ car.wheelsNumber);

        Car car2 = new Car();
        car2.model = "Ford";
        car2.year = 1990;
        car2.wheelsNumber = 6;

        System.out.println("model = "+ car.model + ", year = "+ car.year + ", wasCrashed = "+ car.wasCrashed + ", wheelsNumber = "+ car.wheelsNumber);
        System.out.println("model = "+ car2.model + ", year = "+ car2.year + ", wasCrashed = "+ car2.wasCrashed + ", wheelsNumber = "+ car2.wheelsNumber);

        int wheelNumer = Car.wheelsNumber;// можно запросить сразу у класса, а не у объекта.
        Car[] cars = new Car[]{car, car2};

        //stringpool
        String str = new String("newString"); // эта строка не пойдет в stringpool, а пойдет просто в heap
    }
}
