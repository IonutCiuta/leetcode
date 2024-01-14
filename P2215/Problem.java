class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        var set1 = new HashSet<Integer>();
        for (int i : nums1) set1.add(i);

        var set2 = new HashSet<Integer>();
        for (int i : nums2) set2.add(i);

        var list1 = new ArrayList<Integer>();
        for (int i : set1) {
            if (!set2.contains(i)) list1.add(i);
        }

        var list2 = new ArrayList<Integer>();
        for (int i : set2) {
            if (!set1.contains(i)) list2.add(i);
        }

        return List.of(list1, list2);
    }
}