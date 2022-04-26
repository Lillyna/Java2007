package course3.lesson3.stream;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Buff {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        StringBuilder stringBuilder = new StringBuilder();
//        try(FileInputStream fileInputStream = new FileInputStream("123.txt")){
//            int x;
//            do{
//                x = fileInputStream.read();
//                stringBuilder.append((char)x);
//            } while (x!=-1);
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        System.out.println(System.currentTimeMillis() - start);
//

//    start = System.currentTimeMillis();
//    stringBuilder = new StringBuilder();
        try(BufferedInputStream fileInputStream = new BufferedInputStream(new FileInputStream("123.txt"))){
        int x;
        do{
            x = fileInputStream.read();
            stringBuilder.append((char)x);
        } while (x!=-1);
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    }
        System.out.println(System.currentTimeMillis() - start);
}
}
