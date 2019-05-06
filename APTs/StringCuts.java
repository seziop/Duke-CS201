import java.util.*;

public class StringCuts {
    public String[] filter(String[] list, int minLength) {
        ArrayList ret = new ArrayList();
        for (String word : list){
            if ((word.length() >= minLength) && (! ret.contains(word))) {
                ret.add(word);
            }
        }
        String[] result = (String[]) ret.toArray(new String[0]);
        return result;
    }
}

/*

list = ["huge", "enormous", "big", "gigantic"]

minLength = 5

return: ["enormous", "gigantic"]

The strings "huge" and "big" aren't large enough to pass the minLength filter of 5.

 */