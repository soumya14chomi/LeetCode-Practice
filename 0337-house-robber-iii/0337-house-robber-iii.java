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

    HashMap<TreeNode, Integer> hm = new HashMap<>();
    public int rob(TreeNode root) {
        if(root == null) return 0;

        if(hm.containsKey(root))    return hm.get(root);

        int val = root.val;

        int left = rob(root.left);
        int right = rob(root.right);

        int leftChild = root.left !=null? rob(root.left.left)+rob(root.left.right) : 0;

        int rightChild = root.right != null? rob(root.right.left)+rob(root.right.right) : 0;

        int ans = Math.max(left+right, val+leftChild+rightChild);

        hm.put(root, ans);

        return ans;
    }

    
}