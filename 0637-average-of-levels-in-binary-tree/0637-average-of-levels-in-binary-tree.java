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
    // private static final DecimalFormat df = new DecimalFormat("0.00000");

    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> avg = new ArrayList<>();

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            int size = q.size();
            Double sum =0.0;
            for(int i=0; i<size; i++){
                TreeNode node = q.poll();
                sum+=node.val;
                if(node.left!=null)    q.add(node.left);
                if(node.right!=null)    q.add(node.right);
            }

            avg.add(sum/size);
        }
        return avg;
    }
}