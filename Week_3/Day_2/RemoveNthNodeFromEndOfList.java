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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null) {
            return null;
        }
        ListNode temp = head;
        int length = getLength(head);
        if(n == length) {
            return head.next;
        }
        int index = length - n + 1;

        for(int i = 1; i < index - 1; i++) {
            temp = temp.next;
        }
        temp.next = temp.next.next;
    
    return head;
    }
    private int getLength(ListNode node) {
        int count = 1;
        ListNode temp = node;
        while(temp.next != null) {
            temp = temp.next;
            count ++;
        }
        return count;

    }
}
