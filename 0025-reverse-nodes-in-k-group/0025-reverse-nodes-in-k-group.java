class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) {
            return head;
        }

        // Dummy node to handle head reversal
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prevGroupEnd = dummy;

        while (true) {
            // Find the k-th node
            ListNode kth = getKthNode(prevGroupEnd, k);
            if (kth == null) {
                break;
            }

            ListNode nextGroupStart = kth.next;

            // Reverse current group
            ListNode prev = nextGroupStart;
            ListNode curr = prevGroupEnd.next;

            while (curr != nextGroupStart) {
                ListNode temp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = temp;
            }

            // Connect with previous part
            ListNode temp = prevGroupEnd.next;
            prevGroupEnd.next = kth;
            prevGroupEnd = temp;
        }

        return dummy.next;
    }

    // Helper to find k-th node
    private ListNode getKthNode(ListNode curr, int k) {
        while (curr != null && k > 0) {
            curr = curr.next;
            k--;
        }
        return curr;
    }
}