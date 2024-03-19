class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        var uniqueIds = new HashSet<Integer>();

        var nums1Map = new HashMap<Integer, Integer>();
        for (var arr : nums1) {
            nums1Map.put(arr[0], arr[1]);
            uniqueIds.add(arr[0]);
        }

        var nums2Map = new HashMap<Integer, Integer>();
        for (var arr : nums2) {
            nums2Map.put(arr[0], arr[1]);
            uniqueIds.add(arr[0]);
        }

        var ids = new ArrayList<Integer>();
        for (var id : uniqueIds) ids.add(id);

        Collections.sort(ids);

        var r = new int[ids.size()][2];

        for (int i = 0; i < ids.size(); i++) {
            var id = ids.get(i);
            var e = new int[2];
            e[0] = id;

            var n1Val = nums1Map.get(id);
            if (n1Val != null) e[1] += n1Val;

            var n2Val = nums2Map.get(id);
            if (n2Val != null) e[1] += n2Val;

            r[i] = e;
        }

        return r;
    }
}