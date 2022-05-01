package leetcode.april.easy;

/**
 * https://leetcode.com/problems/merge-two-sorted-lists/submissions
 */
public class MergeTwoSortedLists {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1==null) return list2;
        if(list2==null) return list1;
        ListNode head = new ListNode(0);
        ListNode node = new ListNode(0);
        head.next = node;
        while (list1 != null || list2 != null) {
            if (list1==null) {
                node.next = list2;
                list2 = list2.next;
            } else if(list2==null) {
                node.next = list1;
                list1 = list1.next;
            } else if(list1.val > list2.val) {
                node.next = list2;
                list2 = list2.next;
            } else {
                node.next = list1;
                list1 = list1.next;
            }
            node = node.next;
        }
        return head.next.next;
    }

    public static void main(String[] args) {

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
