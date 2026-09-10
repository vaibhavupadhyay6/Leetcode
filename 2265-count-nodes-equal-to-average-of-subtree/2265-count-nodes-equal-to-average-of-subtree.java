/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    int ans = 0;

    public int averageOfSubtree(TreeNode root) {
        dfs(root);
        return ans;
    }

    int[] dfs(TreeNode root) {

        // Base case
        if (root == null) {
            return new int[]{0, 0};
        }

        // Left subtree
        int[] left = dfs(root.left);

        // Right subtree
        int[] right = dfs(root.right);

        // Current subtree
        int sum = root.val + left[0] + right[0];
        int count = 1 + left[1] + right[1];

        // Check average
        if (sum / count == root.val) {
            ans++;
        }

        return new int[]{sum, count};
    }
}