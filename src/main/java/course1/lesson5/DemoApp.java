package course1.lesson5;

public class DemoApp {
    public static void main(String[] args) {
        Car car = new Car("Dodge", 2020, false);

        car.info();
        car.crash();
        car.info();


        Car car2 = new Car("Ford", 1990);

        car2.printModel();
        String carModel = car2.getModel();
        System.out.println("model = "+ car.getModel() + ", year = "+ car.getYear() + ", wasCrashed = "+ car.isWasCrashed() + ", wheelsNumber = "+ car.wheelsNumber);
        System.out.println("model = "+ car2.getModel() + ", year = "+ car2.getYear() + ", wasCrashed = "+ car2.isWasCrashed() + ", wheelsNumber = "+ car2.wheelsNumber);

        int wheelNumer = Car.wheelsNumber;// можно запросить сразу у класса, а не у объекта.
        Car[] cars = new Car[]{car, car2};

        //stringpool
        String str = new String("newString"); // эта строка не пойдет в stringpool, а пойдет просто в heap
    }
}
