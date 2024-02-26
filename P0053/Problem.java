class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int maxCurrentSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int n = nums[i];
            maxCurrentSum = Math.max(maxCurrentSum + n, n);
            maxSum = Math.max(maxSum, maxCurrentSum);
        }

        return maxSum;
    }
}