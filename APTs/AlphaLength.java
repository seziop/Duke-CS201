import java.util.Arrays;
import java.util.Comparator;

public class AlphaLength {
    public ListNode create (String[] words) {

        Comparator<String> comp = Comparator.comparing(String::toString);
        Arrays.sort(words,comp);
        words = Arrays.stream(words).distinct().toArray(String[]::new);

        ListNode ret = new ListNode(words[0].length(), null);
        ListNode toRet = ret;

        if (words.length == 0) return null;

        for (int k = 1; k < words.length; k++){
            ret.next = new ListNode(words[k].length(),null);
            ret = ret.next;
        }

        return toRet;
    }
}
