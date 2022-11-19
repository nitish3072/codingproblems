package educative.grokkingcodinginterview.mergeintervals;

import java.util.Arrays;
import java.util.List;

public class ReorderLinkedList {

    public static LinkedListNode reorderList(LinkedListNode head) {
        LinkedListNode beforeHead = new LinkedListNode(0);
        beforeHead.next = head;
        int n = 0;
        for (LinkedListNode i = head; i != null; n++, i = i.next);
        if(n==1) {
            return head;
        }
        LinkedListNode slow = beforeHead;
        for(int i=0; i<(n%2==0?n/2:n/2+1); i++) {
            slow = slow.next;
        }

        // Reverse Second Half
        // COnvert to 2 lists. One on the left and one the Right. So slow.next = null to break the list into 2.
        LinkedListNode current = slow.next;
        slow.next = null;
        LinkedListNode previous = null;
        LinkedListNode next = current.next;
        while (current!=null) {
            // swap linkages now
            current.next = previous;
            previous = current;
            current = next;
            if(next!=null) {
                next = next.next;
            }
        }

        while (previous!=null) {
            LinkedListNode tmpLeft = head.next;
            LinkedListNode tmpRight = previous.next;
            head.next = previous;
            previous.next = tmpLeft;
            head = tmpLeft;
            previous = tmpRight;
        }
        return beforeHead.next;
    }

    public static void main(String[] args) {
        // Declaring and creating a linked list
        LinkedList obj1 = new LinkedList();
        List<Integer> inputList = Arrays.asList(1, 1, 2, 2, 3, -1, 10, 12);
        // Creating Linked Lists
        obj1.createLinkedList(inputList);
        // Displaying original linked list
        System.out.print("1. Orignal list: ");
        PrintList.printListWithForwardArrow(obj1.head);
        // Calling the reorder_list function
        obj1.head = reorderList(obj1.head);
        // Displaying modified linked list
        System.out.print("   After folding: ");
        PrintList.printListWithForwardArrow(obj1.head);

        // Declaring and creating a linked list
        LinkedList obj2 = new LinkedList();
        List<Integer> inputList1 = Arrays.asList(10, 20, -22, 21, -12);
        // Creating Linked Lists
        obj2.createLinkedList(inputList1);
        // Displaying original linked list
        System.out.print("2. Orignal list: ");
        PrintList.printListWithForwardArrow(obj2.head);
        // Calling the reorder_list function
        obj2.head = reorderList(obj2.head);
        // Displaying modified linked list
        System.out.print("   After folding: ");
        PrintList.printListWithForwardArrow(obj2.head);

        // Declaring and creating a linked list
        LinkedList obj3 = new LinkedList();
        List<Integer> inputList2 = Arrays.asList(1, 1, 1);
        // Creating Linked Lists
        obj3.createLinkedList(inputList2);
        // Displaying original linked list
        System.out.print("3. Orignal list: ");
        PrintList.printListWithForwardArrow(obj3.head);
        // Calling the reorder_list function
        obj3.head = reorderList(obj3.head);
        // Displaying modified linked list
        System.out.print("   After folding: ");
        PrintList.printListWithForwardArrow(obj3.head);

        // Declaring and creating a linked list
        LinkedList obj4 = new LinkedList();
        List<Integer> inputList3 = Arrays.asList(-2, -5, -6, 0, -1, -4);
        // Creating Linked Lists
        obj4.createLinkedList(inputList3);
        // Displaying original linked list
        System.out.print("4. Orignal list: ");
        PrintList.printListWithForwardArrow(obj4.head);
        // Calling the reorder_list function
        obj4.head = reorderList(obj4.head);
        // Displaying modified linked list
        System.out.print("   After folding: ");
        PrintList.printListWithForwardArrow(obj4.head);

        // Declaring and creating a linked list
        LinkedList obj5 = new LinkedList();
        List<Integer> inputList4 = Arrays.asList(3, 1, 5, 7, -4, -2, -1, -6);
        // Creating Linked Lists
        obj5.createLinkedList(inputList4);
        // Displaying original linked list
        System.out.print("5. Orignal list: ");
        PrintList.printListWithForwardArrow(obj5.head);
        // Calling the reorder_list function
        obj5.head = reorderList(obj5.head);
        // Displaying modified linked list
        System.out.print("   After folding: ");
        PrintList.printListWithForwardArrow(obj5.head);
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
