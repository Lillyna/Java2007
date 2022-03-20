package course2.lesson111.interfaces;

public interface HardWorkable extends Workable{
    void hardWork();
    default void workVeryHard(){
        hardWork();
        System.out.println("По умолчанию очень тяжело");
    };
}
