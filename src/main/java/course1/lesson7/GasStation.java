package course1.lesson7;

public class GasStation {
    private int availableVol;

    public GasStation(int availableVol) {
        this.availableVol = availableVol;
    }

    public int getAvailableVol() {
        return availableVol;
    }

    public void setAvailableVol(int availableVol) {
        this.availableVol = availableVol;
    }

    public void refill(int amount){
        this.availableVol = this.availableVol - amount;
    }

    @Override
    public String toString() {
        return "GasStation: " + availableVol;
    }
    public void info(){
        System.out.println(this);
    }
}
