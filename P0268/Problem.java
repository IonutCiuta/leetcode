class Solution {
    public int missingNumber(int[] nums) {
        int sum = 0;
        int max = -1;
        boolean zeroFound = false;

        for (int n : nums) {
            zeroFound = zeroFound || (n == 0);
            max = Math.max(max, n);
            sum += n;
        }

        if (zeroFound) {
            var expectedSum = (max * (max + 1))/2;
            if (expectedSum == sum) return nums.length;
            return expectedSum - sum;
        }

        return 0;
    }
}