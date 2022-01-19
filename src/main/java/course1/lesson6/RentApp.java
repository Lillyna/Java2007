package course1.lesson6;

import java.sql.SQLOutput;
import java.util.Arrays;

public class RentApp {
    public static void main(String[] args) {
        Car car = new Car("Toyota", 2012);
        System.out.println();
        Car van = new Van("Ford", 2020,7); //можно слева указать Car, но тогда у него будут поля только Car, количества мест не будет
        Car cabrio = new Cabrio("Peugeot", 2015, true);
        System.out.println(car instanceof Car);//true
        System.out.println(van instanceof Car);//true
        System.out.println(car instanceof Van);//false
        System.out.println(cabrio instanceof Van);//false
        System.out.println(cabrio instanceof Transport);//true


        Car[] cars = {car, cabrio, van};
        for (Car c: cars){
            System.out.println(c.getModel());
            System.out.println(c.toString());
        }
        System.out.println("Only vans");
        for(Car c:cars){
            if(c instanceof Van){
                Van v = (Van) c;
                System.out.println("this is a van " + c.getModel() + v.getSeats() + ((Van) c).getSeats());
            }
        }
        System.out.println();
        String model = van.getModel();
        System.out.println(model);

        Transport[] transports = {car, cabrio, van};
        for (Transport c: transports){
            c.printName();
        }
        System.out.println(Arrays.toString(transports));// заработает при переопределенном методе toString()
    }

}
