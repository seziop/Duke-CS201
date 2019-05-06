import java.util.ArrayList;
import java.util.Arrays;

public class SortedLeaves {
    ArrayList<Character> myList = new ArrayList<>();
    public String[] values(TreeNode tree) {
        doWork(tree);
        String[] ret = new String[myList.size()];
        for (int k = 0; k < myList.size(); k++) {
            ret[k] = "" + myList.get(k);
        }
        Arrays.sort(ret);
        return ret;
    }

    public void doWork (TreeNode t){
        if (t == null) return;
        if (t.left == null && t.right == null){
            myList.add((char) t.info);
        }
        doWork(t.left);
        doWork(t.right);
    }
}