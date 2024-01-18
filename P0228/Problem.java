class Solution {
    public List<String> summaryRanges(int[] nums) {
        var len = nums.length;
        if (len == 0) {
            return List.of();
        }

        var ranges = new ArrayList<String>();

        int start = 0;
        int i = 1;
        while (i < len) {
            var s = nums[start];
            var p = nums[i - 1];
            if (nums[i] - p != 1) {
                var sb = new StringBuilder().append(s);
                if (start != i - 1) {
                    sb.append("->").append(p);
                }
                ranges.add(sb.toString());
                start = i;
            }
            i++;
        }

        var s = nums[start];
        var sb = new StringBuilder().append(s);
        if (start != len - 1) {
            sb.append("->").append(nums[len - 1]);
        }
        ranges.add(sb.toString());
        return ranges;
    }
}