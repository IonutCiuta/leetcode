class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        var len = nums.length;
        var max = 0;

        int i = 0;
        int j = 0;
        while (i < len) {
            if (nums[i] == 1) {
                int ones = 1;
                j = i + 1;
                while (j < len && nums[j] == 1) {
                    ones++;
                    j++;
                }
                max = Math.max(max, ones);
                i = j;
            } else {
                i++;
            }
        }
        return max;
    }
}