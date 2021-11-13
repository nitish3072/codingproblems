package leetcode.medium;

/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/
 */
public class RemoveDuplicatesfromSortedListII {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode current = new ListNode(Integer.MAX_VALUE);
        ListNode newHead = current;
        current.next = head;


        ListNode firstDuplicateElementPrevious = null;
        int firstDuplicateElement = Integer.MIN_VALUE;
        while (current != null) {
            if ((current.next!=null && current.val == current.next.val)||(firstDuplicateElement!=Integer.MIN_VALUE && firstDuplicateElement==current.val)) {
                firstDuplicateElement = current.val;
                deleteCurrentAndNextElement(current, firstDuplicateElementPrevious);
            } else {
                firstDuplicateElementPrevious = current;
                firstDuplicateElement = Integer.MIN_VALUE;
            }
            current = current.next;
        }
        return newHead.next;
    }

    public void deleteCurrentAndNextElement(ListNode currentNode, ListNode previousNode) {
        previousNode.next = currentNode.next;
    }

//    public static void main(String[] args) {
//        int[] nums = {1,1,1,2,2,3};
//        RemoveDuplicatesfromSortedListII wordSearch = new RemoveDuplicatesfromSortedListII();
//        System.out.println(wordSearch.deleteDuplicates(nums));
//    }

}
