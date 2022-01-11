package course2.homework2;

public class MyArrayDataException extends Exception{
    public MyArrayDataException(int x, int y) {
        super("Некорректный символ в ячейке ("+(x+1)+","+(y+1)+")!");
    }
}
