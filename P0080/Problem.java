class Solution {
    public int removeDuplicates(int[] nums) {
        var seen = new HashMap<Integer, Integer>();
        int r = 0;
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            var n = nums[i];
            var occ = seen.get(n);

            if (occ == null) {
                nums[r++] = n;
                seen.put(n, 1);
                k++;
                continue;
            }

            if (occ == 1) {
                nums[r++] = n;
                seen.put(n, 2);
                k++;
            }
        }

        return k;
    }
}