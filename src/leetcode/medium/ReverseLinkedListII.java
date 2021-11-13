package leetcode.medium;

/**
 * https://leetcode.com/problems/reverse-linked-list-ii/
 */
public class ReverseLinkedListII {

    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode startNode = new ListNode(0);
        startNode.next = head;
        ListNode beforeStart = startNode;
        int index = 0;
        for(; index<left-1; index++) {
            beforeStart = head;
            head = head.next;
        }
        ListNode reverse = null;
        for(; index<=right-1; index++) {
            ListNode temp = new ListNode(head.val);
            temp.next = reverse;
            reverse = temp;
            head = head.next;
        }
        beforeStart.next = reverse;
        for(int i=0; i<right-left; i++) {
            reverse = reverse.next;
        }
        reverse.next = head;
        return startNode.next;
    }

    public static void main(String[] args) {

    }
}
