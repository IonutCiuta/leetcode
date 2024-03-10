class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        var set = new HashSet<Integer>();
        for (var n : nums1) set.add(n);

        var intsc = new ArrayList<Integer>();
        var seen = new HashSet<Integer>();
        for (var n : nums2) {
            if (set.contains(n) && !seen.contains(n)) {
                intsc.add(n);
                seen.add(n);
            }
        }

        var r = new int[intsc.size()];
        for (int i = 0; i < intsc.size(); i++)
            r[i] = intsc.get(i);

        return r;
    }
}