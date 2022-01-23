package course1.lesson7;

public class Car {

    /**
     * Объем бензобака
     */
    private int volume;

    public Car(int volume) {
        this.volume = volume;
    }

    public int getVolume() {
        return volume;
    }

    public void takeGas(GasStation gasStation){
       gasStation.refill(volume);
    }

    public void findGas(GasStation[] gasStations){
        for(GasStation gasStation:gasStations){
            if(gasStation.getAvailableVol() < volume){
                continue;
            }
            gasStation.refill(volume);
            break;
        }
    }
}
