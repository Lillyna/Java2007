package course2.lesson2_22_03;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class App1 {

    public static void main(String[] args) throws MyException {
        int b = 1;
        final App app = new App();
      // m(0);
//        System.out.println("Продолжаем работать");
//        try {
//            final int ll = l(8);
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
        lw(1);
    }
    private static void m (Integer b){
        try{
            int a = 10/b;
        } catch (ArithmeticException | NullPointerException e){
            System.out.println("Ошибка " + e.getMessage());
            e.printStackTrace();
            throw new ArithmeticException();

//        } catch (StackOverflowError e){
//            System.out.println("Так делать не надо, программу надо завершить");
//        } catch (Throwable e){ // не рекомендуется
//            System.out.println("Throwable " + e.getMessage());
//            e.printStackTrace();
        } catch (Error e){
            System.out.println("Что-то пошло не так");

            System.exit(1);

        }finally {
            // например, закрытие файла, отдать ресурс
        }

    }
    //Проверяемые исключения обязательно надо ловить.
    // Есть два способа: обернуть в try-catch, или указать в сигнатуре метода throws,
    // тогда его обработает метод, который вызывает наш текущий метод
    public static int n (Integer a){
        try {
            final FileInputStream is = new FileInputStream("file.txt");
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }
        return 1;
    }
    public static int l (Integer a) throws FileNotFoundException{

            final FileInputStream is = new FileInputStream("file.txt");

        return 1;
    }

    public static int lw (Integer a) throws MyException {

        throw new MyException();

    }

    public static int wl (Integer a) {
        throw new MyUncheckedException();
    }



}
