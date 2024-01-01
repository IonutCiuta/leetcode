class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int maxSum = 0;
        for (int i = 0; i < k; i++) {
            maxSum += nums[i];
        }

        int prevSum = maxSum;
        int i = 0;
        for (int j = k; j < nums.length; j++) {
            int newSum = prevSum - nums[i];
            i += 1;
            newSum += nums[j];

            if (newSum > maxSum) {
                maxSum = newSum;
            }
            prevSum = newSum;
        }

        return (double) maxSum / k;
    }
}