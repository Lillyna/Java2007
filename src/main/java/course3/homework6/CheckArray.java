package course3.homework6;

import java.util.Arrays;
import java.util.List;

public class CheckArray {
    public boolean checkArray(Integer[] inputArray){
        List<Integer> inArr = Arrays.asList(inputArray);
        return inArr.contains(4) || inArr.contains(1);
    }
}
