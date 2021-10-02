package leetcode.medium;

/**
 * https://leetcode.com/problems/swap-nodes-in-pairs/
 */
public class SwapNodesInPairs {

    public ListNode swapPairs(ListNode head) {
        ListNode listNode = new ListNode(0);
        listNode.next = head;
        while (head !=null && head.next!=null) {
            int tmp = head.val;
             head.val = head.next.val;
             head.next.val = tmp;
             head = head.next.next;
        }
        return listNode.next;
    }

}
