package course3.homework7;

import org.testng.annotations.Test;

public class TestClass {

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("Running beforeSuite");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("Running afterSuite");
    }

    @Test
    @Priority(priority = 1)
    public void test1() {
        System.out.println("Running test1");
    }

    @Test
    @Priority(priority = 10)
    public void test2() {
        System.out.println("Running test2");
    }

    @Priority(priority = 5)
    @Test
    public void test3() {
        System.out.println("Running test3");
    }

    @Test
    public void test4() {
        System.out.println("Running test4");
    }

    @Test
    public void test5() {
        System.out.println("Running test5");
    }

}
