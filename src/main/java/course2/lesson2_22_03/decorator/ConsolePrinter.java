package course2.lesson2_22_03.decorator;

public class ConsolePrinter implements Printer{
    @Override
    public void print(String text){
        System.out.print(text);
    }
}
