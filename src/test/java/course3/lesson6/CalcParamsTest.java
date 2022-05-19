package course3.lesson6;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class CalcParamsTest {
    private static Calculator calculator;

    @BeforeAll
    public static void before(){
        calculator = new Calculator();
    }
    private static Stream<Arguments> provideArgs(){
        return Stream.of(
                Arguments.of(1,1,2),
                Arguments.of(1,-1,0),
                Arguments.of(1000,2,1001),
                Arguments.of(-1,-1,-2)
                );
    }
    @ParameterizedTest
    @MethodSource("provideArgs")
    public void test(int a, int b, int expected){
        assertEquals(expected, calculator.add(a,b));
    }
    @ParameterizedTest
    @CsvFileSource(resources = "data.csv", numLinesToSkip = 1)
    public void testCsv(int a, int b, int expected){
int res = calculator.add(a,b);
        assertEquals(expected, res);
    }

}
