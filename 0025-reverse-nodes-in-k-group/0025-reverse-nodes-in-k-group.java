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
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || head.next == null)    return head;
        ListNode root = new ListNode(-1);
        root.next = head;
        ListNode prev = root;
        while(head!=null){
            int n=0;
            while(n<k && head!=null){
                if(head == null)    return root.next;
                head = head.next;
                n++;
            }
            if(n<k)    return root.next;
            ListNode last = prev.next;
            prev.next = reverse(prev.next, k);
            last.next = head;
            prev = last;
        }

        return root.next;
    }

    ListNode reverse(ListNode root, int k){
        ListNode prev = null;
        ListNode curr = root;
        while (k > 0 && curr != null) {
            ListNode nxt = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nxt;
            k--;
        }
        return prev;
    }
}