package course3.homework6;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
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
    private static Stream<Arguments> providePositiveTestingArgs(){
        return Stream.of(
                Arguments.of((Object) new Integer[]{1, 2, 3, 4, 5, 6, 7, 4, 1, 2}), //have 1s & 4s
                Arguments.of((Object) new Integer[]{0, 2, 3, 4, 5, 6}), // have only 4 once
                Arguments.of((Object) new Integer[]{-8, 2, 3, 1, 5, 6}), // have only 1 once
                Arguments.of((Object) new Integer[]{1, 1, 1, 1, 1, 1}) //have 1s for every element
        );
    }
    private static Stream<Arguments> provideNegativeTestingArgs(){
        return Stream.of(
                Arguments.of((Object) new Integer[]{9, 2, 3, 6, 5, 6, 7, 7, 3, 2}), //no 4s nor 1s
                Arguments.of((Object) new Integer[]{}) // empty array
        );
    }

    @ParameterizedTest
    @MethodSource("providePositiveTestingArgs")
    public void testPosSubArray(Integer[] inputArray) {
        Assertions.assertTrue(checkArray.checkArray(inputArray));
    }

    @ParameterizedTest
    @MethodSource("provideNegativeTestingArgs")
    public void testNegSubArray(Integer[] inputArray) {
        Assertions.assertFalse(checkArray.checkArray(inputArray));
    }
}
