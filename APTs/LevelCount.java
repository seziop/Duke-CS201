public class LevelCount {
    public int count(TreeNode t, int level) {
        int sumCount = 0;

        if (t == null) return sumCount;

        if (level == 0) sumCount++;

        if (level == 1) {
            if (t.right != null) sumCount++;
            if (t.left != null) sumCount++;
        }

        if (level > 1){
            return count(t.left, level-1) + count(t.right, level-1);
        }
        return sumCount ;
    }
}