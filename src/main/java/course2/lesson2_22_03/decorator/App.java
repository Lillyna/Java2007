package course2.lesson2_22_03.decorator;

public class App {
    public static void main(String[] args) {
        final ConsolePrinter printer = new ConsolePrinter();
        final BorderPrinter borderPrinter = new BorderPrinter(printer);
        final PerfCheck perf = new PerfCheck(printer);
        borderPrinter.print("Hello");
        perf.print("Hello");
    }
}
