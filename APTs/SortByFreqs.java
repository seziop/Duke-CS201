import java.util.*;

public class SortByFreqs {
    public String[] sort(String[] data) {
        Map<String, Integer> map = new HashMap<>();
        for (String s : data) {
            if (map.containsKey(s)) {
                map.put(s, map.get(s) + 1);
            } else {
                map.put(s, 1);
            }
        }

        ArrayList<String> list = new ArrayList<>(map.keySet());
        Comparator<String> comp = Comparator.comparingInt(s -> map.get(s));
        comp = comp.reversed().thenComparing(String::toString);
        Collections.sort(list,comp);

        return list.toArray(new String[0]);
    }
}