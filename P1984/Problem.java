class Solution {
    public int minimumDifference(int[] nums, int k) {
        if (k == 1) return 0;

        Arrays.sort(nums);

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - k + 1; i++) {
            var diff = nums[i + k - 1] - nums[i];
            min = Math.min(min, diff);
        }

        return min;
    }
}