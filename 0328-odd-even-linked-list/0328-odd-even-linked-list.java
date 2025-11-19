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
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null)   return head;

        ListNode next = new ListNode(-1);
        ListNode curr = head, prev = head, temp = next;

        while(curr!=null && curr.next!=null){
            if(curr.next!=null){
                next.next = curr.next;
                next = next.next;
                curr.next = curr.next.next;
                next.next = null;
            }
            prev = curr;
            curr = curr.next;
        }

        if(curr!=null)  curr.next = temp.next;
        else   prev.next = temp.next;

        return head;

    }
}