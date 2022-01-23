package course1.lesson6;

import course1.lesson7.Invention;

public abstract class Transport extends Invention {

    protected String color;

    void printName(){
        System.out.println("Transport");
    }

    public abstract void wroomWroom();

    //public abstract int getCapacity();

    @Override
    public void printInventionDate() {
        System.out.println("1900");
    }
}
