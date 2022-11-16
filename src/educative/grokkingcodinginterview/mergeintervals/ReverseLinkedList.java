package educative.grokkingcodinginterview.mergeintervals;

import java.util.Arrays;
import java.util.List;

public class ReverseLinkedList {

    public static LinkedListNode reverse(LinkedListNode head) {
        if(head == null) {
            return head;
        }
        LinkedListNode previous = null;
        LinkedListNode next = head.next;
        while (head!=null) {
            // swap linkages now
            head.next = previous;
            previous = head;
            head = next;
            if(next!=null) {
                next = next.next;
            }
        }

        return previous;
    }

    public static void main(String[] args) {
        // Declaring and creating a linked list
        LinkedListComplete obj1 = new LinkedListComplete();
        List<Integer> InputList = Arrays.asList(-1, -5, -3, -7, -8, -6, -2);
        // Creating Linked Lists
        obj1.createLinkedList(InputList);
        // Displaying original linked list
        System.out.print("The original linked list: ");
        PrintList.printListWithForwardArrow(obj1.head);
        LinkedListNode result = reverse(obj1.head);
        System.out.print("\nThe reversed linked list:  ");
        PrintList.printListWithForwardArrow(result);
    }

}

class LinkedListNode {
    public int data;
    public LinkedListNode next;

    // Constructor will be used to make a LinkedListNode type object
    public LinkedListNode(int data) {
        this.data = data;
        this.next = null;
    }
}

class PrintList {
    public static void printListWithForwardArrow(LinkedListNode head) {
        LinkedListNode temp = head;

        while (temp != null) {
            System.out.print(temp.data); // print node value
            temp = temp.next;
            if (temp != null) {
                System.out.print(" → ");
            }
        }
        // if this is the last node, print null at the end
        System.out.print(" → null ");
    }
}

class LinkedListComplete {
    public LinkedListNode head;

    // LinkedListComplete() will be used to make a LinkedListComplete type object.
    public LinkedListComplete() {
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
