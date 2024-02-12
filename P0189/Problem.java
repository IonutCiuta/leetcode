class Solution {
    public void rotate(int[] nums, int k) {
        var len = nums.length;
        var rot = k % len;

        var tail = new int[rot];
        int j = 0;
        for (int i = len - 1; i >= 0; i--) {
            if (j < rot) {
                tail[rot - j - 1] = nums[i];
                j++;
            } else {
                nums[i + j] = nums[i];
            }
        }

        for (int i = 0; i < rot; i++) {
            nums[i] = tail[i];
        }
    }
}