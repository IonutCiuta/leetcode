class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }

        double maxAvg = sum / k;

        int i = 0;
        for (int j = k; j < nums.length; j++) {
            sum -= nums[i];
            i += 1;
            sum += nums[j];
            double newAvg = sum / k;
            if (newAvg > maxAvg) {
                maxAvg = newAvg;
            }
        }

        return maxAvg;
    }
}