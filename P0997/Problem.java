class Solution {
    public int findJudge(int n, int[][] trust) {
        var inbound = new int[n];
        for (int i = 0; i < trust.length; i++) {
            inbound[trust[i][0] - 1]--;
            inbound[trust[i][1] - 1]++;
        }

        for (int i = 0; i < n; i++) {
            if (inbound[i] == n - 1) {
                return i + 1;
            }
        }

        return -1;
    }
}