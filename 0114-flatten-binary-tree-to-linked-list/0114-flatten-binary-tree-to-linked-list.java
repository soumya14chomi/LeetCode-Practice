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
    public void flatten(TreeNode root) {
        
            TreeNode head = root;

            while(head!=null){
                while(head.left!=null){
                    TreeNode temp = head.left;

                    while(temp.right!=null){
                        temp = temp.right;
                    }

                    temp.right = head.right;
                    head.right = head.left;
                    head.left = null;

                    
                }
                head = head.right;

            }
    }
}