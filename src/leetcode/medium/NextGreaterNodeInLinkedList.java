package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode.com/problems/next-greater-node-in-linked-list/
 */
public class NextGreaterNodeInLinkedList {

    public int[] nextLargerNodes(ListNodeNextGreaterNodeInLinkedList head) {
        List<Integer> list = new ArrayList<>();
        while (head!=null) {
            list.add(head.val);
            head = head.next;
        }
        int[] res = new int[list.size()];
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<list.size(); i++) {
            while (!stack.isEmpty() && list.get(stack.peek()) < list.get(i)) {
               res[stack.pop()] = list.get(i);
            }
            stack.add(i);
        }
        return res;
    }

    public static void main(String[] args) {
        NextGreaterNodeInLinkedList nextGreaterNodeInLinkedList = new NextGreaterNodeInLinkedList();
        ListNodeNextGreaterNodeInLinkedList next2 = new ListNodeNextGreaterNodeInLinkedList(5);
        ListNodeNextGreaterNodeInLinkedList next1 = new ListNodeNextGreaterNodeInLinkedList(1, next2);
        ListNodeNextGreaterNodeInLinkedList head = new ListNodeNextGreaterNodeInLinkedList(2, next1);
        System.out.println(Arrays.toString(nextGreaterNodeInLinkedList.nextLargerNodes(head)));
    }

}


class ListNodeNextGreaterNodeInLinkedList {

    int val;
    ListNodeNextGreaterNodeInLinkedList next;

    ListNodeNextGreaterNodeInLinkedList() {
    }

    ListNodeNextGreaterNodeInLinkedList(int val) {
        this.val = val;
    }

    ListNodeNextGreaterNodeInLinkedList(int val, ListNodeNextGreaterNodeInLinkedList next) {
        this.val = val;
        this.next = next;
    }
}
