/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {

        if(head == null || head.next == null)   return;
        ListNode fast = head.next, slow = head;

        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode head2 = slow.next;
        slow.next = null;

        // System.out.println(slow.val+" "+head2.val);

         head2 = reverse(head2);
        while(head!=null && head2!=null){
            ListNode temp = head2.next;
            head2.next = head.next;
            head.next = head2;
            head = head2.next;
            head2 = temp;
            // System.out.println(temp.val+ " "+head.next.val);

        }
        

    }

    ListNode reverse(ListNode node){

            ListNode next = node.next;
            node.next = null;

            while(node!=null && next!=null){
                ListNode temp = next.next;
                next.next = node;
                node = next;
                next = temp;
                
            }

            return node;

        }
}