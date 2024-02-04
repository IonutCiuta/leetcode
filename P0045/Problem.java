class Solution {
    public int jump(int[] n) {
        var len = n.length;
        var dp = new int[len];
        dp[len - 1] = 0;
        var minJumpsIdx = len - 1;

        for (int i = len - 2; i >= 0; i--) {
            // if 0 we can't jump
            if (n[i] == 0) {
                dp[i] = 0;
                continue;a
            }

            // if we can jump longer than len, than we can actually
            // get to len in 1 jump 
            if (i + n[i] >= len - 1) {
                dp[i] = 1;
                continue;
            }

            // if none of the above work, we should search for the prev min jumps
            var min = Integer.MAX_VALUE;
            for (int j = 1; j <= n[i]; j++) {
                if (dp[i + j] > 0)
                    min = Math.min(min, dp[i + j]);
            }
            dp[i] = min + 1;
        }


        return dp[0];
    }
}