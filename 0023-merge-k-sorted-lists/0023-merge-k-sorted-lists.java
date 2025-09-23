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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> (a.val)-(b.val));

        int k = lists.length;

        for(int i=0;i<k;i++){
            if(lists[i]!=null)   pq.add(lists[i]);

        }

        ListNode root = new ListNode(-1);
        ListNode head = root;

        while(!pq.isEmpty()){
            ListNode temp = pq.poll();
            head.next = temp;
            if(temp.next!=null) pq.add(temp.next);
            head = head.next;
        }

        return root.next;
    }
}