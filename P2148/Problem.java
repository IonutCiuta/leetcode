class Solution {
    public String[] sortPeople(String[] names, int[] height) {
        var heightNameMap = new HashMap<Integer, String>();
        var len = names.length;
        for (int i = 0; i < len; i++) {
            heightNameMap.put(height[i], names[i]);
        }

        Arrays.sort(height);

        for (int i = len - 1; i >= 0; i--) {
            names[len - i - 1] = heightNameMap.get(height[i]);
        }

        return names;
    }
}