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
    public boolean isPalindrome(ListNode head) {

        if (head == null || head.next == null) return true;

        ListNode mid = middleNode(head);
        ListNode headSecond = reverseList(mid);
        ListNode rereversehead = headSecond;

        while (head != null && headSecond != null) {

            
            if (head.val != headSecond.val) {
                reverseList(rereversehead); 
                return false;
            }

            head = head.next;
            headSecond = headSecond.next;
        }

        
        reverseList(rereversehead);

        return true; 
    }

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
