package course3.lesson1;

import java.util.*;

//generics, обобщения
public class App {
    public static void main(String[] args) {

        TreeSet<Cat> cats = new TreeSet<>();
        cats.add(new Cat(3.4));
        cats.add(new Cat(5.6));
        cats.add(new Cat(1.8));
        System.out.println(cats);

//        Zoo<String> s = new Zoo<>(); если Zoo extends Animal, то так нельзя
//        Zoo<Integer> i = new Zoo<>();
        Zoo<Animal> a = new Zoo<>();

        //инвариантность, ковариантность
        //дженерики - инвариантны
        //массивы - ковариантны

//        Object[] a = new String[10]; // допустимо (коваринатность)
//        a[0] = "abc";
//        a[1] = 1; // упадет с ошибкой

        //List<Object> o = new ArrayList<String>(); -- недопустимо (инвариантность)

        List l = new ArrayList<>();
        l.add(1);
        l.add("abc");
        List a1 = new ArrayList();

        Animal[] animals = new Lion[5];//ковариантность - скомпилируется
        //Zoo<Animal> animalZoo = new Zoo<Lion>(); //инвариантность - не скомпилируется




//        String o = (String)l.get(0);
//        if(o instanceof String){
//            String o1 = (String) o;
//        }
//        final String substr = o.substring(2);

        List<String> list = new ArrayList<>();
        list.add("abc");
        //list.add(1); так нельзя
        String s = list.get(0);

//        final Zoo<String> zoo = new Zoo<>();
//        final Zoo<Integer> zoo1 = new Zoo<>();
//        zoo.encage("lion");
//        zoo1.encage(1);
//        String frog = zoo.release("frog");
//        Integer release = zoo1.release(1);

        final Zoo<Animal> zoopark = new Zoo<>();
        Elephant ele = new Elephant("El", 3);
        zoopark.encage(ele);
        zoopark.encage(new Snake("Snak", 4));
        zoopark.encage(new Lion("Simba", 1));
        Animal release1 = zoopark.release(ele);

        Zoo<Snake> serpentarium = new Zoo<>();
        serpentarium.encage(new Snake("Kaa", 19));

      //  Zoo<Animal> animalZoo = Zoo.create();
        App app = new App();
        app.print(2,7);
        app.print("text",2);
        ArrayList<Animal> animalss = new ArrayList<>();
        animalss.add(new Lion("Simba", 1));

        List<? extends Animal> lst = new ArrayList<>();//wildcard - в такую коллекцию положить ничего нельзя
        lst.add(null);
        //app.feedAnimals(lst);
        List<? super Animal> lst11 = new ArrayList<Animal>();// в такую коллекцию можно положить
        List<? super Animal> lst1 = new ArrayList<Object>();
        lst11.add(new Snake("BBB",1));
//        PECS
//        producer extends
//        consumer super

        List<Animal> dst = new ArrayList<>();
        dst.add(null);
        dst.add(null);
        dst.add(null);
        Collections.copy(dst, animalss);

        final List<Lion> lions = Arrays.asList(new Lion("Lion1", 3));
        final List<Snake> snakes = new ArrayList<>();
   //     Collections.copy(snakes, lions);
    }
// в параметризованных методах нужно избегать приведения типов

    private <S, T> void print(S text, T text2){
       // final String t = (String) text;
        System.out.println(text);
    }



//    private void feedAnimals(List<? extends Animal> animals){//producer
//        for(Animal animal: animals){
//            animal.feed();
//        }
//    }
    private void feedAnimals(List<? super Animal> animals){//consumer

    }



}
