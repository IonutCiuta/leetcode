class Solution {
    public int[] findErrorNums(int[] nums) {
        var unique = new HashSet<Integer>();
        Integer duplicate = null;
        var sum = 0;
        for (var n : nums) {
            if (unique.contains(n)) {
                duplicate = n;
            } else {
                unique.add(n);
                sum += n;
            }
        }

        var len = nums.length;
        var fullSum = (len * (len + 1)) / 2;
        var missing = fullSum - sum;

        return new int[] { duplicate, missing };
    }
}