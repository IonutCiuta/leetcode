class Solution {
    public int longestOnes(int[] n, int k) {
        int len = n.length;

        int i = 0;
        int max = -1;
        int ones = 0;
        int flips = k;
        int firstFlip = -1;

        while (i < len) {
            if (n[i] == 1) {
                ones++;
                i++;
            } else {
                if (flips > 0) {
                    if (firstFlip == -1) {
                        firstFlip = i;
                    }
                    flips--;
                    ones++;
                    i++;
                } else {
                    max = Math.max(ones, max);
                    if (firstFlip != -1) {
                        i = firstFlip + 1;
                    } else {
                        i++;
                    }
                    firstFlip = -1;
                    ones = 0;
                    flips = k;
                }
            }
        }

        max = Math.max(ones, max);
        return max;
    }
}