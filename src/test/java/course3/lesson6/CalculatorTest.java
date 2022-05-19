package course3.lesson6;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.regex.Matcher;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {
    private Calculator calculator;

    @BeforeAll
    public static void before(){
        //один раз перед стартом всех тестов
    }

    @BeforeEach
    // перед каждым тестом
    public void init(){
        calculator = new Calculator();
    }
    @Test
    public void testCommutative(){
        int res1 = calculator.add(1,2);
        int res2 = calculator.add(2,1);
        assertThat(res1, Matchers.equalTo(3));
        assertThat(res1, lessThan(4));
        assertThat(res1, allOf(equalTo(3), lessThan(5), greaterThan(6)));
        assertThat(res1, anyOf(lessThan(3), greaterThan(5)));
        assertTrue(res1 == res2);
    }
    @Test
    public void testAddForPositiveNumbers(){
        int result = calculator.add(1,1);
        assertEquals(2, result);
    }
    @Test
    public void testAddPosAndNegativeNumbers(){
        int result = calculator.add(-1,1);
        assertEquals(0,result);
    }
    @Test
    public void testAddBigNumbers(){
        assertThrows(RuntimeException.class, () -> calculator.add(Integer.MAX_VALUE-2, 3));

    }

}