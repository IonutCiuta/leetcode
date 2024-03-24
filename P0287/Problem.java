class Solution {
    public int findDuplicate(int[] nums) {
        var len = nums.length;
        var seen = new boolean[len];

        for (int i = 0; i < len; i++) {
            var n = nums[i];
            if (seen[n - 1]) return n;
            seen[n - 1] = true;
        }

        return -1;
    }
}