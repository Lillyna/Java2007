package course2.lesson2.exception;

public class ExceptionsApp {
    public static void main(String[] args) {
        try {
            int a = 10;
            int b = 2;
            System.out.println("a= "+ a + " b=" + b + ", a/b= " + div(a,b));
            b=0;
            System.out.println("a= "+ a + " b=" + b + ", a/b= " + div(a,b));
        } catch (ArithmeticException ae) {// или catch(Exception ae)
            System.out.println("Поймал исключение");
            ae.printStackTrace(System.out);
        }
        System.out.println();

        //open file
        try {
            System.out.println(divFirstAndSecond(args));
        } catch (ArithmeticException | ArrayIndexOutOfBoundsException ex) {
            System.out.println("Попытались поделить на 0 или массив не той длины");
        } catch (Exception e){
            System.out.println("Что-то другое "+ e.getMessage());
        } finally {
            //close file - в любом случае будет выполнено
            System.out.println("Будет выполнено всегда");
        }
    }

    static int div(int a, int b){
        return div2(a,b);
    }

    static int div2(int a, int b){
        return a/b;
    }

    /**
     * Передали массив, вернем результат деления первого элемента на второй
     * Мы не умеем делить на 10
     * @param array
     * @return
     */
    static int divFirstAndSecond(String[] array) throws MyCustomException{

        int a = Integer.parseInt(array[0]);
        int b = Integer.parseInt(array[1]);
        if (b==10){
            throw new MyCustomException(10);
        }
        return a/b;
    }
}
