import java.util.*;

class Solution {
    public int longestSubarray(int[] nums, int limit) {
        Deque<Integer> maxDq = new ArrayDeque<>(); // decreasing (stores indices)
        Deque<Integer> minDq = new ArrayDeque<>(); // increasing (stores indices)

        int left = 0;
        int ans = 0;

        for (int right = 0; right < nums.length; right++) {

            // Maintain max deque (decreasing)
            while (!maxDq.isEmpty() && nums[maxDq.peekLast()] < nums[right]) {
                maxDq.pollLast();
            }
            maxDq.offerLast(right);

            // Maintain min deque (increasing)
            while (!minDq.isEmpty() && nums[minDq.peekLast()] > nums[right]) {
                minDq.pollLast();
            }
            minDq.offerLast(right);

            // Shrink window if condition violated
            while (nums[maxDq.peekFirst()] - nums[minDq.peekFirst()] > limit) {
                if (maxDq.peekFirst() == left) maxDq.pollFirst();
                if (minDq.peekFirst() == left) minDq.pollFirst();
                left++;
            }

            ans = Math.max(ans, right - left + 1);
        }

        return ans;
    }
}