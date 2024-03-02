class Solution {
    public int[] sortedSquares(int[] nums) {
        var len = nums.length;
        int i = 0;
        int j = len - 1;

        var r = new int[len];
        int k = len - 1;

        while (i <= j) {
            var left = nums[i] * nums[i];
            var right = nums[j] * nums[j];

            if (left == right) {
                if (i != j) {
                    r[k--] = left;
                    r[k--] = right;
                } else {
                    r[k--] = right;
                }
                i++;
                j--;
                continue;
            }

            if (left < right) {
                r[k--] = right;
                j--;
            } else {
                r[k--] = left;
                i++;
            }
        }

        return r;
    }
}