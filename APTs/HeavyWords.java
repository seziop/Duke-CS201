import java.util.Collections;
import java.util.HashMap;
public class HeavyWords {
    public double average(String[] words){
        // STEP ONE: FIND THE ALPHABET
        HashMap<Character, Integer> alphabet = new HashMap<>();
        for (String sent : words) {
            char firstChar = sent.charAt(0);
            if (!alphabet.containsKey(firstChar)) {
                alphabet.put(firstChar, 1);
            } else {
                alphabet.put(firstChar, alphabet.get(firstChar) + 1);
            }
        }
        char mostChar = 'a';
        for (java.util.Map.Entry<Character, Integer> entry : alphabet.entrySet()) {
            int maxValueInMap=(Collections.max(alphabet.values())); //find max value
            if (entry.getValue()==maxValueInMap) {
                mostChar = entry.getKey();     //return key with max value
            }
        }
        // STEP TWO: FILTER EXISTING WORDS
        double retLength = 0.0;
        int counter = 0;
        for (String sent : words) {
            char firstChar = sent.charAt(0);
            if (firstChar == mostChar) {
                double thisLength = sent.length();
                retLength = retLength+thisLength;
                counter += 1;
            }
        }
        // STEP THREE: FINALIZE AVERAGE LENGTH
        retLength = retLength / (double) counter;
        return retLength;
    }
    public static void main(String[] args) {
        HeavyWords tester1 = new HeavyWords();
        String[] tent = {"z", "z", "z", "z"};
        double ans = (tester1.average(tent));
        System.out.print(ans);
    }
}