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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root == null)    return new ArrayList<>();
        List<List<Integer>> res = new LinkedList<>();
        Queue<TreeNode> qu = new LinkedList<>();
        qu.add(root);
        boolean reverse = false;
        while(!qu.isEmpty()){
            int size = qu.size();
            List<Integer> temp = new LinkedList<>();
            for(int i=0; i<size; i++){
                TreeNode node = qu.poll();
                if(!reverse)    temp.add(node.val);
                if(reverse) temp.add(0, node.val);
                if(node.left!=null) qu.add(node.left);
                if(node.right!=null)    qu.add(node.right);
            }

            res.add(temp);
            reverse = !reverse;
        } 
        return res;
    }
}