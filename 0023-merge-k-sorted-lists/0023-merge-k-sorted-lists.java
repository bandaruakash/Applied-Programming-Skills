import java.util.PriorityQueue;

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        // Edge case
        if (lists == null || lists.length == 0) {
            return null;
        }

        // Min-heap to store nodes based on value
        PriorityQueue<ListNode> pq = new PriorityQueue<>(
            (a, b) -> a.val - b.val
        );

        // Add the head of each list to the heap
        for (ListNode node : lists) {
            if (node != null) {
                pq.offer(node);
            }
        }

        // Dummy node to build result
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;

        // Process heap
        while (!pq.isEmpty()) {
            ListNode minNode = pq.poll();
            current.next = minNode;
            current = current.next;

            if (minNode.next != null) {
                pq.offer(minNode.next);
            }
        }

        return dummy.next;
    }
}