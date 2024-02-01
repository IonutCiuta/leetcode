class Solution {
    public boolean containsNearbyDuplicate(int[] n, int k) {
        var map = new HashMap<Integer, List<Integer>>();

        for (int i = 0; i < n.length; i++) {
            var occ = map.get(n[i]);
            if (occ == null) {
                var newOcc = new ArrayList<Integer>();
                newOcc.add(i);
                map.put(n[i], newOcc);
            } else {
                for (int j : occ) {
                    if (Math.abs(i - j) <= k) {
                        return true;
                    }
                }
                occ.add(i);
            }
        }

        return false;
    }
}