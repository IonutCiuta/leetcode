class Solution {
    fun findMin(nums: IntArray): Int {
        var left = 0;
        var right = nums.size - 1;
        var min = 5000;

        while (left <= right) {
            
            if (nums[left] < nums[right]) {
                return if (nums[left] < min) nums[left] else min;
            }

            val mid = (left + right) / 2;
            min = if (nums[mid] < min) nums[mid] else min;

            if (nums[left] <= nums[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return min;
    }
}
