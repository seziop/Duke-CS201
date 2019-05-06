public class TreeTighten {
    public TreeNode tighten(TreeNode t) {
        if (t == null) return null;
        if (t.left == null && t.right != null) return tighten(t.right);
        if (t.right == null && t.left != null) return tighten(t.left);
        if (t.right != null && t.left != null){
            t.right = tighten(t.right);
            t.left = tighten(t.left);
        }
        return t;
    }
}