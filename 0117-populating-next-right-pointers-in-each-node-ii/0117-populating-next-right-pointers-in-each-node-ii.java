/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    void findRight(Node root, int depth, List<Node> depths){
        if(root == null)    return;
        if(depths.size() <=depth)   depths.add(root);
        else{
            Node temp = depths.get(depth);
            temp.next = root;
            depths.set(depth, root);
            // System.out.println(temp.val+" "+temp.right.val);
        }
       
        // for(int i=0;i<depths.size();i++){
        //     System.out.print(depths.get(i).val+" ");
        // } 
        // System.out.println(" -> root:"+ root.val);
        
        findRight(root.left, depth+1, depths);
        findRight(root.right, depth+1, depths);
    }

    public Node connect(Node root) {
        List<Node> depths = new ArrayList<>();
        findRight(root, 0, depths);
        return root;
        
    }
}