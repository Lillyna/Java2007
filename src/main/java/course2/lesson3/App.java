package course2.lesson3;

import course1.lesson9.Cat;

import java.util.*;

public class App {
    public static void main(String[] args)  {
        int[] i = {1,2,3,4};
        i[0] = 42;

        //Удалить элемент из массива. Сложный код:
//        int ii[] = new int[2];
//        int jj = 0;
//        for (int j = 0; j < i.length; j++) {
//            jj++;
//            if(j==1){
//                jj--;
//                continue;
//            }
//            ii[j] = i[j];
//        }
//        i=ii;

        //Коллекции
        //generics (обобщения) - то, что указано в треугольных скобках: <Ingeter>, <Cat>. Параметризованные коллекции
        ArrayList<String> a = new ArrayList<>(100);// <> diamond operator
        //ArrayList a = new ArrayList();// сырой тип
        a.add("1");
        a.add("2");
        a.add("3");
        //a.add(15675); Так нельзя, если указано <String>
        //a.add(new Cat(1, 2));
        System.out.println(a);
        a.remove(2);
        System.out.println(a);
        a.add(0,"el");//Смещает все остальные элементы вправо
        System.out.println(a);

        final Object[] objects = a.toArray();
        String str = a.get(0);

        //пройтись по коллекции
        for(String s:a){
            System.out.println(s);
        }

        //еще способ пройтись по коллекции
        Iterator<String> iterator = a.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }

        a.trimToSize();//обрезать массив, удалить пустые ячейки (когда уже закончили все манипуляции)
        a.ensureCapacity(150); // увеличить массив массива принудительно

        a.get(2); //O(1) -не зависит от размера массива
        a.add("f"); //O(1) - если только не пришли к моменту, когда массив надо перестроить. O(n) - если надо перестроить
        a.add(4, "gg");// O(n) - линейное время
        boolean d = a.contains("d");// O(n) - бежит по коллекции по всем элементам и ищет
        a.remove(0);
        a.add(0, "ll");
        a.set(0, "7879"); //заменить элемент

        LinkedList<String> link = new LinkedList<>();
        link.add("g");
        link.add(0,"gg");
        link.remove(0);
        boolean a1 = link.contains("a");

        Queue<String> queue = new ArrayDeque<>(); //первый вошел, первый вышел FIFO
        queue.add("jhk");
        queue.offer("kjlkjlkj");//добавляет элемент в конец очереди
        queue.poll(); // возвращает элемент из начала очереди и удаляет его
        final String peek = queue.peek(); // возращает элемент из начала очереди

        HashSet<String> set = new HashSet<>(50);
        set.add("a");
        set.add("b");
        set.add("a");// не добавится, так как повторяется
        System.out.println(set.toString());
        HashSet<String> set1 = new HashSet<>(a); // удалит повторы в a и сделает set
        System.out.println(set1.toString());

        set.add("hgj");
        set.add("nbvbc");
        System.out.println(set.toString());

    }
}
