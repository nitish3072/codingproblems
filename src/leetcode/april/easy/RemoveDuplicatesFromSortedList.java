package leetcode.april.easy;

/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list
 */
public class RemoveDuplicatesFromSortedList {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode originalHead = new ListNode(-200);
        originalHead.next = head;
        ListNode previousNode = originalHead;
        while (head != null) {
            if (previousNode.val == head.val) {
                previousNode.next = head.next;
            } else {
                previousNode = head;
            }
            head = head.next;
        }
        return originalHead.next;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

}
