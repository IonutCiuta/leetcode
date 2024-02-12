class Solution {
    public int maxOperations(int[] nums, int k) {
        var diffs = new HashMap<Integer, Integer>();
        int pairs = 0;

        for (int i : nums) {
            int diff = k - i;
            var occs = diffs.get(diff);
            if (occs != null && occs > 0) {
                pairs++;
                diffs.put(diff, occs - 1);
            } else {
                var keyOcc = diffs.get(i);
                if (keyOcc != null) {
                    diffs.put(i, keyOcc + 1);
                } else {
                    diffs.put(i, 1);
                }
            }
        }
        return pairs;
    }
}