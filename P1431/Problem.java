class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extra) {
        int max = -1;
        for (int i : candies) max = Math.max(i, max);

        var r = new ArrayList<Boolean>();
        for (int i : candies) r.add((i + extra) >= max);

        return r;
    }
}