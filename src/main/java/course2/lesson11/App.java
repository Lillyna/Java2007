package course2.lesson11;

import java.time.LocalDate;

abstract class Vehicle{
    private String model;
    private String type;
    public abstract void move();
}

class Bike extends Vehicle{
    @Override
    public void move() {

    }
}

class Human {
    protected String name;
    private LocalDate birthday;
    private int course;
    private boolean stillStudy;
    private static int count;

    public Human() {
        this("Иван", LocalDate.of(2010,10,10), 1, true);
    }

    private Human(String name, LocalDate birthday, int course) {
        this(name, birthday, course,true);
    }

    public Human(String name, LocalDate birthday, int course, boolean stillStudy) {
        this.name = name;
        this.birthday = birthday;
        this.course = course;
        this.stillStudy = stillStudy;
        count++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        Human.count = count;
    }
}

class Student{
    private Integer course;
    private String speciality;


    public Integer getCourse() {
        return course;
    }

    public void setCourse(Integer course) {
        this.course = course;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

}
public class App {
    //ООП
    //0. Абстракция
    //1. Инкапсуляция
    //2. Наследование
    //3. Полиморфизм
    public static void main(String[] args) {
        final Student student = new Student();
        final Vehicle vehicle = new Bike();
        String abc = "abc";
        Object o = new String("abc");
        //Object o = new Integer(1);
        if (o instanceof String){
            final int length = ((String) o).length();
        }

        final Employee employee = new Employee(1, "Ivan", "Ivanov");
        final Employee.Builder builder = new Employee.Builder();

        }
}
