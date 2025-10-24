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

        Node root = head;
        while(head!=null){
            Node newHead = new Node(head.val);
            newHead.next = head.next;
            head.next = newHead;
            head = newHead.next;
        }

        head = root;
        while(head!=null){

            if(head.random == null) head.next.random = null;
            else
                head.next.random = head.random.next;
            head = head.next.next;
        }

        head = root;
        Node root1= root.next;
        Node head1 = root.next;
        while(head!=null){
            Node next = head.next.next;
            if(head1.next!=null)    
                head1.next = head1.next.next;

            head.next = next;
            head1 = head1.next;
            head = next;
        }
        // head = root.next;
        // while(head!=null){
        //     System.out.print(head.val+" ->" );
        //     head = head.next;
        // }

        return root1;

        
    }
}