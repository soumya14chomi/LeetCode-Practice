class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k <= 1) return head;

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prevGroupEnd = dummy;

        while (true) {
            // Check there are k nodes remaining
            ListNode node = prevGroupEnd;
            for (int i = 0; i < k && node != null; i++) node = node.next;
            if (node == null) break; // fewer than k nodes, stop

            // Reverse k nodes
            ListNode groupStart = prevGroupEnd.next;
            ListNode curr = groupStart;
            ListNode next = null;
            ListNode prev = null;
            int count = 0;
            while (count < k && curr != null) {
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
                count++;
            }

            // prev is new head of reversed group; curr is first node after group
            prevGroupEnd.next = prev;
            groupStart.next = curr; // groupStart is now the tail of reversed group
            prevGroupEnd = groupStart;
        }

        return dummy.next;
    }
}
