package leetcode.april.easy;

/**
 * https://leetcode.com/problems/linked-list-cycle
 * 1) If head is null or head.next is null then return false
 * 2) Make 2 runners. One runs at 1x and another at 2x. First runner at head and second one at head.next(this is why checking that head.next is not null in first step)
 * 3) If any point if the runners are null then it means there is no loop
 * 4) If for some point the runners are equal to each other then it means loop is present.
 */
public class LinkedListCycle {

    public boolean hasCycle(ListNode head) {
        if(head==null || head.next==null) return false;
        ListNode listNodeRunning1xSpeed = head;
        ListNode listNodeRunning2xSpeed = head.next;
        while (listNodeRunning1xSpeed!=listNodeRunning2xSpeed) {
            if(listNodeRunning1xSpeed.next==null || listNodeRunning2xSpeed.next==null || listNodeRunning2xSpeed.next.next ==null) {
                return false;
            }
            listNodeRunning1xSpeed = listNodeRunning1xSpeed.next;
            listNodeRunning2xSpeed = listNodeRunning2xSpeed.next.next;
        }
        return true;
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

