package course2.lesson2_22_03.decorator;

public class PerfCheck implements Printer {
    private Printer printer;

    public PerfCheck(Printer printer) {
        this.printer = printer;
    }

    @Override
    public void print(String text) {
        final long start= System.currentTimeMillis();
        printer.print(text);
        final long end= System.currentTimeMillis();
        System.out.println(end - start);

    }
}
