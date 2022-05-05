package leetcode.april.easy;

/**
 * https://leetcode.com/problems/remove-linked-list-elements
 * 1) Check if head is null. If its null return null
 * 2) Create a new zero node which will be in front of head node.
 * 3) Assign Zero noe to be previous node and current node to be head
 * 4) If currentNode.val == val then removeCurrentNode and assign next of previous to be next of current
 * 5) Increment next node to from currentNode
 * 6) return zero.next as it was the head.
 */
public class RemoveLinkedListElements {

    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return null;
        ListNode zero = new ListNode(0);
        zero.next = head;
        ListNode previousNode = zero;
        ListNode currentNode = head;
        while (currentNode!=null) {
            if (currentNode.val == val) {
                removeCurrentNode(previousNode, currentNode);
            } else {
                previousNode = currentNode;
            }
            currentNode = currentNode.next;
        }
        return zero.next;
    }

    public void removeCurrentNode(ListNode previousNode, ListNode currentNode) {
        previousNode.next = currentNode.next;
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
