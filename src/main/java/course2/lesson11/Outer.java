package course2.lesson11;

public class Outer {
    private int i;
    private static int a;

    public Outer() {

        System.out.println("Outer");
    }

    private void m1(){
        class A{

        }
        //локальный класс
        final A a = new A();
        i = 10;
        Outer.a = 11;
    }

    private static void staticM(){
        a = 1;
    }

    //класс внутри класса
    //имеет доступ к переменным внешнего класса
    // внутренний класса
    class Inner {
        private int b;

        public Inner() {

            System.out.println("Inner");
        }

        private void v(){
            i = 11;
        }

    }

    //вложенный класс
    private static class StaticInner{
        public StaticInner(){
            System.out.println("StaticInner");
        }


    }

    public static void main(String[] args) {
        final Outer.Inner inner = new Outer().new Inner();
        final Outer.StaticInner staticInner = new Outer.StaticInner();
    }
}
