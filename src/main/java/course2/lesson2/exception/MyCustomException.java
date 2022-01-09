package course2.lesson2.exception;

public class MyCustomException extends Exception { //если проверяемое - наследовать от Exception, непроверяемое - от RuntimeException

    public MyCustomException(int a) {
        super("Не умею делить на " + a);
    }
}
