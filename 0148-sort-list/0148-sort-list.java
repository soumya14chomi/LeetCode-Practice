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
    public ListNode sortList(ListNode head) {

        if(head == null || head.next == null)   return head;

        ListNode slow = head, fast = head, prev = null;

        while(fast!=null && fast.next!=null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        prev.next = null;

        ListNode l1 = sortList(slow);
        ListNode l2 = sortList(head);

        return merge(l1, l2);
        
    }

    ListNode merge(ListNode l1, ListNode l2){

        ListNode head = new ListNode(-1);
        ListNode dummy = head;

        while(l1!=null && l2!=null){
            if(l1.val < l2.val){
                dummy.next = l1;
                l1 = l1.next;
            }

            else{
                dummy.next = l2;
                l2 = l2.next;
            }

            dummy = dummy.next;
        }

        if(l1!=null)    dummy.next = l1;

       if(l2!=null) dummy.next = l2;
        return head.next;
    }
}