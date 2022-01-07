package course2.lesson1.interfaces;

public interface HardWorkable extends Workable{

    void workHard();
    void work();
    default void workVeryHard(){
        workHard();
        System.out.println("По умолчанию очень тяжело");
    };

}
