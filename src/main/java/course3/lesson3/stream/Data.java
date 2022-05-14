package course3.lesson3.stream;

import java.io.*;

public class Data {
    public static void main(String[] args) {
        try(DataOutputStream dis = new DataOutputStream(new FileOutputStream("1.txt"))){
            dis.writeInt(1);
            dis.writeBoolean(false);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try(DataInputStream dis = new DataInputStream(new FileInputStream("1.txt"))){
            System.out.println("dis.readInt() = " + dis.readInt());
            System.out.println("dis.readBoolean() = " + dis.readBoolean());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
