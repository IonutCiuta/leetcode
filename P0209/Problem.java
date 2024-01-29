class Solution {
    public int minSubArrayLen(int target, int[] n) {
        int minLen = Integer.MAX_VALUE;

        int i = 0;
        int j = 0;
        int sum = 0;
        while (i < n.length && j < n.length) {
            if (sum + n[j] >= target) {
                minLen = Math.min(minLen, j - i + 1);
                sum -= n[i];
                i++;
                continue;
            } else {
                sum += n[j++];
            }
        }

        if (minLen == Integer.MAX_VALUE) {
            return 0;
        }

        return minLen;
    }
}