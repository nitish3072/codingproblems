package educative.grokkingcodinginterview.mergeintervals;

public class ReverseLinkedListPosition {
    public static LinkedListNode reverseBetween(LinkedListNode head, int left, int right) {
        LinkedListNode beforeHead = new LinkedListNode(0);
        beforeHead.next = head;
        LinkedListNode currentNode = head;
        LinkedListNode previousNode = beforeHead;
        LinkedListNode nextNode = head.next;
        for (int i = 0; i < left - 1; i++) {
            previousNode = currentNode;
            currentNode = nextNode;
            if (nextNode != null) {
                nextNode = nextNode.next;
            }
        }
        LinkedListNode currentNodeInternal = currentNode;
        LinkedListNode previousNodeInternal = previousNode;
        LinkedListNode nextNodeInternal = nextNode;
        for (int i = left - 1; i <= right - 1; i++) {
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
        int[] left = {1, 3, 2, 1, 1};
        int[] right = {5, 6, 4, 3, 2};
        for (int i = 0; i < input.length; i++) {
            System.out.print(i + 1);
            LinkedList<Integer> list = new LinkedList<Integer>();
            list.createLinkedList(input[i]);
            System.out.print(".\tOriginal linked list is:  ");
            PrintList printList = new PrintList();
            printList.printListWithForwardArrow(list.head);
            System.out.print("\tReversed linked list is:  ");
            printList.printListWithForwardArrow(reverseBetween(list.head, left[i], right[i]));
        }
    }


    public static class PrintList {
        public void printListWithForwardArrow(LinkedListNode head) {
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