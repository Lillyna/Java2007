package course3.homework6;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class CheckArrayTest {
    private static CheckArray checkArray;
    private static Integer[] inputArray;

    @BeforeEach
    public void init() {
        checkArray = new CheckArray();
    }

    private static Stream<Arguments> provideArgs() {
        return Stream.of(
                Arguments.of(new Integer[]{1, 2, 3, 4, 5, 6, 7, 4, 1, 2}), //have 1 & 4 several times
                Arguments.of(new Integer[]{0, 2, 3, 4, 5, 6}),             // only 4 once
                Arguments.of(new Integer[]{-8, 2, 3, 1, 5, 6}),            //only 1 once
                Arguments.of(new Integer[]{1, 1, 1, 1, 1, 1})              //only 1 all in array

        );
    }


    @ParameterizedTest
    @MethodSource("provideArgs")
    public void testSubArray(Integer[] inputArray) {
        Assertions.assertTrue(checkArray.checkArray(inputArray));
    }
}
