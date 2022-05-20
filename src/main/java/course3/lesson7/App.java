package course3.lesson7;

import java.io.Serializable;
import java.lang.reflect.*;
import java.time.LocalDate;

public class App {
    public static void main(String[] args) {
        Employee.builder()
                .name("Ivan")
                .age(4)
                .birthdate(LocalDate.of(2000,1,11))
                .build();





        Class<String> stringClass = String.class;
        System.out.println("stringClass.getName() = " + stringClass.getName());
        System.out.println("stringClass.getSimpleName() = " + stringClass.getSimpleName());
        System.out.println("stringClass.getCanonicalName() = " + stringClass.getCanonicalName());

        int[] ints = {1,2,3};
        Class<? extends int[]> aClass2 = ints.getClass();
        System.out.println("aClass2.getName() = " + aClass2.getName());
        System.out.println("aClass2.getSimpleName() = " + aClass2.getSimpleName());
        System.out.println("aClass2.getCanonicalName() = " + aClass2.getCanonicalName());

        int[][] ints1 = {{1},{2},{3}};
        Class<? extends int[][]> aClass3 = ints1.getClass();
        System.out.println("aClass3.getName() = " + aClass3.getName());
        System.out.println("aClass3.getSimpleName() = " + aClass3.getSimpleName());
        System.out.println("aClass3.getCanonicalName() = " + aClass3.getCanonicalName());
        /////////////////////////////////////////
        String abc = "abc";
        Class<? extends String> aClass = abc.getClass();
        /////////////////////////////////////////
        try {
            Class<?> aClass1 = Class.forName("java.lang.String");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        /////////////////////////////////////////
        final Class<Dog> dogClass = Dog.class;
//        showModifiers(dogClass);
//        showAcsendors(dogClass);
//        Dog dog = new Dog("Tuzik", "White", 3);
//        showFieldsInfo(dog);
//        showMethodsInfo(dog);
        showConstructorInfo(dogClass);

    }

    private static void showConstructorInfo(Class<?> clazz) {
        Constructor<?>[] constructors = clazz.getConstructors();
        for (Constructor<?> constructor : constructors) {
            printModifiers(constructor.getModifiers());
            constructor.getName();
            for (Parameter parameter : constructor.getParameters()) {
                printModifiers(parameter.getModifiers());
                System.out.print(parameter.getType().getName() + " ");
                System.out.print(parameter.getName()+" ");

            }
        }
        try {
            Constructor<?> constructor = clazz.getConstructor(String.class, String.class, int.class);
            Dog o = (Dog) constructor.newInstance("Bob", "Black", 3);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

    }


    private static void showMethodsInfo(Dog dog) {
        Class<? extends Dog> clazz = dog.getClass();
        Method[] methods = clazz.getDeclaredMethods();
        for (Method field : methods) {
            printModifiers(field.getModifiers());
            System.out.print(field.getName()+ " ");
            System.out.print(field.getReturnType().getName());
            System.out.print("(");
            for (Parameter parameter : field.getParameters()) {
                printModifiers(parameter.getModifiers());
                System.out.print(parameter.getType().getName() + " ");
                System.out.print(parameter.getName()+ ",");
            }
            System.out.print(")");
        }

        try {
            Method voices = clazz.getDeclaredMethod("voice", String.class, Integer.class);
            voices.setAccessible(true);
            System.out.println(voices.invoke(dog, "a", 1));
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    private static void showFieldsInfo(Dog dog) {
        Class<? extends Dog> clazz = dog.getClass();
        Field[] fields = clazz.getFields(); // только публичные поля
        for (Field field : fields) {
            printModifiers(field.getModifiers());
            System.out.print(field.getName()+ " ");
            System.out.print(field.getType().getName());
        }
        Field[] fields1 = clazz.getDeclaredFields(); // все поля
        for (Field field : fields1) {
            printModifiers(field.getModifiers());
            System.out.print(field.getName() + " ");
            System.out.print(field.getType().getName());
        }
        System.out.println(dog);
        try {
            Field owner = clazz.getDeclaredField("name");
            owner.setAccessible(true);
            owner.set(dog, "Petr Petrov");
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        System.out.println(dog);

    }

    private static void showAcsendors(Class<?> clazz) {
        Class<?> superclass = clazz.getSuperclass();
        System.out.println("superclass.getName()" + superclass.getName());
        Class<?>[] interfaces = clazz.getInterfaces();
        for(Class i: interfaces){
            System.out.println(i);
        }
    }

    private static void showModifiers(Class<?> clazz) {
        int modifiers = clazz.getModifiers();
        printModifiers(modifiers) ;

        System.out.println(" " + clazz.getName());


    }

    private static void printModifiers(int modifiers) { ///получить модификаторы класса
        System.out.println(
                (Modifier.isInterface(modifiers) ? "interface " : "Class ") +
                        (Modifier.isAbstract(modifiers) ? "abstract " : "") +
                        (Modifier.isPrivate(modifiers) ? "private " : "") +
                        (Modifier.isProtected(modifiers) ? "protected " : "") +
                        (Modifier.isFinal(modifiers) ? "final " : "") +
                        (Modifier.isVolatile(modifiers) ? "volatile " : "") +
                        (Modifier.isSynchronized(modifiers) ? "synch " : "") +
                        (Modifier.isNative(modifiers) ? "native " : "") +
                        (Modifier.isStatic(modifiers) ? "static " : "") );


    }

    static class Animal {

    }
    final class Dog extends Animal implements Serializable, Cloneable {
        private String name;
        private transient volatile String color;
        protected int age;
        public String owner = "Ivan Ivanov";

        public Dog(String name, String color, int age) {
            this.name = name;
            this.color = color;
            this.age = age;
        }
        private Integer voice(String a, Integer b){
            System.out.println("Гав!");
            return null;
        }

        @Override
        public String toString() {
            return "Dog{" +
                    "name='" + name + '\'' +
                    ", color='" + color + '\'' +
                    ", age=" + age +
                    ", owner='" + owner + '\'' +
                    '}';
        }
    }


}

