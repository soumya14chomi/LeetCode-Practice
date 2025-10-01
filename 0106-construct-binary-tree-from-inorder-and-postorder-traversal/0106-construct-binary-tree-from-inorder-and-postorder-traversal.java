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
    int idx = 0;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer, Integer> hm = new HashMap<>();

        for(int i=0; i<inorder.length; i++){
            hm.put(inorder[i], i);
        }

        idx = postorder.length-1;

        return build(hm, postorder, 0, postorder.length-1);
    }

    TreeNode build(HashMap<Integer, Integer> hm, int[] arr, int st, int end){
        if(st > end)    return null;

        // System.out.println(st+" "+end+" "+idx);

        TreeNode root = new TreeNode(arr[idx]);
        int mid = hm.get(arr[idx]);
        idx--;

        root.right = build(hm, arr, mid+1, end);
        root.left = build(hm, arr, st, mid-1);

        return root;

    }
}