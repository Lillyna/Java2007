package course3.lesson1;

import course2.homework1.Wall;

import java.util.ArrayList;
import java.util.List;

//параметризованный класс
public class Zoo<T extends Animal> { //при компиляции типы стираются, вместо них подставляется Object в общем случае
    private List<T> animals;


    private T animal;
    public Zoo() {
        this.animals = new ArrayList<>();
    }
    public void encage(T animal){
        animals.add(animal);
    }
    public T release (T animal){
        //new T() --так нельзя написать
        if(animals.contains(animal)){
            animals.remove(animal);
            return animal;
        }
        return null;
    }

    //В статическом методе нельзя использовать дженерики, так как статики принадлежат классу, а не к инстансу класса. А что такое дженерик, становится
    //известно только в момент создания инстанса
//    private static void create (T animal){
//
//    }
    // так можно - параметризованный метод:
    public static<V, S> V create (V cat){
        return null;
    }
    public <L> void create1 (L animal){

    }
// фабричный метод - статический метод, который создает какой-то объект
//    public static <W> Zoo<W> create(){
//return null;
//    }

}
