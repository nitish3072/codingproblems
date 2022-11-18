package educative.grokkingcodinginterview.mergeintervals;

import java.util.Arrays;
import java.util.List;

public class ReverseKGroupLinkedList {

    public static LinkedListNode reverseLinkedList(LinkedListNode head, int k) {
        // Find length of LinkedList
        int n = 0;
        for (LinkedListNode i = head; i != null; n++, i = i.next);
        LinkedListNode beforeHead = new LinkedListNode(0);
        beforeHead.next = head;
        LinkedListNode currentNode = head;
        LinkedListNode previousNode = beforeHead;
        LinkedListNode nextNode = head.next;
        for(int i=1; i<=n; i = i + k) {
            if(i+k-1>n) {
                continue;
            }
            LinkedListNode currentNodeInternal = currentNode;
            LinkedListNode previousNodeInternal = previousNode;
            LinkedListNode nextNodeInternal = nextNode;
            for (int j = 1; j <= k; j++) {
                // swap linkages now
                currentNodeInternal.next = previousNodeInternal;
                previousNodeInternal = currentNodeInternal;
                currentNodeInternal = nextNodeInternal;
                if(nextNodeInternal!=null) {
                    nextNodeInternal = nextNodeInternal.next;
                }
            }
            previousNode.next = previousNodeInternal;
            currentNode.next = currentNodeInternal;
            previousNode = currentNode;
            nextNode = nextNodeInternal;
            currentNode = currentNodeInternal;
        }
        return beforeHead.next;
    }

    public static void main(String[] args) {
        List<Integer> inputList = Arrays.asList(1,2);
        LinkedList inputLinkedList = new LinkedList();
        inputLinkedList.createLinkedList(inputList);
        // Displaying original linked list
        System.out.print("The original linked list: ");
        PrintList.printListWithForwardArrow(inputLinkedList.head);
        LinkedListNode result = reverseLinkedList(inputLinkedList.head, 2);
        System.out.print("\nReversed linked list, with k = " + 2 + ": ");
        PrintList.printListWithForwardArrow(result);
    }

    static class LinkedList {
        public LinkedListNode head;

        // LinkedList() will be used to make a LinkedList type object.
        public LinkedList() {
            this.head = null;
        }

        // insert_node_at_head method will insert a LinkedListNode at head
        // of a linked list.
        public void insertNodeAtHead(LinkedListNode node) {
            if (this.head == null) {
                this.head = node;
            } else {
                node.next = this.head;
                this.head = node;
            }
        }

        // create_linked_list method will create the linked list using the
        // given integer array with the help of InsertAthead method.
        public void createLinkedList(List<Integer> lst) {
            for (int i = lst.size() - 1; i >= 0; i--) {
                LinkedListNode newNode = new LinkedListNode(lst.get(i));
                insertNodeAtHead(newNode);
            }
        }
    }

}

