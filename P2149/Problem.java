class Solution {
    public int[] rearrangeArray(int[] nums) {
        var pos = new ArrayList<Integer>();
        var neg = new ArrayList<Integer>();

        for (int n : nums) {
            if (n > 0) pos.add(n);
            else neg.add(n);
        }

        for (int i = 0; i < pos.size(); i++) {
            nums[2 * i] = pos.get(i);
            nums[2 * i + 1] = neg.get(i);
        }

        return nums;
    }
}