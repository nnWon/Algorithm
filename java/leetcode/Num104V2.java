package leetcode;

public class Num104V2 {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        TreeNode curNode = root;
        int leftDepth = maxDepth(curNode.left);
        int rightDepth = maxDepth(curNode.right);

        return Math.max(leftDepth, rightDepth) + 1;
    }
}
