class Solution {
    public boolean canJump(int[] nums) {
        var len = nums.length;
        var dp = new boolean[len];
        dp[len - 1] = true;

        for (int i = len - 2; i >= 0; i--) {
            for (int j = 1; j <= nums[i]; j++) {
                if (i + j < len && dp[i + j]) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[0];
    }
}