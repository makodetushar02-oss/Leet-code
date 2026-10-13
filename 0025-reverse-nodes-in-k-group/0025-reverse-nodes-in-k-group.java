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
        if(head == null || head.next == null || k == 1) return head;
        ListNode start = head;
        ListNode end = head;
        int i = k -1;
        while(i-- != 0){
            end = end.next;
            if(end == null) return head;
        }
        ListNode ans = reverseKGroup(end.next,k);
        revers(start,end);
        start.next = ans;
        return end;
    }
    public void revers(ListNode start, ListNode end){
        ListNode  curr = start;
        ListNode prev = null;
        while(prev != end){
        ListNode temp = curr.next;
        curr.next = prev ;
        prev = curr;
        curr = temp;
        }
    }
}