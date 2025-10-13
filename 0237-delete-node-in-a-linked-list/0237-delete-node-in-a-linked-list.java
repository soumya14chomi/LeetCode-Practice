/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        ListNode curr = node, next = node.next;

        ListNode prev = null;

        while(next!=null){
            curr.val = next.val;
            prev = curr;
            curr = next;
            next = next.next;
        }

        prev.next = null;
    }
}