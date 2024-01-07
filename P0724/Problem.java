class Solution {
    public int pivotIndex(int[] nums) {
        var total = 0;
        for (int i = 0; i < nums.length; i++) {
            total += nums[i];
        }

        var leftPrefixSum = 0;
        for (int i = 0; i < nums.length; i++) {
            var rightPrefixSum = total - leftPrefixSum - nums[i];
            if (leftPrefixSum == rightPrefixSum) {
                return i;
            }
            leftPrefixSum += nums[i];
        }
        return -1;
    }
}