import java.util.*;

public class SortedFreqs {
    public int[] freqs(String[] data) {
        Map<String, Integer> map = new HashMap<>();
        for (String s : data) {
            if (map.containsKey(s)) {
                map.put(s, map.get(s) + 1);
            } else {
                map.put(s, 1);
            }
        }

        ArrayList<String> list = new ArrayList<>(map.keySet());
        Comparator<String> comp = Comparator.comparing(String::toString);
        Collections.sort(list,comp);
        int[] ret = new int[list.size()];
        int index = 0;
        for (String s : list){
            int val = map.get(s);
            ret[index] = val;
            index ++;
        }
        return ret;
    }
}