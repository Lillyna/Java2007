package course1.lesson6;

//Is a: Van is a Car
public class Van extends Car{
    int seats;
    //private String model; // главнее поля родительского класса

    public Van(String model, int year, int seats){
        super(model, year);
        System.out.println("This is a Van constructor");

        this.seats = seats;
    }
    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    @Override
    void printName(){
        System.out.println("this is a van");
    }
}
