class Solution {
    public int majorityElement(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        int max = 0;
        var seen = new HashMap<Integer, Integer>();

        var major = 0;
        var threshold = nums.length / 2;
        for (int i = 0; i < nums.length; i++) {
            var occ = seen.get(nums[i]);
            if (occ == null) {
                seen.put(nums[i], 1);
            } else {
                occ++;
                if (occ > threshold) {
                    major = nums[i];
                }
                seen.put(nums[i], occ);
            }
        }
        return major;
    }
}