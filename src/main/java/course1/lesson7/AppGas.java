package course1.lesson7;

public class AppGas {
    public static void main(String[] args) {
        Car car = new Car(60);
        GasStation gasStation = new GasStation(1000);

        gasStation.info();

        car.takeGas(gasStation);

        gasStation.info();
    }
}
