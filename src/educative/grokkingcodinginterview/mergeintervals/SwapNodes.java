package educative.grokkingcodinginterview.mergeintervals;

import java.util.List;

public class SwapNodes {

    public static LinkedListNode swapNodes(LinkedListNode head, int k) {
        LinkedListNode beforeHead = new LinkedListNode(0);
        beforeHead.next = head;

        // Find kth elements from start
        LinkedListNode kNodeFirst = head;
        LinkedListNode kNodeFirstPrevious = beforeHead;
        for(int i=1; i<=k-1; i++) {
            kNodeFirst = kNodeFirst.next;
            kNodeFirstPrevious = kNodeFirstPrevious.next;
        }

        // Find kth elements from end
        LinkedListNode kNodeLast = head;
        LinkedListNode kNodeLastPrevious = beforeHead;
        LinkedListNode node = kNodeFirst;
        while (node.next != null) {
            kNodeLast = kNodeLast.next;
            kNodeLastPrevious = kNodeLastPrevious.next;
            node = node.next;
        }

        // Swap the 2 kth elements now
        int valueFirst = kNodeFirst.data;
        int valueLast = kNodeLast.data;
        kNodeFirst.data = valueLast;
        kNodeLast.data = valueFirst;
        return beforeHead.next;
    }

    public static void main(String[] args) {

        int[][] input = {
                {1, 2, 3, 4, 5, 6, 7},
                {6, 9, 3, 10, 7, 4, 6},
                {6, 9, 3, 4},
                {6, 2, 3, 6, 9},
                {6, 2}
        };
        int[] k = {
                2, 3, 2, 3, 1
        };
        for (int i = 0; i < input.length; i++) {
            System.out.print(i + 1);
            LinkedList<Integer> list = new LinkedList<Integer>();
            list.createLinkedList(input[i]);
            System.out.print(".\tOriginal linked list is: ");
            PrintList.printListWithForwardArrow(list.head);
            System.out.println("\tk: " + k[i]);
            System.out.print("\tLinked list with swapped values: ");
            PrintList.printListWithForwardArrow(swapNodes(list.head, k[i]));
        }

    }


    public static class PrintList {
        public static void printListWithForwardArrow(LinkedListNode head) {
            LinkedListNode temp = head;

            while (temp != null) {
                System.out.print(temp.data); // print node value
                temp = temp.next;
                if (temp != null) {
                    System.out.print(" → ");
                } else {
                    // if this is the last node, print null at the end
                    System.out.print(" → null \n ");
                }

            }


        }
    }

    static class LinkedList<T> {
        public LinkedListNode head;

        // constructor will be used to make a LinkedList type object
        public LinkedList() {
            this.head = null;
        }

        // insertNodeAtHead method will insert a LinkedListNode at head
        // of a linked list.
        public void insertNodeAtHead(LinkedListNode node) {
            if (this.head == null) {
                this.head = node;
            } else {
                node.next = this.head;
                this.head = node;
            }
        }

        // createLinkedList method will create the linked list using the
        // given integer array with the help of InsertAthead method.
        public void createLinkedList(int[] lst) {
            for (int i = lst.length - 1; i >= 0; i--) {
                LinkedListNode newNode = new LinkedListNode(lst[i]);
                insertNodeAtHead(newNode);
            }
        }

    }

}
