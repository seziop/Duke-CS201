import java.util.Collections;
import java.util.HashMap;

public class TentNames {
    public int popular(String[] tents) {
        HashMap<String, Integer> words = new HashMap<>();
        for (String sent : tents) {
            String[] wrds = sent.split(" ");
            for (String a : wrds) {
                String i = a.toLowerCase();
                if (!words.containsKey(i)) {
                    words.put(i, 1);
                } else {
                    words.put(i, words.get(i) + 1);
                }
            }
        }
        for (java.util.Map.Entry<String, Integer> entry : words.entrySet()) {
            return Collections.max(words.values());
        }
        return 0;
    }

    public static void main(String[] args) {
        TentNames tester1 = new TentNames();
        String[] tent = {"x y z", "a b c", "d e f g h i j"};
        int ans = (tester1.popular(tent));
        System.out.print(ans);
    }
}