class Solution {

    public int minOperations(int[] nums) {
        var numToOccMap = new HashMap<Integer, Integer>();

        for (int n : nums) {
            var occ = numToOccMap.get(n);
            if (occ == null) numToOccMap.put(n, 1);
            else numToOccMap.put(n, occ + 1);
        }

        int ops = 0;
        for (var numOcc : numToOccMap.entrySet()) {
            var n = numOcc.getKey();
            var occ = numOcc.getValue();
            if (occ == 1)
                return -1;

            while (occ > 0) {
                var mod3 = occ % 3;
                if (mod3 == 0) {
                    ops += (occ / 3);
                    break;
                }

                if (mod3 == 2) {
                    ops += 1;
                    ops += (occ / 3);
                    break;
                }

                if (mod3 == 1) {
                    ops += 1;
                    occ = occ - 2;
                }
            }
        }

        return ops;
    }
}