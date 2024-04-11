class Solution {
    public int singleNumber(int[] nums) {
        var seen = new HashMap<Integer, Integer>();

        for (int n : nums) {
            var occ = seen.get(n);
            if (occ == null) {
                seen.put(n, 1);
            } else {
                seen.put(n, occ + 1);
            }
        }

        for (var n : seen.entrySet()) {
            if (n.getValue() == 1) {
                return n.getKey();
            }
        }

        return -1;
    }
}