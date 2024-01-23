class Solution {
    public int removeElement(int[] nums, int val) {
        int i = 0;
        int j = 1;
        int k = 0;

        while (i < nums.length) {
            if (nums[i] != val) {
                k++;
            } else {
                while (j < nums.length && nums[j] == val) {
                    j++;
                }

                if (j < nums.length) {
                    nums[i] = nums[j];
                    nums[j] = val;
                    k++;
                }
            }
            j++;
            i++;
        }

        return k;
    }
}