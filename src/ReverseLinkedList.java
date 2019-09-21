import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://practice.geeksforgeeks.org/problems/reverse-a-linked-list/1
 */

public class ReverseLinkedList {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.valueOf(reader.readLine());
        while (testCases-- > 0) {
            int size = Integer.valueOf(reader.readLine());
            String[] strs = reader.readLine().trim().split(" ");
            Node head = new Node(Integer.valueOf(strs[0]));
            Node indexedNode = head;
            for (int i = 1; i < size; i++) {
                Node temp = new Node(Integer.valueOf(strs[i]));
                indexedNode.next = temp;
                indexedNode = temp;
            }
            ReverseLL reverseLL = new ReverseLL();
            Node reversedHead = reverseLL.reverseList(head);
            System.out.println("Here");
        }

    }
}

class Node {
    int data;
    Node next;
    Node(int d) {
        data = d;
        next = null;
    }
}

class ReverseLL {

    // Reverse the linkedList
    Node head = null;
    Node reverseList(Node head) {
        reverse(head);
        return this.head;
    }

    Node reverse(Node head) {
        if(head.next==null) {
            this.head = head;
            return head;
        }
        Node node = reverse(head.next);
        node.next = head;
        head.next=null;
        return head;
    }
}
