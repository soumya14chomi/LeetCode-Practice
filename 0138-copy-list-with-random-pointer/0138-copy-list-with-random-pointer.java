/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {

        if(head == null)    return null;
        Node newHead = new Node(head.val);

        HashMap<Node, Node> hm = new HashMap<>();

        hm.put(head, newHead);

        Node root = head.next;
        Node prev = hm.get(head);

        while(root!=null){
            hm.put(root, new Node(root.val));
            prev.next = hm.get(root);
            prev = hm.get(root);
            root = root.next;
        }

        for(Node node: hm.keySet()){
            hm.get(node).random = hm.get(node.random);
        }

        return hm.get(head);

        
    }
}