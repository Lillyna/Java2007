package course3.lesson7;

public class Car {
    private String model;
    private int power;
    private int fuelVolume;

    public Car() {

    }

    @FileFieldName(value = "car_model")
    public void setModel(String model) {
        this.model = model;
    }
    @FileFieldName(value = "engine_power")
    public void setPower(int power) {
        this.power = power;
    }
    @FileFieldName(value = "fuel_volume")
    public void setFuelVolume(int fuelVolume) {
        this.fuelVolume = fuelVolume;
    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", power=" + power +
                ", fuelVolume=" + fuelVolume +
                '}';
    }
}
