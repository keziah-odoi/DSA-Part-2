package leetcode.easy;

public class MinimumDepthBinaryTree {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


    public  int findMinimumDepth(TreeNode root) {
     return inOrder(root, 0, 0);

    }

    public int inOrder(TreeNode root, int left, int right) {
        if (root == null) return 0;

        left = inOrder(root.left, left, 0);
        right = inOrder(root.right, 0, right);

        return Math.min(left, right)+1;
    }
}
