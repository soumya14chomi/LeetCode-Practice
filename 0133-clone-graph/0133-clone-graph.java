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
    public Node cloneGraph(Node node) {
        return clone(node, new HashMap<>()); 
    }
    
    private Node clone(final Node node, final Map<Integer, Node> nodeMap) {
        if (node == null) {
            return null;
        }
        if (nodeMap.containsKey(node.val)) {
            return nodeMap.get(node.val);
        }
        final var cloned = new Node(node.val);
        nodeMap.put(node.val, cloned);
        for (final var n : node.neighbors) {
            cloned.neighbors.add(clone(n, nodeMap));
        }
        return cloned;
    }
}