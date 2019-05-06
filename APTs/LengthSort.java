import java.util.Arrays;
import java.util.Comparator;

public class LengthSort {
    public String[] rearrange(String[] values){
        // you write code here and replace statement below

        Comparator<String> comp = Comparator.comparing(String::length);
        comp = comp.thenComparing(String::toString);
        Arrays.sort(values,comp);

        return values;
    }
}

/**
values = ["ant", "batter", "catapult", "dog"]

        Returns ["ant", "dog", "batter", "catapult"]
        Note that "ant" and "dog" both contain 3 characters, and are sorted in alphabetical order relative to each other.
 **/