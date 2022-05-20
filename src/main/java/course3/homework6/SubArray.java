package course3.homework6;

import java.util.Arrays;
import java.util.List;

public class SubArray {

    public Integer[] getSubArray(Integer[] inputArray){
        List<Integer> inArr = Arrays.asList(inputArray);
        if(!inArr.contains(4)){
            throw new RuntimeException("Входной массив должен содержать значение 4");
        }
        int index = inArr.lastIndexOf(4);
        return Arrays.copyOfRange(inputArray, index+1, inputArray.length);
    }
}
