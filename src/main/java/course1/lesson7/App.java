package course1.lesson7;

import course1.lesson6.Bike;
import course1.lesson6.Cabrio;
import course1.lesson6.Car;
import course1.lesson6.Transport;

public class App {
    public static void main(String[] args) {
        Transport transport1 = new Car("kia", 1900 );
        Transport transport2 = new Cabrio("kia", 1900, true );
        Transport transport3 = new Bike(2);
        Transport[] transports = {transport1,transport2,transport3};
        for(Transport transport:transports){
            transport.wroomWroom();
            transport.printInventionDate();
        }
    }
}
