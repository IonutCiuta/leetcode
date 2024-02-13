class Solution {
    public int coinChange(int[] coins, int amount) {
        var cache = new Integer[amount];
        var r = changeWithMemo(coins, amount, cache);
        if (r == Integer.MAX_VALUE) return -1;
        return r;
    }

    int changeWithMemo(int[] coins, int amount, Integer[] cache) {
        if (amount < 0) return Integer.MAX_VALUE;

        if (amount == 0) return 0;

        if (cache[amount - 1] != null) {
            return cache[amount - 1];
        }

        int minCoins = Integer.MAX_VALUE;

        for (int i = 0; i < coins.length; i++) {
            var r = changeWithMemo(coins, amount - coins[i], cache);

            if (r < Integer.MAX_VALUE) {
                minCoins = Math.min(minCoins, r + 1);
            }
        }

        cache[amount - 1] = minCoins;
        return minCoins;
    }
}