/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null)    return null;

        if(p.val > q.val){
            TreeNode temp = p;
            p = q;
            q  = temp;
        }
        if(p.val<= root.val && q.val >= root.val) return root;

        TreeNode l =lowestCommonAncestor(root.left, p, q);
        TreeNode r = lowestCommonAncestor(root.right, p, q);
        
        if(l!=null && r!=null)  return root;

        if(l==null && r ==null) return null;

        if(l==null)    return  r;

        return l;    

    }
}