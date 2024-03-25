class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        var cache = new boolean[nums.length];
        var doubles = new ArrayList<Integer>();

        for (var n : nums) {
            if (!cache[n - 1]) {
                cache[n - 1] = true;
            } else {
                doubles.add(n);
            }
        }

        return doubles;
    }
}