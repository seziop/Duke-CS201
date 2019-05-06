import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class SetAside {
    public String common(String[] list) {
        HashSet<String> first = new HashSet<String>();
        for (String word : list) {
            HashSet<String> temp = new HashSet<String>();
            String[] wordlist = word.split(" ");
            for (String words : wordlist) {
                temp.add(words);
            }
            first.retainAll(temp);
        }
        String retString = "";
        if (first.size() == 0) return "";
        ArrayList<String> returnList = new ArrayList<>(first);
        Collections.sort(returnList);
        return String.join(" ", returnList);
    }
}


/*

list = ["a b c d", "b c d", "b c d e", "b c f"]

returns "b c"

Only the words "b" and "c" appear in each and every element of list

 */