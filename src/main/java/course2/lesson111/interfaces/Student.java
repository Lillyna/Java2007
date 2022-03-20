package course2.lesson111.interfaces;

public class Student implements Studyable, HardWorkable{

    @Override
    public void study() {
        System.out.println("Студент учится только перед сессией");
    }

    @Override
    public void work() {
        System.out.println("Студент еще и работает");
    }

    @Override
    public void hardWork() {
        System.out.println("Студент еще и работает как Папа Карло");
    }

    @Override
    public void workVeryHard() {
        HardWorkable.super.workVeryHard();
    }
}
