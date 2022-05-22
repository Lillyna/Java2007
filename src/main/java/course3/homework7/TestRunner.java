package course3.homework7;

import org.testng.annotations.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.TreeMap;

public class TestRunner {
    public static void start(Class clazz) {
        Object instance;
        try {
            instance = clazz.getDeclaredConstructor().newInstance();
            Method[] methods = clazz.getMethods();
            ArrayList<Method> beforeSuite = new ArrayList<>();
            ArrayList<Method> afterSuite = new ArrayList<>();
            TreeMap<Integer, ArrayList<Method>> tests = new TreeMap<>();
            for (Method method : methods) {

                if (method.isAnnotationPresent(BeforeSuite.class)) {
                    beforeSuite.add(method);
                } else if (method.isAnnotationPresent(AfterSuite.class)) {
                    afterSuite.add(method);
                } else if (method.isAnnotationPresent(Test.class)) {
                    int priority = 0;
                    if (method.isAnnotationPresent(Priority.class)) {
                        Priority annotation = method.getAnnotation(Priority.class);
                        priority = annotation.priority();
                    }
                    if (tests.get(priority) != null) {
                        tests.get(priority).add(method);
                    } else {
                        ArrayList<Method> meth = new ArrayList<>();
                        meth.add(method);
                        tests.put(priority, meth);
                    }

                }
            }

            if (beforeSuite.size() > 1 || afterSuite.size() > 1) {
                throw new RuntimeException("Methods BeforeSuite and AfterSuite must occur onle once in a class!");
            }

            //Run beforeSuite
            beforeSuite.get(0).invoke(instance);

            //Run tests
            for (Integer i : tests.keySet()) {
                ArrayList<Method> j = tests.get(i);
                for (Method method : j) {
                    method.invoke(instance);
                }
            }
            //Run afterSuite
            afterSuite.get(0).invoke(instance);

        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }


    }

    public static void main(String[] args) {
        start(TestClass.class);
    }
}
