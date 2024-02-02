class Solution {
    public int removeDuplicates(int[] nums) {
        int r = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[r++] = nums[i];
            }
        }
        return r;
    }
}