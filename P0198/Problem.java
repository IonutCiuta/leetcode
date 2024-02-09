class Solution {
    public int rob(int[] houses) {
        var len = houses.length;

        if (len == 0) return 0;

        if (len == 1) return houses[0];

        if (len == 2) return Math.max(houses[0], houses[1]);

        var loot = new int[len];
        loot[0] = houses[0];
        loot[1] = Math.max(houses[0], houses[1]);

        for (int i = 2; i < len; i++) {
            loot[i] = Math.max(
                    houses[i] + loot[i - 2], // add current house
                    loot[i - 1] // skip this house
            );
        }

        return loot[len - 1];
    }
}