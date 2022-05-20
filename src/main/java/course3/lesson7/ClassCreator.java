package course3.lesson7;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class ClassCreator {

    public<T> T fileToObject(String filename, Class<T> clazz) {
        T instance;
        try {
            instance = clazz.getDeclaredConstructor().newInstance();
            try(BufferedReader bufferedReader = new BufferedReader(new FileReader(filename))) {
                String line;
                while ((line = bufferedReader.readLine()) != null) {

                    String[] split = line.split(":");
                    String fieldName = split[0];
                    String fieldValue = split[1];
                    Method[] methods = clazz.getMethods();
                    for (Method method : methods) {
                        if(method.isAnnotationPresent(MyAnnot.class)) {
                            MyAnnot annotation = method.getAnnotation(MyAnnot.class);
                            String name = annotation.name();
                            System.out.println(name);
                        }
                        String value = "";
                        if(method.isAnnotationPresent(FileFieldName.class)) {
                            FileFieldName annotation = method.getAnnotation(FileFieldName.class);
                            value = annotation.value();
                        }
                        if (fieldName.equals(value) || method.getName().equalsIgnoreCase("set"+fieldName)){
                            Parameter parameter = method.getParameters()[0];
                            Class<?> type = parameter.getType();
                            if(type.equals(int.class)){
                                method.invoke(instance, Integer.parseInt(fieldValue));
                            } else {
                                method.invoke(instance, fieldValue);
                            }
                        }
                    }
                }
                System.out.println(instance);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
           throw new RuntimeException("Err");
        }
        return instance;
    }
    public static void main(String[] args) {
        ClassCreator classCreator = new ClassCreator();
        Book book1 = classCreator.fileToObject("book1.txt", Book.class);
        Car car = classCreator.fileToObject("car.txt", Car.class);

    }

}
