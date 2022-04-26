package course3.lesson3.stream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class FileStream {
    public static void main(String[] args) {
        try (FileOutputStream outputStream = new FileOutputStream("myfile.txt")) {
            byte[] bytes = "Java".getBytes();
            for(byte b : bytes){
                outputStream.write(bytes);
            }
            outputStream.write(bytes);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        byte[] buf = new byte[10];
        try(FileInputStream in = new FileInputStream("myfile.txt")) {

            while(in.read(buf)>0){
                System.out.println(Arrays.toString(buf));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
