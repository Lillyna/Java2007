package course3.homework6;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class SubArrayTest {
    private static SubArray subArray;
    private static Integer[] inputArray;

    @BeforeEach
    public void init() {
        subArray = new SubArray();
    }

    private static Stream<Arguments> provideArgs() {
        return Stream.of(
                Arguments.of(new Integer[]{1, 2, 3, 4, 5, 6, 7, 4, 1, 2}, new Integer[]{1, 2}),
                Arguments.of(new Integer[]{1, 2, 3, 4, -5, 6}, new Integer[]{5, 6}),
                Arguments.of(new Integer[]{4, 2, 3, 1, 5, 6}, new Integer[]{2, 3, 1, 5, 6}),
                Arguments.of(new Integer[]{1, 2, 3, 4, 0, 4}, new Integer[]{})
        );
    }

    @Test
    public void testEmptyInput() {
        inputArray = new Integer[]{};
        assertThrows(RuntimeException.class, () -> subArray.getSubArray(inputArray));
    }

    @Test
    public void testNullInput() {
        inputArray = new Integer[]{null, null, null, null};
        assertThrows(RuntimeException.class, () -> subArray.getSubArray(inputArray));
    }

    @Test
    public void testNoFour() {
        inputArray = new Integer[]{1, 2, 3, 5, 6, 7, 1, 2};
        assertThrows(RuntimeException.class, () -> subArray.getSubArray(inputArray));
    }

    @ParameterizedTest
    @MethodSource("provideArgs")
    public void testSubArray(Integer[] inputArray, Integer[] outputArray) {
        Assertions.assertArrayEquals(outputArray, subArray.getSubArray(inputArray));
    }
}
