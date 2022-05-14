package course3.lesson3.stream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class Print {
    public static void main(String[] args) {
        try (FileOutputStream fileOutputStream = new FileOutputStream("123.txt");
             PrintStream printStream = new PrintStream(fileOutputStream)) {
            for (int i = 0; i < 100000000; i++) {
                printStream.println("Hello");
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
