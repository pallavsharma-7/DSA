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
    public ListNode removeElements(ListNode head, int val) {

        if (head == null) {
            return null;
        }

        ListNode temp = head;
        ListNode prev = null;

        while (temp != null) {

            if (temp.val == val) {

                
                if (temp == head) {
                    head = temp.next;
                } else {
                    prev.next = temp.next;
                }

            } else {
                prev = temp;
            }

            temp = temp.next;
        }

        return head;
    }
}