package course1.lesson5;

public class Car {

    public static int wheelsNumber=0;

    //fields
    private String model;
    private String modelFull;
    private int year;
    private boolean wasCrashed;

    //Constructor
    public Car(String model, int year, boolean wasCrashed){
        this.model = model;
        this.year = year;
        this.wasCrashed = wasCrashed;
    }
    public Car(String model, int year){
       this(model,year, false); // вызов другого конструктора самого себя
    }
    public Car(String model){
        this(model, 2020);//вызовется 3 конструктора по очереди в конце концов
    }

    /**
     * Выводит на экран информацию о машине
     */
    public void info(){
        System.out.println("model = "+ model + ", year = "+ year + ", wasCrashed = "+ wasCrashed + ", wheelsNumber = "+ wheelsNumber);
    }
    public void printModel(){
        System.out.println("model = "+ model);
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }


    public boolean isWasCrashed() {
        return wasCrashed;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setYear(int year) {
        if (year > 0) {
            this.year = year;
        }
        else{
            System.out.println("Error");
        }
    }
    public void setWasCrashed(boolean wasCrashed) {
        this.wasCrashed = wasCrashed;
    }

    /**
     * Попала в аварию
     */
    public void crash(){
        System.out.println("Car was crashed");
        wasCrashed = true;
    }
    public void repair(){
        if(wasCrashed){
            wasCrashed = false;
            System.out.println("Repaired");
        }
        else{
            System.out.println("Nothing to repair");
        }
    }
}
