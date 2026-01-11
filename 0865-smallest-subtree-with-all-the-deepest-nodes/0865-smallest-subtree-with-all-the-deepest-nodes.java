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

    TreeNode ans = null;
    int maxDepth = 0;
    
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        ans = root;
        Map<TreeNode, Integer> hm = new HashMap<>();
        calculateDist(root, hm, 0);
        return ans;
    }

    int calculateDist(TreeNode root, Map<TreeNode, Integer> hm, int dist){
        if(root == null)    return dist;

        int left = calculateDist(root.left, hm, dist+1);
        int right = calculateDist(root.right, hm, dist+1);

        if(left == right){
            if(maxDepth <= left) { 
                ans = root;
                maxDepth  = left;
            }
        }

        return Math.max(left, right);

    }



}