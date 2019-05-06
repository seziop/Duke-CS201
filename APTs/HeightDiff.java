public class HeightDiff {
    public int maxhd(TreeNode root) {
        if(root == null) return 0;
        return Math.max(Math.max(maxhd(root.left),maxhd(root.right)),heightDiff(height(root.left),height(root.right)));
    }

    public int height(TreeNode root){
        if (root == null) return 0;
        return 1 + Math.max(
                height(root.left),
                height(root.right));
    }

    public int heightDiff(int a, int b){
        return Math.abs(a-b);
    }

}