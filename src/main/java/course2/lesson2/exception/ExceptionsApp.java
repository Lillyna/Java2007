package course2.lesson2.exception;

public class ExceptionsApp {
    public static void main(String[] args) {
        try{
            int a = 10;
            int b = 2;
            System.out.println("a/b="+ div2(a,b));
            b=1;
            System.out.println("a/b="+ div2(a,b));
        } catch (Exception ae){
            System.out.println("Поймал ошибку");
            ae.printStackTrace(System.out);
        }

        try{
            divFirstAndSecond(args);
        } catch(ArithmeticException | ArrayIndexOutOfBoundsException ae){
            System.out.println("Попытались поделить на 0");
        } catch(Exception ex){
            System.out.println("Что-то другое" + ex.getMessage());
        } finally {
            System.out.println("Будет выполнена всегда");
        }

    }

    static int div (int a, int b){
        return a/b;
    }
    static int div2 (int a, int b){
        return div(a,b);
    }

    /**
     * Передали массив, вернем результат деления первого на второй
     * Не умеем делить на 10
     * @param array
     * @return
     */
    static int divFirstAndSecond(String[] array) throws Exception {
        int a = Integer.parseInt(array[0]);
        int b = Integer.parseInt(array[1]);
        System.out.println(div(Integer.parseInt(array[0]),Integer.parseInt(array[1])));
        if (a/b == 10){
            throw new MyCustomException(a/b);
        }
        return a/b;

    }
}
