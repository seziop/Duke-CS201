import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;

public class UniqueTreeValues {
    public int[] unique(TreeNode root) {
        HashSet<Integer> h = new HashSet<>();
        allVals(root,h);
        int[] array = new int[h.size()];
        int k = 0;
        for (int i : h){
            array[k] = i;
            k++;
        }
        Arrays.sort(array);
        return array;

    }

    public void allVals(TreeNode root, HashSet<Integer> h) {
        if (root == null) return;
        else{
            h.add(root.info);
            allVals(root.right,h);
            allVals(root.left,h);
        }
        return;
    }


}