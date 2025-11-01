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
    public ListNode modifiedList(int[] nums, ListNode head) {
        HashSet<Integer> hs = new HashSet<>();
        
        for(int i=0; i<nums.length;i++) hs.add(nums[i]);

    ListNode dummy = new ListNode(-1);

    dummy.next = head;
    head = dummy;

    

    while(dummy.next!=null){
        // System.out.println(dummy.val);
        ListNode next = dummy.next;
        if(hs.contains(next.val))  {
            dummy.next = dummy.next.next;
        } 
        else dummy = dummy.next;
    }

    return head.next;


        
    }
}