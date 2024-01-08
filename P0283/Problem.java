class Solution {
    public void moveZeroes(int[] n) {
        int curr = 0;
        while(curr < n.length && n[curr] != 0) {
            curr += 1;
        }
        int next = curr + 1;
        while(next < n.length && n[next] == 0) {
            next += 1;
        }
        while (curr < n.length && next < n.length) {
            if (n[curr] == 0) {
                n[curr] = n[next];
                n[next] = 0;
                while(next < n.length && n[next] == 0) {
                    next += 1;
                }
            }
            curr += 1;
        }
    }
}