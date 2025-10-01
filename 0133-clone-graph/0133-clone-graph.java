/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node root) {

        if(root == null)    return null;
        Queue<Node> qu = new LinkedList<>();

        HashMap<Node, Node> hm = new HashMap<>();

        Set<Node> visited = new HashSet<Node>();

        hm.put(root, new Node(root.val));
        qu.add(root);
        visited.add(root);

        while(!qu.isEmpty()){
            Node node = qu.poll();
            for(Node neighbor : node.neighbors){
                if(!hm.containsKey(neighbor))   hm.put(neighbor, new Node(neighbor.val));
                hm.get(node).neighbors.add(hm.get(neighbor));

                if(!visited.contains(neighbor)){
                    qu.add(neighbor);
                    visited.add(neighbor);
                }
            }
        }

        return hm.get(root);
    }
}