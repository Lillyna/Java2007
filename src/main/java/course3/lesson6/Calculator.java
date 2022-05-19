package course3.lesson6;

public class Calculator {

    public int add(int a, int b) {
        long res = (long) a + b;
        if (res != (a + b)) {
            throw new RuntimeException();
        }
        return a + b;
    }
}
