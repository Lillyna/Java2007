package course3.lesson3.stream;

import java.io.*;
import java.util.Arrays;
import java.util.Locale;

public class Ser {
    //превращение объектов в потоки байт = сериализация
    //Serializable = маркерный интерфейс (без методов)


    public static void main(String[] args) {
        Ser ss = new Ser();
        ss.extracted();
    }
    private void extracted (){

        byte[] byteCat = null;
        try(ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream)){

            Cat cat = new Cat("Барсик", 5, 19.0);
            objectOutputStream.writeObject(cat);
            byteCat = byteArrayOutputStream.toByteArray();
            System.out.println(cat);
            System.out.println(Arrays.toString(byteCat));

        } catch (IOException e) {
            e.printStackTrace();
        }
        try(ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteCat);
            ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream)){
            Cat o = (Cat) objectInputStream.readObject();
            System.out.println(o);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
class Cat implements Serializable{
    private static final long serialVersionId = 1L;
    private String name;
    private int age;
    private double weight;

    public Cat(String name, int age, double weight) {
        this.name = name;
        this.age = age;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", weight=" + weight +
                '}';
    }
}

/**
 * Кастомная сериализация с помощью Externalizable
 */
class Dog implements Externalizable{

    private String name;

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject("name: " + name.toUpperCase());

    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {

    }
}