package leetcode.medium;

public class SwappingNodesLinkedList {

    public ListNode swapNodes(ListNode head, int k) {
        ListNode firstNode = head;
        ListNode secondNode = head;
        ListNode originalHead = head;

        for(int i=0;i<k-1;i++) {
            firstNode = firstNode.next;
        }

        int index = 0;
        while (head!=null) {
            if(index==k-1) {
                secondNode = originalHead;
            } else if(index>k-1) {
                secondNode = secondNode.next;
            }
            head = head.next;
            index++;
        }

        int temp = firstNode.val;
        firstNode.val = secondNode.val;
        secondNode.val = temp;
        return originalHead;
    }

    public void print(ListNode head) {
        while (head.next != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}

class ListNode {
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
