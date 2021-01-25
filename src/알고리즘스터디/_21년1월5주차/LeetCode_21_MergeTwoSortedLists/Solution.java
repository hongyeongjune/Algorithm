package 알고리즘스터디._21년1월5주차.LeetCode_21_MergeTwoSortedLists;

public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        if (l1 == null) return l2;
        if (l2 == null) return l1;

        // 현재 값 비교

        if (l1.val < l2.val) {
            // l1.val 의 값이 더 작다면 l1.next 의 값에서 l1.next.val 과 l2.val 을 비교
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            // l1.val 의 값이 더 크다면 l2.next 의 값에서 l2.next.val 과 l1.val 을 비교
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

    public class ListNode {
        int val;
        ListNode next;

        public ListNode() {
        }

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}

