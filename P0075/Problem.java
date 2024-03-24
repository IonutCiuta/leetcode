class Solution {
    public void sortColors(int[] nums) {
        int r = 0;
        int w = 0;
        int b = 0;

        for (int n : nums) {
            if (n == 0) r++;
            if (n == 1) w++;
            if (n == 2) b++;
        }

        int whiteLimit = r + w;
        for (int i = 0; i < nums.length; i++) {
            if (i < r) {
                nums[i] = 0;
            } else if (i < whiteLimit) {
                nums[i] = 1;
            } else {
                nums[i] = 2;
            }
        }
    }
}