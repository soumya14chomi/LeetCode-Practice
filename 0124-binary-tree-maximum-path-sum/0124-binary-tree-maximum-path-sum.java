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
    int res = Integer.MIN_VALUE;

    int helper(TreeNode root){
        if(root == null)    return 0;
        int sum = root.val;
        int leftSum = helper(root.left);
        int rightSum = helper(root.right);
        if(leftSum>0)   sum+=leftSum;
        if(rightSum>0)  sum+=rightSum;
        res = Math.max(sum, res);

        // System.out.println(sum)

        return Math.max(root.val, Math.max(root.val+leftSum, root.val+rightSum));
    }

    public int maxPathSum(TreeNode root) {
        helper(root);
        return res;
    }
}