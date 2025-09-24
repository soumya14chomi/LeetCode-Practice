/*
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    
    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
}
*/

class Solution {
    public Node construct(int[][] grid) {
        return helper(grid, 0, grid.length-1, 0, grid[0].length-1);
    }

    Node helper(int[][] grid, int l, int r,int t, int b ){

        if(l==r)   {
            // System.out.println(" found root at + ("+l+","+r+","+t+","+b+") -> "+grid[t][l]);
            Node root = new Node(grid[t][l] == 1, true );
            return root;
        }

        System.out.println(l+" "+r+" "+t+" "+b);

        int vMid = (l+r)/2;
        int hMid = (t+b)/2;

        Node topLeft = helper(grid, l, vMid, t, hMid);
        Node topRight = helper(grid, vMid+1, r, t, hMid);
        Node bottomLeft = helper(grid, l, vMid, hMid+1, b);
        Node bottomRight = helper(grid, vMid+1, r, hMid+1, b);

        Node root = null;
        if(topLeft.isLeaf && topRight.isLeaf && bottomLeft.isLeaf && bottomRight.isLeaf && topLeft.val==topRight.   val && topLeft.val==bottomRight.val && topLeft.val==bottomLeft.val){
                    root = new Node(topLeft.val, true); 
                }
        else{

            
            root = new Node();
            root.isLeaf = false;
            root.topLeft = topLeft;
            root.topRight = topRight;
            root.bottomLeft = bottomLeft;
            root.bottomRight = bottomRight; 
                                   
        }

        return root;

    }
}