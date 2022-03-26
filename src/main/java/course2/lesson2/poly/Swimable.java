package course2.lesson2.poly;

public interface Swimable {
    default void swim(){
        System.out.println("Плывет как-то по-умолчанию");
    }
}
