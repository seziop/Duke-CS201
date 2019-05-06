import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class TheBestName {

    public String[] sort(String[] names) {
        Comparator<String> comp = Comparator.comparing(this::weightOf);
        comp = comp.reversed().thenComparing(String::toString);
        Arrays.sort(names,comp);
        return names;
    }

    public int wc(char character){
        String check = " abcdefghijklmnopqrstuvwxyz";
        return check.indexOf(character);
    }

    public int weightOf(String name) {
        char[] nameChar = name.toLowerCase().toCharArray();
        int weight = 0;
        if (name.toLowerCase().equals("john")) return 99999999;
        for (char s : nameChar) weight += wc(s);
        return weight;
    }








}