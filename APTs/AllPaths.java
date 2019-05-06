import java.util.ArrayList;
import java.util.Collections;

public class AllPaths {
    ArrayList<String> list = new ArrayList<>();
        public String[] paths(TreeNode t) {
            if (t == null) return new String[0];
            findPaths(t, "");
            Collections.sort(list);
            return list.toArray(new String[0]);
        }
        private void findPaths(TreeNode t,String path){
            if (t== null) return;
            if (t.left == null && t.right == null){
                path = path + t.info;
                list.add(path);
                return;
            }
            path = path + t.info + "->";
            findPaths(t.left, path);
            findPaths(t.right, path);
        }
}