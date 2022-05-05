package leetcode.april.easy;

public class IntersectionTwoLinkedLists {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode a = headA;
        ListNode b = headB;
        int ai = 1;
        int bi = 1;

        // Calculate Length of each node
        while (a.next!=null) {
            a = a.next;
            ai++;
        }
        a = headA;

        // Calculate Length of each node
        while (b.next!=null) {
            b = b.next;
            bi++;
        }
        b = headB;

        // Calculate the length difference between 2 nodes
        int prerun = Math.abs(ai-bi);
        ListNode biggerNode;
        ListNode shorterNode;

        // Assign bigger and smaller nodes
        if(bi>ai) {
            biggerNode = b;
            shorterNode = a;
        } else {
            biggerNode = a;
            shorterNode = b;
        }

        // Pre run the bigger node with pre-run index so that both nodes have same length left after this loop is done
        while (prerun>0) {
            biggerNode = biggerNode.next;
            prerun--;
        }

        // Now check when both nodes are getting the same reference. That is the point of intersection
        while (biggerNode!=shorterNode) {
            biggerNode = biggerNode.next;
            shorterNode = shorterNode.next;
        }
        return shorterNode;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

}
