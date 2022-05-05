package leetcode.april.easy;

public class ReverseLinkedList {

    ListNode newHead = null;

    public ListNode reverseList(ListNode head) {
        if(head==null) return null;
        ListNode lastNode = backtrack(head);
        lastNode.next = null;
        return newHead;
    }

    public ListNode backtrack(ListNode node) {
        if (node.next == null) {
            newHead = node;
            return node;
        }
        ListNode nodeToBackTrack = node;
        ListNode nextNode = backtrack(node.next);
        nextNode.next = nodeToBackTrack;
        return nodeToBackTrack;
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
