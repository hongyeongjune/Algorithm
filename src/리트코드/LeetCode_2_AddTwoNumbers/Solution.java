package 리트코드.LeetCode_2_AddTwoNumbers;

public class Solution {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        int roundUp = 0;
        ListNode head = new ListNode(0);
        ListNode listNode = head;
        while (l1 != null || l2 != null) {
            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;

            int sum = (roundUp + x + y);
            roundUp = sum / 10;
            listNode.next = new ListNode(sum % 10);
            listNode = listNode.next;

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        if (roundUp > 0)
            listNode.next = new ListNode(roundUp);

        return head.next;
    }
}
